package com.bottles;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BottleTest {

    private int oneLitter = 1;
    private int twoLitters = 2;
    private int threeLitters = 3;
    private int fourLitters = 4;
    private int capacity = 5;
    private Bottle bottle1 = new Bottle(capacity);
    private Bottle bottle2 = new Bottle(capacity);
    private Bottle bottle3 = new Bottle(capacity);

    @BeforeEach
    void initObjects(){
        int fillLevel = 3;
        bottle1.setFillLevel(fillLevel);
        bottle2.setFillLevel(fillLevel);
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

    @Test
    void testTransfer() {
        Bottle.transfer(bottle1, bottle2, twoLitters);
        assertEquals(1, bottle1.getFillLevel());
        assertEquals(5, bottle2.getFillLevel());

        Bottle.transfer(bottle1, bottle2, oneLitter);
        assertEquals(1, bottle1.getFillLevel());
        assertEquals(5, bottle2.getFillLevel());

        Bottle.transfer(bottle2, bottle3, threeLitters);
        assertEquals(3, bottle2.getFillLevel());
        assertEquals(5, bottle3.getFillLevel());

        Bottle.transfer(bottle1, bottle2, threeLitters);
        assertEquals(0, bottle1.getFillLevel());
        assertEquals(4, bottle2.getFillLevel());
    }

    @Test
    void testRandomCapacitySetCapacity() {
        Bottle bottle4 = new Bottle(Bottle.randomCapacity());
        int capacity = bottle4.getCapacity();
        assertTrue(capacity >= 0 && capacity <= 10);
    }
}