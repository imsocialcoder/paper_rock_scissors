package com.imc.scoreupdater;

import java.util.List;

/**
 * An interface defining the contract for updating scores in a game.
 */
public interface ScoreUpdater {

    /**
     * Updates the scores based on the result of a game round.
     *
     * @param result      The result of the game round.
     * @param playerNames The names of the players.
     * @param scores      The current scores of the players.
     */
    void updateScore(String result, List<String> playerNames, List<Integer> scores);
}

