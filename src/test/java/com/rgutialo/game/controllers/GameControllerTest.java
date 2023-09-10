package com.rgutialo.game.controllers;

import com.rgutialo.game.facades.GameFacade;
import com.rgutialo.game.models.GameRequest;
import com.rgutialo.game.models.GameResult;
import com.rgutialo.game.models.enums.GameOptionsEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GameControllerTest {
    @InjectMocks
    private GameController testObj;

    @Mock
    private GameFacade gameFacadeMock;

    @Mock
    private GameRequest gameRequestMock;

    @Mock
    private GameResult gameResultMock;


    @Test
    void setUserOption_whenIncomingValueIsValid_thenGameOptionEnumIsReturned() {
        when(gameFacadeMock.setUserOption(0)).thenReturn(Optional.of(GameOptionsEnum.STONE));

        final var result = testObj.setUserOption(0);

        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(result.getBody()).isEqualTo(GameOptionsEnum.STONE);
    }

    @Test
    void setUserOption_whenIncomingValueIsNotValid_thenBAD_REQUESTIsReturnedAndBodyIsNull() {
        when(gameFacadeMock.setUserOption(5)).thenReturn(Optional.empty());

        final var result = testObj.setUserOption(5);

        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(result.getBody()).isNull();
    }

    @Test
    void getComputerOption_returnsValidGameOptions() {
        when(gameFacadeMock.getComputerOption()).thenReturn(GameOptionsEnum.PAPER);

        final var result = testObj.getComputerOption();

        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(result.getBody()).isEqualTo(GameOptionsEnum.PAPER);
    }

    @Test
    void playGame_whenRequestIsValid_thenGameResultIsReturned() {
        when(gameFacadeMock.playGame(gameRequestMock)).thenReturn(Optional.of(gameResultMock));

        final var result = testObj.playGame(gameRequestMock);

        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.ACCEPTED);
        assertThat(result.getBody()).isEqualTo(gameResultMock);
    }

    @Test
    void playGame_whenRequestIsEmpty_thenGameResultIsReturned() {
        final var result = testObj.playGame(null);

        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.PRECONDITION_FAILED);
    }

    @Test
    void playGame_whenRequestIsNotValid_thenBAD_REQUESTIsReturned() {
        final var result = testObj.playGame(gameRequestMock);

        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }
}