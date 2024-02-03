package com.imc.choicegenerator;

/**
 * An abstract class representing a choice generator in a game.
 * Concrete implementations are expected to provide the logic
 * for generating a result based on the number of available choices.
 */
public abstract class ChoiceGenerator {

    /**
     * The number of available choices for the generator.
     * Concrete implementations should initialize this value.
     */
    protected int numberOfChoices;

    /**
     * Generates a result based on the number of available choices.
     *
     * @return The generated result.
     */
    public abstract int generateResult();
}
