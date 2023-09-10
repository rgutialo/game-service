package com.rgutialo.game.services.impl;

import com.rgutialo.game.config.ConfigProperties;
import com.rgutialo.game.models.GameRequest;
import com.rgutialo.game.models.enums.GameOptionsEnum;
import com.rgutialo.game.models.enums.GameResultEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class GameServiceImplTest {

    private GameServiceImpl testObj;

    @Mock
    private GameRequest gameRequestMock;

    @BeforeEach
    private void setUp() {
        final ConfigProperties configProperties = new ConfigProperties();
        testObj = new GameServiceImpl(configProperties.winLoseMatrix());
    }

    @Test
    void generateRandomOption_thenGeneratesValidGameOptionsEnum() {
        final var result = testObj.generateRandomOption();

        assertThat(result).isInstanceOf(GameOptionsEnum.class);
    }

    @Test
    void playGame_whenNoUserOptionDefined_thenOptionalEmptyReturned() {
        Mockito.when(gameRequestMock.getComputerOption()).thenReturn(GameOptionsEnum.PAPER);

        final var result = testObj.playGame(gameRequestMock);

        assertThat(result).isEmpty();
    }

    @Test
    void playGame_whenNoComputerOptionDefined_thenOptionalEmptyReturned() {
        Mockito.when(gameRequestMock.getUserOption()).thenReturn(GameOptionsEnum.PAPER);

        final var result = testObj.playGame(gameRequestMock);

        assertThat(result).isEmpty();
    }

    @Test
    void playGame_whenUserAndComputerOptionsDefined_thenOptionofGameResultIsReturned() {
        Mockito.when(gameRequestMock.getUserOption()).thenReturn(GameOptionsEnum.PAPER);
        Mockito.when(gameRequestMock.getComputerOption()).thenReturn(GameOptionsEnum.PAPER);

        final var result = testObj.playGame(gameRequestMock);

        assertThat(result).isPresent();
        assertThat(result.get().getResult()).isEqualTo(GameResultEnum.TIE);
    }
}