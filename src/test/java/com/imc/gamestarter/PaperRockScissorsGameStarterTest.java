package com.imc.gamestarter;

import com.imc.game.PaperRockScissorsGame;
import com.imc.scorewriter.PaperRockScissorsScoreWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class PaperRockScissorsGameStarterTest {

    @Mock
    private Logger logger;

    @Mock
    private PaperRockScissorsGame paperRockScissorsGame;

    @Mock
    private PaperRockScissorsScoreWriter paperRockScissorsScoreWriter;

    @InjectMocks
    private PaperRockScissorsGameStarter gameStarter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void startGame_ShouldLogWelcomeMessageAndPlayerInformation() {
        when(paperRockScissorsGame.getWelcomeMessage()).thenReturn("Welcome to the Game");
        when(paperRockScissorsGame.getPlayerNames()).thenReturn(List.of("Player1", "Player2"));
        when(paperRockScissorsGame.getScores()).thenReturn(List.of(0, 0));

        gameStarter.startGame();

        verify(logger).info("Welcome to the Game");
        verify(logger).info("This game will be played with {} players.", 2);
        verify(logger).info("Players are: {}", List.of("Player1", "Player2"));
    }

    @Test
    void startGame_ShouldWriteInitialScore() {
        when(paperRockScissorsGame.getPlayerNames()).thenReturn(List.of("Player1", "Player2"));
        when(paperRockScissorsGame.getScores()).thenReturn(List.of(0, 0));

        gameStarter.startGame();

        verify(paperRockScissorsScoreWriter).writeScore(List.of("Player1", "Player2"), List.of(0, 0));
    }
}
