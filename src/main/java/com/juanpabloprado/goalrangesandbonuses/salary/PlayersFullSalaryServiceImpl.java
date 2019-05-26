package com.juanpabloprado.goalrangesandbonuses.salary;

import com.juanpabloprado.goalrangesandbonuses.fc.Player;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PlayersFullSalaryServiceImpl implements PlayersFullSalaryService {

    private final PlayerFullMonthlySalaryCalculator calculator;

    public PlayersFullSalaryServiceImpl(PlayerFullMonthlySalaryCalculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public List<Player> calculateFullSalaries(List<Player> players) {

        Supplier<Stream<Player>> bluePlayersStreamSupplier = () -> players.stream().filter(p -> p.getEquipo() == Player.Equipo.AZUL);
        Supplier<Stream<Player>> redPlayersStreamSupplier = () -> players.stream().filter(p -> p.getEquipo() == Player.Equipo.ROJO);

        int blueGoalSum = bluePlayersStreamSupplier.get().mapToInt(Player::getGoles).sum();
        int redGoalSum = redPlayersStreamSupplier.get().mapToInt(Player::getGoles).sum();

        Stream<Player> bluePlayersStream = bluePlayersStreamSupplier.get().map(player -> calculateFullSalary(player, blueGoalSum));

        Stream<Player> redPlayersStream = redPlayersStreamSupplier.get().map(player -> calculateFullSalary(player, redGoalSum));

        Stream<Player> resultingStream = Stream.concat(bluePlayersStream, redPlayersStream);

        List<Player> playersRes =resultingStream.collect(Collectors.toList());


        System.out.println("Blue Goal sum: " + blueGoalSum);
        System.out.println("Red Goal sum: " + redGoalSum);
        System.out.println("Level sum: " + Level.getMinimumRequired());

        return playersRes;
    }

    private Player calculateFullSalary(Player player, int teamGoalSum) {
        int goalsPerMonth = Level.valueOf(player.getNivel().toUpperCase()).getGoalsPerMonth();
        BigDecimal fullSalary = calculator.calculateFullSalary(BigDecimal.valueOf(player.getSueldo()), BigDecimal.valueOf(player.getBono()), player.getGoles(), goalsPerMonth, teamGoalSum, Level.getMinimumRequired());
        Player p = new Player(player.getNombre(), player.getNivel(), player.getGoles(), player.getSueldo(), player.getBono(), player.getEquipo());
        p.setSueldoCompleto(fullSalary.intValue());
        return p;
    }
}
