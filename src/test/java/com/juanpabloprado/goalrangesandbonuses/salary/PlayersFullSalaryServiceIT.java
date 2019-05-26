package com.juanpabloprado.goalrangesandbonuses.salary;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.juanpabloprado.goalrangesandbonuses.GoalApp;
import com.juanpabloprado.goalrangesandbonuses.fc.Player;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {GoalApp.class})
public class PlayersFullSalaryServiceIT {

    @Autowired
    PlayersFullSalaryService playersFullSalaryService;
    @Autowired
    ObjectMapper objectMapper;

    private List<Player> fourPlayers = new ArrayList<>();

    @Before
    public void initPlayers() {
        fourPlayers.addAll(Arrays.asList(new Player("Juan", Level.A.toString(), 6, 20_000, 10_000, Player.Equipo.AZUL),
                new Player("Pedro", Level.B.toString(), 7, 30_000, 10_000, Player.Equipo.AZUL),
                new Player("Martín", Level.C.toString(), 16, 40_000, 10_000, Player.Equipo.AZUL),
                new Player("Luis", Level.CUAUH.toString(), 19, 50_000, 10_000, Player.Equipo.AZUL)));
    }

    @Test
    public void given4Players_whenTeamBonusEqTo96AndIndividualBonusEqTo95_expectTotalBonusOf95_5(){
        List<Player> playersWithFullSalaries = playersFullSalaryService.calculateFullSalaries(fourPlayers);

        playersWithFullSalaries.forEach(System.out::println);

        assertEquals(20_000 + 10_800, playersWithFullSalaries.get(0).getSueldoCompleto(), 0.2); // Juan
        assertEquals(30_000 + 8_300, playersWithFullSalaries.get(1).getSueldoCompleto(), 0.2); // Pedro
        assertEquals(40_000 + 10_133, playersWithFullSalaries.get(2).getSueldoCompleto(), 0.2); // Martín
        assertEquals(59_550, playersWithFullSalaries.get(3).getSueldoCompleto(), 0.2); // Luis
    }

    @Test
    public void whenReadFromInput_ThenCalculateFullSalaries() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        List<Player> players = objectMapper.readValue(new File(classLoader.getResource("input.json").getFile()), new TypeReference<List<Player>>() {});

        List<Player> playersWithFullSalaries = playersFullSalaryService.calculateFullSalaries(players);

        playersWithFullSalaries.forEach(System.out::println);
    }
}