package com.imc.scoreupdater;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScoreUpdaterTest {

    private static class TestScoreUpdater implements ScoreUpdater {
        @Override
        public void updateScore(String result, List<String> playerNames, List<Integer> scores) {
            scores.set(0, scores.get(0) + 1);
        }
    }

    @Test
    void updateScore_ShouldIncrementFirstPlayerScore() {
        // Arrange
        ScoreUpdater scoreUpdater = new TestScoreUpdater();
        List<String> playerNames = List.of("Player1", "Player2");
        List<Integer> scores = new ArrayList<>(List.of(0, 0));
        String result = "Player1 wins";

        // Act
        scoreUpdater.updateScore(result, playerNames, scores);

        // Assert
        assertEquals(1, scores.get(0));
        assertEquals(0, scores.get(1));
    }
}

