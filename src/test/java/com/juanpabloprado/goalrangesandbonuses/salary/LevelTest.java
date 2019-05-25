package com.juanpabloprado.goalrangesandbonuses.salary;

import org.junit.Test;

import static org.junit.Assert.*;

public class LevelTest {

    @Test
    public void whenCuahExpectValue() {
        Level actual = Level.valueOf("Cuauh".toUpperCase());
        assertEquals(Level.CUAUH, actual);
    }
}