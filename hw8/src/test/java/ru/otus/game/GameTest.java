package ru.otus.game;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.mockito.Mockito.*;

class GameTest {

    Dice dice;
    GameWinnerPrinter gameWinnerPrinter;

    @BeforeEach
    void setUp() {
        this.dice = mock(Dice.class);
        this.gameWinnerPrinter = mock(GameWinnerPrinter.class);
    }

    @AfterEach
    void tearDown() {
        clearInvocations(dice, gameWinnerPrinter);
    }

    @Test
    void testDraw() {
        Game game = new Game(dice, gameWinnerPrinter);

        when(dice.roll()).thenReturn(6);

        Player player1 = new Player("Vasya");
        Player player2 = new Player("Petya");

        game.playGame(player1, player2);

        verify(gameWinnerPrinter).printWinner(null);
    }

    @Test
    void player1Win() {
        Game game = new Game(dice, gameWinnerPrinter);

        when(dice.roll()).thenReturn(6).thenReturn(5);

        Player player1 = new Player("Vasya");
        Player player2 = new Player("Petya");

        game.playGame(player1, player2);

        verify(gameWinnerPrinter).printWinner(player1);
    }

    @Test
    void player2Win() {
        Game game = new Game(dice, gameWinnerPrinter);

        when(dice.roll()).thenReturn(4).thenReturn(6);

        Player player1 = new Player("Vasya");
        Player player2 = new Player("Petya");

        game.playGame(player1, player2);

        verify(gameWinnerPrinter).printWinner(player2);
    }
}