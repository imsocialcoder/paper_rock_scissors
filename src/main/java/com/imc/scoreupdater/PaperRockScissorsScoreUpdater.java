package com.imc.scoreupdater;

import java.util.List;

/**
 * A class responsible for updating scores in a Paper-Rock-Scissors game.
 */
public class PaperRockScissorsScoreUpdater implements ScoreUpdater {
    private static final int PLAYER_ONE_INDEX = 0;
    private static final int PLAYER_TWO_INDEX = 1;

    /**
     * Validates the input parameters to ensure they are not null and have the required size.
     *
     * @param result      The result of the game round.
     * @param playerNames The names of the players.
     * @param scores      The current scores of the players.
     * @throws IllegalArgumentException If the input is invalid.
     */
    private void validateInput(String result, List<String> playerNames, List<Integer> scores) {
        if (result == null || playerNames == null || scores == null ||
                playerNames.size() < 2 || scores.size() < 2) {
            throw new IllegalArgumentException("Invalid input. Please provide valid result, player names, and scores.");
        }
    }

    /**
     * Updates the scores based on the result of the game round.
     *
     * @param result      The result of the game round.
     * @param playerNames The names of the players.
     * @param scores      The current scores of the players.
     * @throws IllegalArgumentException If the input is invalid.
     */
    @Override
    public void updateScore(String result, List<String> playerNames, List<Integer> scores) {
        validateInput(result, playerNames, scores);

        String playerOneName = playerNames.get(PLAYER_ONE_INDEX);
        String playerTwoName = playerNames.get(PLAYER_TWO_INDEX);

        if (result.equals(playerOneName + " wins")) {
            scores.set(PLAYER_ONE_INDEX, scores.get(PLAYER_ONE_INDEX) + 1);
        } else if (result.equals(playerTwoName + " wins")) {
            scores.set(PLAYER_TWO_INDEX, scores.get(PLAYER_TWO_INDEX) + 1);
        }
    }
}
