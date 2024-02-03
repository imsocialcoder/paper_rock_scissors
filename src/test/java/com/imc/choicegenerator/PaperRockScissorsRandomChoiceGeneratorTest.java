package com.imc.choicegenerator;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PaperRockScissorsRandomChoiceGeneratorTest {

    @Test
    void testGenerateResultInRange() {
        int numberOfChoicesMock = 3;
        PaperRockScissorsRandomChoiceGenerator generator = new PaperRockScissorsRandomChoiceGenerator(numberOfChoicesMock);

        for (int i = 0; i < 1000; i++) {
            int result = generator.generateResult();
            assertTrue(result >= 0 && result < numberOfChoicesMock, "Generated result is out of range");
        }
    }

    @Test
    void testGenerateResultDistribution() {
        int numberOfChoicesMock = 3;
        PaperRockScissorsRandomChoiceGenerator generator = new PaperRockScissorsRandomChoiceGenerator(numberOfChoicesMock);

        Map<Integer, Integer> counts = new HashMap<>();
        int totalRuns = 10000;

        for (int i = 0; i < totalRuns; i++) {
            int result = generator.generateResult();
            counts.put(result, counts.getOrDefault(result, 0) + 1);
        }

        // Check if the distribution is roughly uniform
        for (int i = 0; i < numberOfChoicesMock; i++) {
            double expectedFrequency = (double) totalRuns / numberOfChoicesMock;
            double actualFrequency = counts.getOrDefault(i, 0);
            assertTrue(Math.abs(actualFrequency - expectedFrequency) < expectedFrequency * 0.1,
                    "Choice " + i + " has unexpected frequency");
        }
    }

    @Test
    void testGetRandomChoice() {
        int numberOfChoicesMock = 3;
        PaperRockScissorsRandomChoiceGenerator generator = new PaperRockScissorsRandomChoiceGenerator(numberOfChoicesMock);

        int randomChoice = generator.generateResult();
        assertTrue(randomChoice >= 0 && randomChoice < numberOfChoicesMock, "getRandomChoice returns invalid choice");
    }
}
