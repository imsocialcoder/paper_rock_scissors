package com.imc.gamerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class GameRunnerTest {

    @Test
    void runGame_DefaultImplementation_DoesNotThrowException() {
        GameRunner gameRunner = () -> {
            // Default implementation does nothing
        };

        assertDoesNotThrow(gameRunner::runGame);
    }
}
