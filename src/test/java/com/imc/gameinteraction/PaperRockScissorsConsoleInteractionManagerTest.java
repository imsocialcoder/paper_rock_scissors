package com.imc.gameinteraction;

import com.imc.game.PaperRockScissorsGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PaperRockScissorsConsoleInteractionManagerTest {

    private PaperRockScissorsConsoleInteractionManager interactionManager;

    @BeforeEach
    void setUp() {
        // Reset the interactionManager before each test
        interactionManager = null;
    }

    @Test
    void getNumberOfRounds_ValidInput_ReturnsValidNumberOfRounds() {
        // Simulate user entering "3"
        provideInput("3");
        int result = getInteractionManager().getNumberOfRounds();
        assertEquals(3, result);
    }

    @Test
    void getNumberOfRounds_InvalidInputThenValidInput_ReturnsValidNumberOfRounds() {
        // Simulate user entering "invalid" then "2"
        provideInput("invalid\n2");
        int result = getInteractionManager().getNumberOfRounds();
        assertEquals(2, result);
    }

    @Test
    void getPlayerChoice_ValidInput_ReturnsValidPlayerChoice() {
        // Simulate user entering "rock"
        provideInput("rock");
        int result = getInteractionManager().getPlayerChoice();
        assertEquals(PaperRockScissorsGame.ROCK, result);
    }

    @Test
    void getPlayerChoice_InvalidInputThenValidInput_ReturnsValidPlayerChoice() {
        // Simulate user entering "invalid" then "scissors"
        provideInput("invalid\nscissors");
        int result = getInteractionManager().getPlayerChoice();
        assertEquals(PaperRockScissorsGame.SCISSORS, result);
    }

    @Test
    void getAutoChoice_ValidInput_ReturnsValidAutoChoice() {
        String autoChoice = getInteractionManager().getAutoChoice(PaperRockScissorsGame.PAPER);
        assertTrue(autoChoice.contains("Choice:"));
        assertTrue(autoChoice.contains("paper"));
    }

    // Helper method to provide input for testing
    private void provideInput(String input) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(inputStream);
        interactionManager = new PaperRockScissorsConsoleInteractionManager(scanner);
    }

    // Helper method to get the interaction manager (creating a new one if not already created)
    private PaperRockScissorsConsoleInteractionManager getInteractionManager() {
        if (interactionManager == null) {
            interactionManager = new PaperRockScissorsConsoleInteractionManager(new Scanner(System.in));
        }
        return interactionManager;
    }
}
