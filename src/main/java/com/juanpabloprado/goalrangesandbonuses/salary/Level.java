package com.juanpabloprado.goalrangesandbonuses.salary;


import java.util.Arrays;

public enum Level {
    A("A", 5),
    B("B", 10),
    C("C", 15),
    CUAUH("Cuauh", 20);

    private final String displayName;
    private final int goalsPerMonth;

    Level(String displayName, int goalsPerMonth) {
        this.displayName = displayName;
        this.goalsPerMonth = goalsPerMonth;
    }

    public int getGoalsPerMonth() {
        return goalsPerMonth;
    }

    @Override
    public String toString() {
        return displayName;
    }

    public static int getMinimumRequired() {
        return Arrays.stream(Level.values()).mapToInt(Level::getGoalsPerMonth).sum();
    }
}
