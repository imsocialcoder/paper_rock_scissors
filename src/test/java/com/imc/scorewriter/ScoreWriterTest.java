package com.imc.scorewriter;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class ScoreWriterTest {

    private static class TestScoreWriter implements ScoreWriter {
        @Override
        public void writeScore(List<String> playerNames, List<Integer> scores) {
            System.out.println("Scores: " + playerNames + " - " + scores);
        }
    }

    @Test
    void writeScore_ShouldNotThrowExceptionWithValidInput() {
        TestScoreWriter scoreWriter = new TestScoreWriter();
        List<String> playerNames = List.of("Player1", "Player2");
        List<Integer> scores = List.of(1, 2);

        assertDoesNotThrow(() -> scoreWriter.writeScore(playerNames, scores));
    }
}

