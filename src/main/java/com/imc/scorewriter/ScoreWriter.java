package com.imc.scorewriter;

import java.util.List;

/**
 * An interface defining the contract for writing scores in a game.
 */
public interface ScoreWriter {

    /**
     * Writes the scores of the players to the output.
     *
     * @param playerNames The names of the players.
     * @param scores      The scores of the players.
     */
    void writeScore(List<String> playerNames, List<Integer> scores);
}

