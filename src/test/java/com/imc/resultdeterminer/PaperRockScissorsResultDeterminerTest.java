package com.imc.resultdeterminer;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class PaperRockScissorsResultDeterminerTest {

    @Test
    void determineResult_Draw() {
        PaperRockScissorsResultDeterminer resultDeterminer = new PaperRockScissorsResultDeterminer();
        List<String> playerNames = List.of("Player1", "Player2");
        List<Integer> choices = List.of(0, 0); // Both players choose Paper

        String result = resultDeterminer.determineResult(playerNames, choices);

        assertEquals("Draw!", result);
    }

    @Test
    void determineResult_Player1Wins() {
        PaperRockScissorsResultDeterminer resultDeterminer = new PaperRockScissorsResultDeterminer();
        List<String> playerNames = List.of("Player1", "Player2");
        List<Integer> choices = List.of(1, 2); // Player1 chooses Rock, Player2 chooses Scissors

        String result = resultDeterminer.determineResult(playerNames, choices);

        assertEquals("Player1 wins", result);
    }

    @Test
    void determineResult_Player2Wins() {
        PaperRockScissorsResultDeterminer resultDeterminer = new PaperRockScissorsResultDeterminer();
        List<String> playerNames = List.of("Player1", "Player2");
        List<Integer> choices = List.of(1, 0); // Player1 chooses Rock, Player2 chooses Paper

        String result = resultDeterminer.determineResult(playerNames, choices);

        assertEquals("Player2 wins", result);
    }

    @Test
    void determineResult_InvalidInput() {
        PaperRockScissorsResultDeterminer resultDeterminer = new PaperRockScissorsResultDeterminer();
        List<String> playerNames = List.of("Player1"); // Invalid input (only one player)
        List<Integer> choices = List.of(0, 2);

        assertThrows(IllegalArgumentException.class, () -> resultDeterminer.determineResult(playerNames, choices));
    }
}
