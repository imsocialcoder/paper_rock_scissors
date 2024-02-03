package com.imc.gamerunner;

import com.imc.choicegenerator.ChoiceGenerator;
import com.imc.game.PaperRockScissorsGame;
import com.imc.gameinteraction.PaperRockScissorsGameInteractionManager;
import com.imc.gamestarter.PaperRockScissorsGameStarter;
import com.imc.resultdeterminer.ResultDeterminer;
import com.imc.scoreupdater.ScoreUpdater;
import com.imc.scorewriter.ScoreWriter;
import org.slf4j.Logger;

import java.util.List;

/**
 * A class representing a game runner for the Paper-Rock-Scissors game.
 * Implements the GameRunner interface and provides functionality to run the game.
 */
public class PaperRockScissorsGameRunner implements GameRunner {
    private final Logger logger;

    /**
     * The interaction manager responsible for handling player interactions.
     */
    private final PaperRockScissorsGameInteractionManager interactionManager;

    /**
     * The choice generator used to generate automatic choices in the game.
     */
    private final ChoiceGenerator choiceGenerator;

    /**
     * The result determiner used to determine the result of each round in the game.
     */
    private final ResultDeterminer resultDeterminer;
    private int numberOfRounds = 0;

    private final PaperRockScissorsGame game;
    private final PaperRockScissorsGameStarter gameStarter;

    /**
     * The updater responsible for updating scores based on game results.
     */
    public final ScoreUpdater scoreUpdater;

    /**
     * The writer responsible for displaying or writing scores.
     */
    private final ScoreWriter scoreWriter;

    public PaperRockScissorsGameRunner(PaperRockScissorsGameInteractionManager interactionManager, ChoiceGenerator choiceGenerator,
                                       ResultDeterminer resultDeterminer, PaperRockScissorsGame game, PaperRockScissorsGameStarter gameStarter,
                                       ScoreUpdater scoreUpdater, ScoreWriter scoreWriter, Logger logger) {
        this.interactionManager = interactionManager;
        this.choiceGenerator = choiceGenerator;
        this.resultDeterminer = resultDeterminer;
        this.game = game;
        this.gameStarter = gameStarter;
        this.scoreUpdater = scoreUpdater;
        this.scoreWriter = scoreWriter;
        this.logger = logger;
    }

    /**
     * Runs the Paper-Rock-Scissors game.
     * Starts & proceeds the game.
     */
    @Override
    public void runGame() {
        gameStarter.startGame();
        proceedGame();
    }

    /**
     * Proceeds the Paper-Rock-Scissors game.
     * Determines the number of rounds, and plays the rounds
     */
    public void proceedGame() {
        numberOfRounds = interactionManager.getNumberOfRounds();
        playRounds();
    }

    /**
     * Plays the specified number of rounds in the game.
     */
    private void playRounds() {
        int roundsPlayed = 0;

        while (roundsPlayed < numberOfRounds) {
            runRound();
            roundsPlayed++;
        }
    }

    /**
     * Runs a single round of the game.
     * Generates choices, determines the result, and logs the round information.
     */
    private void runRound() {
        int autoChoice = choiceGenerator.generateResult();
        int playerChoice = interactionManager.getPlayerChoice();

        logAutoChoice(autoChoice);
        String result = resultDeterminer.determineResult(
                game.getPlayerNames(), List.of(playerChoice, autoChoice));
        logRoundResult(result);

        updateAndWriteScore(result);
    }

    /**
     * Logs the computer's choice for the current round.
     *
     * @param autoChoice The computer's choice.
     */
    private void logAutoChoice(int autoChoice) {
        logger.info("{} {}", game.getPlayerNames().get(1), interactionManager.getAutoChoice(autoChoice));
    }

    /**
     * Logs the result of the current round.
     *
     * @param result The result of the round.
     */
    public void logRoundResult(String result) {
        logger.info(result);
    }

    /**
     * Updates the game score based on the result and logs the updated score.
     *
     * @param result The result of the current round.
     */
    private void updateAndWriteScore(String result) {
        scoreUpdater.updateScore(result, game.getPlayerNames(), game.getScores());
        scoreWriter.writeScore(game.getPlayerNames(), game.getScores());
    }

    private int getNumberOfRounds() {
        return numberOfRounds;
    }

    private void setNumberOfRounds(int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
    }
}
