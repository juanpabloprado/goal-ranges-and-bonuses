package com.juanpabloprado.goalrangesandbonuses.salary;

import org.javamoney.moneta.Money;
import org.springframework.stereotype.Component;

import javax.money.MonetaryAmount;
import java.util.stream.DoubleStream;

@Component
public class PlayerFullMonthlySalaryCalculator {

    private double calculatePercentage(double obtained, double total) {
        return obtained * 100 / total;
    }

    public MonetaryAmount calculateFullSalary(MonetaryAmount monthlySalary, MonetaryAmount monthlyBonus , int goalsScored, int minimum, int teamTotalGoals, int teamMinimum) {
        double individualPercentage = calculatePercentage(goalsScored, minimum);
        System.out.println("Individual percentage: " + individualPercentage);

        double teamPercentage = calculatePercentage(teamTotalGoals, teamMinimum);
        System.out.println("Team percentage: " + teamPercentage);

        double average = DoubleStream.of(individualPercentage, teamPercentage).average().getAsDouble();
        System.out.println("Average: " + average);
        System.out.println("MonthlyBonus: " + monthlyBonus);

        double bonus =  monthlyBonus.getNumber().doubleValueExact() * (average / 100);
        System.out.println("Full Bonus: " + bonus);

        return monthlySalary.add(Money.of(bonus, "MXN"));
    }
}
