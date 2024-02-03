package com.imc.choicegenerator;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This class generates random choices for a Paper-Rock-Scissors game.
 */
public class PaperRockScissorsRandomChoiceGenerator extends ChoiceGenerator {
    // The random number generator using ThreadLocalRandom for better performance in concurrent scenarios
    private final Random random = ThreadLocalRandom.current();

    /**
     * Constructs a new PaperRockScissorsRandomChoiceGenerator with the specified number of choices.
     *
     * @param numberOfChoices The total number of choices available in the game.
     */
    public PaperRockScissorsRandomChoiceGenerator(int numberOfChoices) {
        this.numberOfChoices = numberOfChoices;
    }

    /**
     * Generates a random choice.
     *
     * @return The generated random choice.
     */
    @Override
    public int generateResult() {
        return getRandomChoice();
    }

    /**
     * Gets a random choice within the specified range.
     *
     * @return A random choice.
     */
    private int getRandomChoice() {
        return random.nextInt(numberOfChoices);
    }
}
