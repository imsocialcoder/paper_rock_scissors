package com.imc.resultdeterminer;

import com.imc.game.PaperRockScissorsGame;

import java.util.List;

/**
 * A class representing a ResultDeterminer specific to the Paper-Rock-Scissors game.
 */
public class PaperRockScissorsResultDeterminer implements ResultDeterminer{
    /**
     * Determines the result of a Paper-Rock-Scissors game round based on player names and their choices by
     * calling another method.
     *
     * @param playerNames The names of the players involved in the round.
     * @param choices     The choices made by the players for the round.
     * @return A String indicating the result of the round, such as a winner or a draw.
     * @throws IllegalArgumentException If the provided input (player names or choices) is invalid.
     */
    @Override
    public String determineResult(List<String> playerNames, List<Integer> choices) {
        if (playerNames == null || choices == null || playerNames.size() != 2 || choices.size() != 2) {
            throw new IllegalArgumentException("Invalid input. Please provide valid player names and choices.");
        }

        String playerName = playerNames.get(0);
        String autoName = playerNames.get(1);
        int playerChoice = choices.get(0);
        int autoChoice = choices.get(1);

        return createResult(playerName, autoName, playerChoice, autoChoice);
    }

    /**
     * Determines the result of a Paper-Rock-Scissors game round based on player names and their choices.
     *
     * @param playerName The names of the first player involved in the round.
     * @param autoName   The names of the player who makes auto choices involved in the round.
     * @param playerChoice The choice of the first player.
     * @param autoChoice The choice of the player who makes auto choices.
     * @return A String indicating the result of the round, such as a winner or a draw.
     */
    private String createResult(String playerName, String autoName, int playerChoice, int autoChoice) {
        if(playerChoice == autoChoice){
            return "Draw!";
        }

        if (isWinner(playerChoice, autoChoice)) {
            return playerName + " wins";
        } else {
            return autoName + " wins";
        }
    }

    /**
     * Checks if the player's choice wins against the auto player's choice in Paper-Rock-Scissors.
     *
     * @param playerChoice The choice made by the player.
     * @param autoChoice   The choice made by the auto player.
     * @return True if the player wins, false otherwise.
     */
    private boolean isWinner(int playerChoice, int autoChoice) {
        return (playerChoice == PaperRockScissorsGame.PAPER && autoChoice == PaperRockScissorsGame.ROCK) ||
                (playerChoice == PaperRockScissorsGame.ROCK && autoChoice == PaperRockScissorsGame.SCISSORS) ||
                (playerChoice == PaperRockScissorsGame.SCISSORS && autoChoice == PaperRockScissorsGame.PAPER);
    }
}
