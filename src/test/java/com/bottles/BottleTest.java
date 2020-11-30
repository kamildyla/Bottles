package com.bottles;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BottleTest {

    @Test
    void testPourIn() {
        int capacity = 5;
        int fillLevel = 3;
        int toPourIn01 = 1;
        int toPourIn02 = 2;
        int toPourIn03 = 3;

        Bottle bottle1 = new Bottle(capacity);
        bottle1.setFillLevel(fillLevel);
        Bottle.pourIn(bottle1, toPourIn01);
        assertEquals(4, bottle1.getFillLevel());

        Bottle bottle2 = new Bottle(capacity);
        bottle2.setFillLevel(fillLevel);
        Bottle.pourIn(bottle2, toPourIn02);
        assertEquals(5, bottle2.getFillLevel());

        Bottle bottle3 = new Bottle(capacity);
        bottle3.setFillLevel(fillLevel);
        Bottle.pourIn(bottle3, toPourIn03);
        assertEquals(5, bottle3.getFillLevel());
    }

    @Test
    void testPourOut() {
        int capacity = 5;
        int fillLevel = 2;
        int toPourOut01 = 1;
        int toPourOut02 = 2;
        int toPourOut03 = 3;

        Bottle bottle1 = new Bottle(capacity);
        bottle1.setFillLevel(fillLevel);
        Bottle.pourOut(bottle1, toPourOut01);
        assertEquals(1, bottle1.getFillLevel());

        Bottle bottle2 = new Bottle(capacity);
        bottle2.setFillLevel(fillLevel);
        Bottle.pourOut(bottle2, toPourOut02);
        assertEquals(0, bottle2.getFillLevel());

        Bottle bottle3 = new Bottle(capacity);
        bottle3.setFillLevel(fillLevel);
        Bottle.pourOut(bottle3, toPourOut03);
        assertEquals(0, bottle3.getFillLevel());
    }
}