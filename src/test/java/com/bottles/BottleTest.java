package com.bottles;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BottleTest {

    private int oneLitter = 1;
    private int twoLitters = 2;
    private int threeLitters = 3;
    private int fourLitters = 4;
    private Bottle bottle1 = new Bottle();
    private Bottle bottle2 = new Bottle();
    private Bottle bottle3 = new Bottle();

    @BeforeEach
    public void initObjects(){
        int capacity = 5;
        int fillLevel = 3;
        bottle1.setCapacity(capacity);
        bottle1.setFillLevel(fillLevel);
        bottle2.setCapacity(capacity);
        bottle2.setFillLevel(fillLevel);
        bottle3.setCapacity(capacity);
        bottle3.setFillLevel(fillLevel);
    }

    @Test
    void testPourIn() {

        Bottle.pourIn(bottle1, oneLitter);
        assertEquals(4, bottle1.getFillLevel());

        Bottle.pourIn(bottle2, twoLitters);
        assertEquals(5, bottle2.getFillLevel());

        Bottle.pourIn(bottle3, threeLitters);
        assertEquals(5, bottle3.getFillLevel());
    }

    @Test
    void testPourOut() {

        Bottle.pourOut(bottle1, twoLitters);
        assertEquals(1, bottle1.getFillLevel());

        Bottle.pourOut(bottle2, threeLitters);
        assertEquals(0, bottle2.getFillLevel());

        Bottle.pourOut(bottle3, fourLitters);
        assertEquals(0, bottle3.getFillLevel());
    }
}