package com.imc.resultdeterminer;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultDeterminerTest {

    private static class TestResultDeterminer implements ResultDeterminer {
        @Override
        public String determineResult(List<String> playerNames, List<Integer> choices) {
            return "Test Result";
        }
    }

    @Test
    void determineResult_ShouldReturnTestResult() {
        ResultDeterminer resultDeterminer = new TestResultDeterminer();
        List<String> playerNames = List.of("Player1", "Player2");
        List<Integer> choices = List.of(0, 1);

        String result = resultDeterminer.determineResult(playerNames, choices);

        assertEquals("Test Result", result);
    }
}
