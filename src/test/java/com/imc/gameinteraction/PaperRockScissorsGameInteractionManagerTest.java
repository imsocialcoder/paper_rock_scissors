package com.imc.gameinteraction;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PaperRockScissorsGameInteractionManagerTest {

    @Test
    void getNumberOfRounds_DefaultImplementation_ReturnsZero() {
        PaperRockScissorsGameInteractionManager interactionManager = new PaperRockScissorsGameInteractionManager() {
            @Override
            public int getNumberOfRounds() {
                return 0;
            }

            @Override
            public int getPlayerChoice() {
                return 0;
            }

            @Override
            public String getAutoChoice(int choice) {
                return null;
            }
        };

        int result = interactionManager.getNumberOfRounds();
        assertEquals(0, result);
    }

    @Test
    void getPlayerChoice_DefaultImplementation_ReturnsZero() {
        PaperRockScissorsGameInteractionManager interactionManager = new PaperRockScissorsGameInteractionManager() {
            @Override
            public int getNumberOfRounds() {
                return 0;
            }

            @Override
            public int getPlayerChoice() {
                return 0;
            }

            @Override
            public String getAutoChoice(int choice) {
                return null;
            }
        };

        int result = interactionManager.getPlayerChoice();
        assertEquals(0, result);
    }

    @Test
    void getAutoChoice_DefaultImplementation_ReturnsNotNullString() {
        PaperRockScissorsGameInteractionManager interactionManager = new PaperRockScissorsGameInteractionManager() {
            @Override
            public int getNumberOfRounds() {
                return 0;
            }

            @Override
            public int getPlayerChoice() {
                return 0;
            }

            @Override
            public String getAutoChoice(int choice) {
                return "Rock";
            }
        };

        String result = interactionManager.getAutoChoice(1);
        assertNotNull(result);
    }
}