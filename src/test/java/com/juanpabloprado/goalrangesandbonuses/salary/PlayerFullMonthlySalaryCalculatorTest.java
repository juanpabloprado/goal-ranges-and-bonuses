package com.juanpabloprado.goalrangesandbonuses.salary;

import org.javamoney.moneta.Money;
import org.junit.Test;

import javax.money.MonetaryAmount;
import java.math.BigDecimal;

import static org.junit.Assert.*;

public class PlayerFullMonthlySalaryCalculatorTest {

    private PlayerFullMonthlySalaryCalculator calculator = new PlayerFullMonthlySalaryCalculator();

    @Test
    public void calculateFullSalary() {
        MonetaryAmount i = calculator.calculateFullSalary(Money.of(50_000, "MXN"), Money.of(10_000, "MXN"), 19, 20,48, 50);
        System.out.println(i);
        assertEquals(59_550, i.getNumber().doubleValueExact(), 0.2);
    }
}