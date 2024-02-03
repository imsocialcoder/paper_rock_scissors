package com.imc.game;

import java.util.List;

/**
 * The base class for game implementations.
 */
public abstract class Game {
    /**
     * A welcome message displayed at the start of the game.
     */
    protected String welcomeMessage;

    /**
     * The names of the players.
     */
    protected List<String> playerNames;

    /**
     * The scores of the players.
     */
    protected List<Integer> scores;

    /**
     * Gets the welcome message for the game.
     *
     * @return The welcome message.
     */
    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    /**
     * Gets the names of the players.
     *
     * @return The list of player names.
     */
    public List<String> getPlayerNames() {
        return playerNames;
    }

    /**
     * Gets the scores of the players.
     *
     * @return The list of player scores.
     */
    public List<Integer> getScores() {
        return scores;
    }
}
