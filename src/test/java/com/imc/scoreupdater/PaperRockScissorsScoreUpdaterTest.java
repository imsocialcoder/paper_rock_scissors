package com.imc.scoreupdater;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PaperRockScissorsScoreUpdaterTest {

    @Test
    void updateScore_ShouldIncrementPlayerOneScoreOnPlayerOneWin() {
        PaperRockScissorsScoreUpdater scoreUpdater = new PaperRockScissorsScoreUpdater();
        List<String> playerNames = List.of("Player1", "Player2");
        List<Integer> scores = new ArrayList<>(List.of(0, 0));
        String result = "Player1 wins";

        scoreUpdater.updateScore(result, playerNames, scores);

        assertEquals(1, scores.get(0));
        assertEquals(0, scores.get(1));
    }

    @Test
    void updateScore_ShouldIncrementPlayerTwoScoreOnPlayerTwoWin() {
        PaperRockScissorsScoreUpdater scoreUpdater = new PaperRockScissorsScoreUpdater();
        List<String> playerNames = List.of("Player1", "Player2");
        List<Integer> scores = new ArrayList<>(List.of(0, 0));
        String result = "Player2 wins";

        scoreUpdater.updateScore(result, playerNames, scores);

        assertEquals(0, scores.get(0));
        assertEquals(1, scores.get(1));
    }

    @Test
    void updateScore_ShouldNotChangeScoresOnDraw() {
        PaperRockScissorsScoreUpdater scoreUpdater = new PaperRockScissorsScoreUpdater();
        List<String> playerNames = List.of("Player1", "Player2");
        List<Integer> scores = new ArrayList<>(List.of(1, 1));
        String result = "Draw!";

        scoreUpdater.updateScore(result, playerNames, scores);

        assertEquals(1, scores.get(0));
        assertEquals(1, scores.get(1));
    }

    @Test
    void updateScore_ShouldThrowExceptionOnInvalidInput() {
        PaperRockScissorsScoreUpdater scoreUpdater = new PaperRockScissorsScoreUpdater();
        List<String> playerNames = List.of("Player1");
        List<Integer> scores = new ArrayList<>(List.of(1, 1));
        String result = "Player1 wins";

        assertThrows(IllegalArgumentException.class, () ->
                scoreUpdater.updateScore(result, playerNames, scores));
    }
}
