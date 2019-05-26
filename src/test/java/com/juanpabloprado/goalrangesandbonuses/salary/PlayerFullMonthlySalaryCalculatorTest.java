package com.juanpabloprado.goalrangesandbonuses.salary;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class PlayerFullMonthlySalaryCalculatorTest {

    private PlayerFullMonthlySalaryCalculator calculator = new PlayerFullMonthlySalaryCalculator();

    @Test
    public void calculateFullSalary() {
        BigDecimal i = calculator.calculateFullSalary(BigDecimal.valueOf(50_000), BigDecimal.valueOf(10_000), 19, 20,48, 50);
        System.out.println(i);
        assertEquals(59_550, i.doubleValue(), 0.2);
    }
}