package com.imc.gamestarter;

import com.imc.game.Game;
import com.imc.game.PaperRockScissorsGame;
import com.imc.scorewriter.PaperRockScissorsScoreWriter;
import org.slf4j.Logger;

/**
 * A class responsible for starting a Paper-Rock-Scissors game.
 * Implements the GameStarter interface.
 */
public class PaperRockScissorsGameStarter implements GameStarter {

    private final Logger logger;

    private final PaperRockScissorsGame paperRockScissorsGame;
    private final PaperRockScissorsScoreWriter paperRockScissorsScoreWriter;

    /**
     * Constructs a PaperRockScissorsGameStarter with the provided PaperRockScissorsGame.
     *
     * @param paperRockScissorsGame The PaperRockScissorsGame instance to start.
     */
    public PaperRockScissorsGameStarter(Game paperRockScissorsGame, PaperRockScissorsScoreWriter paperRockScissorsScoreWriter, Logger logger) {
        this.paperRockScissorsGame = (PaperRockScissorsGame) paperRockScissorsGame;
        this.paperRockScissorsScoreWriter = paperRockScissorsScoreWriter;
        this.logger = logger;
    }

    /**
     * Starts the Paper-Rock-Scissors game.
     * Prints the welcome message, number of players, and player names.
     * Writes the initial score using the score writer.
     */
    @Override
    public void startGame() {
        logger.info(paperRockScissorsGame.getWelcomeMessage());
        logger.info("This game will be played with {} players.", paperRockScissorsGame.getPlayerNames().size());
        logger.info("Players are: {}", paperRockScissorsGame.getPlayerNames());
        paperRockScissorsScoreWriter.writeScore(
                paperRockScissorsGame.getPlayerNames(),
                paperRockScissorsGame.getScores()
        );
    }
}
