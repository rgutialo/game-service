package com.rgutialo.game.facades.impl;

import com.rgutialo.game.models.GameRequest;
import com.rgutialo.game.models.GameResult;
import com.rgutialo.game.models.enums.GameOptionsEnum;
import com.rgutialo.game.services.GameService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class GameFacadeImplTest {
    @InjectMocks
    private GameFacadeImpl testObj;

    @Mock
    private GameService gameServiceMock;

    @Mock
    private GameRequest gameRequestMock;

    @Test
    void setUserOption_whenIncomingValueIsValid_thenResultIsPresent() {
        final var result = testObj.setUserOption(0);
        assertThat(result).isPresent();
    }
    @Test
    void setUserOption_whenIncomingValueIsNotValid_thenOptionalEmptyIsReturned() {
        final var result = testObj.setUserOption(9999);
        assertThat(result).isEmpty();
    }

    @Test
    void getComputerOption_callGameService() {

        testObj.getComputerOption();
        Mockito.verify(gameServiceMock).generateRandomOption();
    }

    @Test
    void playGame_callGameService() {
        testObj.playGame(gameRequestMock);

        Mockito.verify(gameServiceMock).playGame(gameRequestMock);
    }
}