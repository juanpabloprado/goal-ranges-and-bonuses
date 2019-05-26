package com.juanpabloprado.goalrangesandbonuses.web;

import com.juanpabloprado.goalrangesandbonuses.fc.Player;
import com.juanpabloprado.goalrangesandbonuses.salary.PlayersFullSalaryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayersFullSalaryController {

    private final PlayersFullSalaryService playersFullSalaryService;


    public PlayersFullSalaryController(PlayersFullSalaryService playersFullSalaryService) {
        this.playersFullSalaryService = playersFullSalaryService;
    }

    @PostMapping("/salaries")
    public List<Player> calculateSalaries(@RequestBody List<Player> players) {
        return playersFullSalaryService.calculateFullSalaries(players);
    }

}
