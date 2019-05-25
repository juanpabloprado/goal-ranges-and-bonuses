package com.juanpabloprado.goalrangesandbonuses.salary;

import com.juanpabloprado.goalrangesandbonuses.fc.Player;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayersFullSalaryServiceImpl implements PlayersFullSalaryService {
    @Override
    public List<Player> calculateFullSalaries(List<Player> players) {
        return players;
    }
}
