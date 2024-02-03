package com.imc.scorewriter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PaperRockScissorsScoreWriterTest {

    @Mock
    private Logger mockLogger;

    @InjectMocks
    private PaperRockScissorsScoreWriter scoreWriter;

    @Test
    void writeScore_ShouldNotThrowExceptionWithValidInput() {
        List<String> playerNames = List.of("Player1", "Player2");
        List<Integer> scores = List.of(1, 2);

        assertDoesNotThrow(() -> {
            scoreWriter.writeScore(playerNames, scores);
            verify(mockLogger).info("\nCurrent Score\n------------- \n{}: {} - {}: {}\n\n",
                    playerNames.get(0), scores.get(0),
                    playerNames.get(1), scores.get(1));
        });
    }

    @Test
    void writeScore_ShouldThrowExceptionWithNullPlayerNames() {
        assertThrows(IllegalArgumentException.class, () -> {
            scoreWriter.writeScore(null, List.of(1, 2));
            verify(mockLogger).error(PaperRockScissorsScoreWriter.INVALID_DATA_MESSAGE);
        });
    }

    @Test
    void writeScore_ShouldThrowExceptionWithNullScores() {
        assertThrows(IllegalArgumentException.class, () -> {
            scoreWriter.writeScore(List.of("Player1", "Player2"), null);
            verify(mockLogger).error(PaperRockScissorsScoreWriter.INVALID_DATA_MESSAGE);
        });
    }

    @Test
    void writeScore_ShouldThrowExceptionWithMismatchedSizes() {
        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> {
            scoreWriter.writeScore(List.of("Player1", "Player2"), List.of(1));
            verify(mockLogger).error(PaperRockScissorsScoreWriter.INVALID_DATA_MESSAGE);
        });
    }
}
