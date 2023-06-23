package ru.otus.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiceImplTest {

    @Test
    void testBounds() {
        Dice dice = new DiceImpl();
        int bound = dice.roll();
        assertTrue(bound >= 1 && bound <= 6);
    }

}