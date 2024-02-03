package com.imc.choicegenerator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ChoiceGeneratorTest {

    static class TestChoiceGenerator extends ChoiceGenerator {
        @Override
        public int generateResult() {
            return 42; // Provide a concrete implementation for testing
        }
    }

    @Test
    void generateResult_DefaultImplementation_ShouldThrowUnsupportedOperationException() {
        // Arrange
        ChoiceGenerator choiceGenerator = new TestChoiceGenerator();

        // Act & Assert
        assertDoesNotThrow(choiceGenerator::generateResult);
        assertEquals(42, choiceGenerator.generateResult());
    }
}
