package com.imc.scorewriter;

import org.slf4j.Logger;

import java.util.List;

/**
 * A class implementing the ScoreWriter interface for the Paper-Rock-Scissors game.
 */
public class PaperRockScissorsScoreWriter implements ScoreWriter {

    private final Logger logger;
    public static final String INVALID_DATA_MESSAGE = "Invalid data. Unable to write the score.";

    public PaperRockScissorsScoreWriter(Logger logger) {
        this.logger = logger;
    }

    /**
     * Writes the scores of the players to the output.
     *
     * @param playerNames The names of the players.
     * @param scores      The scores of the players.
     */
    @Override
    public void writeScore(List<String> playerNames, List<Integer> scores) {
        if (!isValidData(playerNames, scores)) {
            throw new IllegalArgumentException(INVALID_DATA_MESSAGE);
        }

        printScore(playerNames, scores);
    }

    /**
     * Checks if the provided data (player names and scores) is valid for score writing.
     *
     * @param playerNames The names of the players.
     * @param scores      The scores of the players.
     * @return True if the data is valid, false otherwise.
     */
    private boolean isValidData(List<String> playerNames, List<Integer> scores) {
        return playerNames != null && scores != null && playerNames.size() == 2 && scores.size() == 2;
    }

    /**
     * Prints the scores of the players to the output.
     *
     * @param playerNames The names of the players.
     * @param scores      The scores of the players.
     */
    private void printScore(List<String> playerNames, List<Integer> scores) {
        logger.info("\nCurrent Score\n------------- \n{}: {} - {}: {}\n\n",
                playerNames.get(0), scores.get(0),
                playerNames.get(1), scores.get(1));
    }
}
