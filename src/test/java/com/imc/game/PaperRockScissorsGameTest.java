package com.imc.game;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PaperRockScissorsGameTest {

    @Test
    void testConstructorWithValidPlayerNames() {
        List<String> validPlayerNames = Arrays.asList("Player1", "Player2");
        PaperRockScissorsGame game = new PaperRockScissorsGame(validPlayerNames);

        assertEquals("Welcome to Paper-Rock-Scissors game", game.getWelcomeMessage());
        assertEquals(validPlayerNames, game.getPlayerNames());
        assertEquals(Arrays.asList(0, 0), game.getScores());
    }

    @Test
    void testConstructorWithInvalidPlayerNames() {
        List<String> invalidPlayerNames = Arrays.asList("Player1");
        assertThrows(IllegalArgumentException.class, () -> new PaperRockScissorsGame(invalidPlayerNames));
    }

    @Test
    void testConstructorWithNullPlayerNames() {
        assertThrows(IllegalArgumentException.class, () -> new PaperRockScissorsGame(null));
    }

    @Test
    void testChoiceMapValues() {
        assertEquals(0, PaperRockScissorsGame.CHOICE_MAP.get("paper"));
        assertEquals(1, PaperRockScissorsGame.CHOICE_MAP.get("rock"));
        assertEquals(2, PaperRockScissorsGame.CHOICE_MAP.get("scissors"));
    }

    @Test
    void testChoiceMapInvalidKey() {
        assertNull(PaperRockScissorsGame.CHOICE_MAP.get("invalid"));
    }
}
