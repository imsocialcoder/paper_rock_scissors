package com.imc.gameinteraction;

/**
 * Represents the interaction manager for the Paper-Rock-Scissors game.
 * Defines methods for managing game interactions.
 */
public interface PaperRockScissorsGameInteractionManager {

    /**
     * Gets the number of rounds for the game.
     *
     * @return The number of rounds.
     */
    int getNumberOfRounds();

    /**
     * Gets the choice made by the player.
     *
     * @return The player's choice.
     */
    int getPlayerChoice();

    /**
     * Gets the representation of the computer's choice based on the provided choice code.
     *
     * @param choice The choice code representing the computer's choice.
     * @return The representation of the computer's choice (e.g., "rock").
     */
    String getAutoChoice(int choice);
}