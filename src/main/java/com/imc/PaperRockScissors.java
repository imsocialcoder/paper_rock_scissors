package com.imc;

import com.imc.choicegenerator.PaperRockScissorsRandomChoiceGenerator;
import com.imc.game.PaperRockScissorsGame;
import com.imc.gameinteraction.PaperRockScissorsConsoleInteractionManager;
import com.imc.gamerunner.GameRunner;
import com.imc.gamerunner.PaperRockScissorsGameRunner;
import com.imc.gamestarter.PaperRockScissorsGameStarter;
import com.imc.resultdeterminer.PaperRockScissorsResultDeterminer;
import com.imc.scoreupdater.PaperRockScissorsScoreUpdater;
import com.imc.scorewriter.PaperRockScissorsScoreWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

/**
 * The main class for the Paper-Rock-Scissors game.
 * Initializes and runs the game components using various classes.
 */
public class PaperRockScissors {
    // Logger for logging messages
    private static final Logger logger = LoggerFactory.getLogger(PaperRockScissors.class);

    /**
     * The main method to start the Paper-Rock-Scissors game.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        try {
            // Create a new PaperRockScissorsGame instance with player names "Player" and "Computer"
            PaperRockScissorsGame game = new PaperRockScissorsGame(List.of("Player", "Computer"));

            // Set up the interaction manager to handle player inputs via the console
            PaperRockScissorsConsoleInteractionManager interactionManager = new PaperRockScissorsConsoleInteractionManager(new Scanner(System.in));

            // Initialize the choice generator for generating random choices
            PaperRockScissorsRandomChoiceGenerator choiceGenerator = new PaperRockScissorsRandomChoiceGenerator(PaperRockScissorsGame.CHOICE_MAP.size());

            // Create a result determiner to determine the outcome of each game round
            PaperRockScissorsResultDeterminer resultDeterminer = new PaperRockScissorsResultDeterminer();

            // Initialize the score writer for displaying or writing game scores
            PaperRockScissorsScoreWriter scoreWriter = new PaperRockScissorsScoreWriter(LoggerFactory.getLogger(PaperRockScissorsScoreWriter.class));

            // Set up the game starter to initialize the game and display initial information
            PaperRockScissorsGameStarter gameStarter = new PaperRockScissorsGameStarter(game, scoreWriter, LoggerFactory.getLogger(PaperRockScissorsGameStarter.class));

            // Initialize the score updater to update scores based on game results
            PaperRockScissorsScoreUpdater scoreUpdater = new PaperRockScissorsScoreUpdater();

            // Create a PaperRockScissorsGameRunner instance with the configured game and components
            GameRunner gameRunner = new PaperRockScissorsGameRunner(interactionManager, choiceGenerator, resultDeterminer,
                    game, gameStarter, scoreUpdater, scoreWriter, LoggerFactory.getLogger(PaperRockScissorsGameRunner.class));

            // Run the game using the game runner
            gameRunner.runGame();
        } catch (Exception e) {
            // Log an error message if an exception occurs during execution
            logger.error("An error occurred: {}", e.getMessage());
        }
    }
}
