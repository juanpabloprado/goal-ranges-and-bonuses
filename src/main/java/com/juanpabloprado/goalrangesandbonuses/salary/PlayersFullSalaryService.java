package com.juanpabloprado.goalrangesandbonuses.salary;

import com.juanpabloprado.goalrangesandbonuses.fc.Player;

import java.util.List;

public interface PlayersFullSalaryService {
    List<Player> calculateFullSalaries(List<Player> players);
}
