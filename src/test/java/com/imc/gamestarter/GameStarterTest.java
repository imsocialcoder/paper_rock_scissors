package com.imc.gamestarter;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class GameStarterTest {

    @Test
    void startGame_ShouldInvokeStartGameMethod() {
        // Create a mock implementation of GameStarter
        GameStarter gameStarterMock = Mockito.mock(GameStarter.class);

        // Call the startGame method
        gameStarterMock.startGame();

        // Verify that the startGame method was called exactly once
        Mockito.verify(gameStarterMock, Mockito.times(1)).startGame();
    }
}
