package com.imc.game;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {

    // Create a concrete subclass for testing
    private static class TestGame extends Game {
        TestGame(String welcomeMessage, List<String> playerNames, List<Integer> scores) {
            this.welcomeMessage = welcomeMessage;
            this.playerNames = playerNames;
            this.scores = scores;
        }
    }

    @Test
    void testGetWelcomeMessage() {
        String welcomeMessage = "Welcome to the game!";
        Game game = new TestGame(welcomeMessage, Arrays.asList("Player1", "Player2"), Arrays.asList(0, 0));

        assertEquals(welcomeMessage, game.getWelcomeMessage());
    }

    @Test
    void testGetPlayerNames() {
        List<String> playerNames = Arrays.asList("Player1", "Player2");
        Game game = new TestGame("Welcome!", playerNames, Arrays.asList(0, 0));

        assertEquals(playerNames, game.getPlayerNames());
    }

    @Test
    void testGetScores() {
        List<Integer> scores = Arrays.asList(0, 0);
        Game game = new TestGame("Welcome!", Arrays.asList("Player1", "Player2"), scores);

        assertEquals(scores, game.getScores());
    }
}
