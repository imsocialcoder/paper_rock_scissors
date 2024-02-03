package com.imc.resultdeterminer;

import java.util.List;

/**
 * An interface representing a ResultDeterminer for determining the outcome of a game round.
 */
public interface ResultDeterminer {

    /**
     * Determines the result of a game round based on player names and their choices.
     *
     * @param playerNames The names of the players involved in the round.
     * @param choices     The choices made by the players for the round.
     * @return A String indicating the result of the round, such as a winner or a draw.
     */
    String determineResult(List<String> playerNames, List<Integer> choices);
}

