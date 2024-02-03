package com.imc.gamerunner;

import com.imc.choicegenerator.ChoiceGenerator;
import com.imc.gameinteraction.PaperRockScissorsGameInteractionManager;
import com.imc.resultdeterminer.ResultDeterminer;
import com.imc.game.PaperRockScissorsGame;
import com.imc.gamestarter.PaperRockScissorsGameStarter;
import com.imc.scoreupdater.ScoreUpdater;
import com.imc.scorewriter.ScoreWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import java.util.List;

import static org.mockito.Mockito.*;

class PaperRockScissorsGameRunnerTest {

    @Mock
    private Logger logger;

    @Mock
    private PaperRockScissorsGameInteractionManager interactionManager;

    @Mock
    private ChoiceGenerator choiceGenerator;

    @Mock
    private ResultDeterminer resultDeterminer;

    @Mock
    private PaperRockScissorsGame game;

    @Mock
    private PaperRockScissorsGameStarter gameStarter;

    @Mock
    private ScoreUpdater scoreUpdater;

    @Mock
    private ScoreWriter scoreWriter;

    @InjectMocks
    private PaperRockScissorsGameRunner gameRunner;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void runGame_ShouldStartGame() {
        when(interactionManager.getNumberOfRounds()).thenReturn(3);
        when(game.getPlayerNames()).thenReturn(List.of("Player1", "Player2"));

        gameRunner.runGame();

        verify(gameStarter).startGame();
    }

    @Test
    void proceedGame_ShouldGetNumberOfRounds() {
        when(interactionManager.getNumberOfRounds()).thenReturn(3);
        when(game.getPlayerNames()).thenReturn(List.of("Player1", "Player2"));

        gameRunner.proceedGame();

        verify(interactionManager).getNumberOfRounds();
    }

    @Test
    void runRound_ShouldUpdateScoreAndLogResult() {
        when(interactionManager.getNumberOfRounds()).thenReturn(1);
        when(game.getPlayerNames()).thenReturn(List.of("Player1", "Player2"));
        when(game.getScores()).thenReturn(List.of(0, 0));
        when(choiceGenerator.generateResult()).thenReturn(0);
        when(resultDeterminer.determineResult(any(), any())).thenReturn("Player1 wins");

        gameRunner.runGame();

        // Verify that the score is updated
        verify(scoreUpdater).updateScore("Player1 wins", List.of("Player1", "Player2"), List.of(0,0));
    }

    @Test
    void logRoundResult_ShouldLogResult() {
        // Mock the necessary dependencies and call the method
        gameRunner.logRoundResult("Player1 wins");

        // Verify that the result is logged
        verify(logger).info("Player1 wins");
    }
}
