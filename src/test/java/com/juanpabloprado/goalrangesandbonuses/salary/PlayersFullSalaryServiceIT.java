package com.juanpabloprado.goalrangesandbonuses.salary;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.juanpabloprado.goalrangesandbonuses.GoalApp;
import com.juanpabloprado.goalrangesandbonuses.fc.Player;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {GoalApp.class})
public class PlayersFullSalaryServiceIT {

    @Autowired
    PlayersFullSalaryService playersFullSalaryService;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void calculateFullSalaries() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        List<Player> players = objectMapper.readValue(new File(classLoader.getResource("input.json").getFile()), new TypeReference<List<Player>>() {});

        List<Player> playersWithFullSalaries = playersFullSalaryService.calculateFullSalaries(players);

        playersWithFullSalaries.forEach(System.out::println);
    }
}