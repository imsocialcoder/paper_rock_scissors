package com.imc.game;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Represents the implementation of the Paper-Rock-Scissors game.
 * Extends the abstract Game class.
 */
public class PaperRockScissorsGame extends Game {
    /**
     * Constants representing the choices in the game: PAPER, ROCK, SCISSORS.
     */
    public static final int PAPER = 0;
    public static final int ROCK = 1;
    public static final int SCISSORS = 2;

    /**
     * A map that associates choice names (paper, rock, scissors) with corresponding integer values.
     */
    public static final Map<String, Integer> CHOICE_MAP = Map.of(
            "paper", PAPER,
            "rock", ROCK,
            "scissors", SCISSORS
    );

    /**
     * Constructs a PaperRockScissorsGame object with the specified player names.
     *
     * @param playerNames The names of the players.
     * @throws IllegalArgumentException If player names are invalid.
     */
    public PaperRockScissorsGame(List<String> playerNames) {
        if (playerNames == null || playerNames.size() != 2) {
            throw new IllegalArgumentException("Invalid player names");
        }
        // Initialization of game attributes
        this.welcomeMessage = "Welcome to Paper-Rock-Scissors game";
        this.playerNames = playerNames;
        this.scores = Arrays.asList(0, 0);
    }
}