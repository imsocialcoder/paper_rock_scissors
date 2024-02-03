package com.imc.gameinteraction;

import java.util.Arrays;
import java.util.Scanner;
import com.imc.game.PaperRockScissorsGame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents the console interaction manager for the Paper-Rock-Scissors game.
 * Implements the PaperRockScissorsGameInteractionManager interface.
 */
public class PaperRockScissorsConsoleInteractionManager implements PaperRockScissorsGameInteractionManager {
    private static final Logger logger = LoggerFactory.getLogger(PaperRockScissorsConsoleInteractionManager.class);

    // Error message for invalid choices
    private static final String INVALID_CHOICE_MESSAGE = "Wrong choice... ";
    // Message prompting the user for the number of rounds
    private static final String ROUND_INPUT_MESSAGE = "How many rounds do you want to play? Please enter: ";
    // Message prompting the user for their choice
    private static final String PLAYER_CHOICE_MESSAGE = "Make your choice (paper / rock / scissors): ";
    // Scanner for reading input from the console
    private final Scanner scanner;

    // Constructor that accepts a Scanner
    public PaperRockScissorsConsoleInteractionManager(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Gets the number of rounds for the game from the user.
     *
     * @return The number of rounds.
     */
    @Override
    public int getNumberOfRounds() {
        int numberOfRounds = 0;

        // Keep prompting until a valid number of rounds is entered
        while (numberOfRounds < 1) {
            logger.info(ROUND_INPUT_MESSAGE);
            try {
                numberOfRounds = Integer.parseInt(scanner.nextLine());
                if (numberOfRounds < 1)
                    logger.info("Number of rounds has to be greater than 0... ");
            } catch (NumberFormatException exception) {
                logger.info(INVALID_CHOICE_MESSAGE);
                numberOfRounds = 0;
            }
        }

        return numberOfRounds;
    }

    /**
     * Gets the player's choice from the user.
     *
     * @return The player's choice code.
     */
    @Override
    public int getPlayerChoice() {
        String playerChoice;

        // Keep prompting until a valid choice is entered
        do {
            logger.info(PLAYER_CHOICE_MESSAGE);
            playerChoice = scanner.nextLine().trim().toLowerCase();
        } while (!isPlayerChoiceValid(playerChoice));

        return getChoice(playerChoice);
    }

    /**
     * Gets the representation of the computer's choice based on the provided choice code.
     *
     * @param choice The choice code representing the computer's choice.
     * @return The representation of the computer's choice (e.g., "Choice: rock").
     */
    @Override
    public String getAutoChoice(int choice) {
        return "Choice: " + getChoice(choice);
    }

    // Helper method to get the choice code based on the choice name
    private int getChoice(String choice) {
        return PaperRockScissorsGame.CHOICE_MAP.get(choice);
    }

    // Helper method to get the choice name based on the choice code
    private String getChoice(int choice) {
        return Arrays.asList("paper", "rock", "scissors").get(choice);
    }

    // Helper method to check if the player's choice is valid
    private boolean isPlayerChoiceValid(String playerChoice) {
        return PaperRockScissorsGame.CHOICE_MAP.containsKey(playerChoice);
    }

}
