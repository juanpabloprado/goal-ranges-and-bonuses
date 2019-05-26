package com.juanpabloprado.goalrangesandbonuses.salary;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.stream.DoubleStream;

@Component
public class PlayerFullMonthlySalaryCalculator {

    private double calculatePercentage(double obtained, double total) {
        return obtained * 100 / total;
    }

    public BigDecimal calculateFullSalary(BigDecimal monthlySalary, BigDecimal monthlyBonus , int goalsScored, int minimum, int teamTotalGoals, int teamMinimum) {
        double individualPercentage = calculatePercentage(goalsScored, minimum);
        System.out.println("Individual percentage: " + individualPercentage);

        double teamPercentage = calculatePercentage(teamTotalGoals, teamMinimum);
        System.out.println("Team percentage: " + teamPercentage);

        double average = DoubleStream.of(individualPercentage, teamPercentage).average().getAsDouble();
        System.out.println("Average: " + average);
        System.out.println("MonthlyBonus: " + monthlyBonus);

        double bonus = calculatePercentage(average, monthlyBonus.doubleValue()) * monthlyBonus.doubleValue();
        System.out.println("Full Bonus: " + bonus);

        return monthlySalary.add(BigDecimal.valueOf(bonus));
    }
}
