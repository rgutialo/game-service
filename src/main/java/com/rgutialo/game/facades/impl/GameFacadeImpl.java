package com.rgutialo.game.facades.impl;

import com.rgutialo.game.facades.GameFacade;
import com.rgutialo.game.models.GameRequest;
import com.rgutialo.game.models.GameResult;
import com.rgutialo.game.models.enums.GameOptionsEnum;
import com.rgutialo.game.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;

@Component
public class GameFacadeImpl implements GameFacade {

    @Autowired
    private final GameService gameService;

    public GameFacadeImpl(final GameService gameService) {
        this.gameService = gameService;
    }

    @Override
    public Optional<GameOptionsEnum> setUserOption(final Integer option) {
        if (!validateOption(option))
            return Optional.empty();
        return Optional.of(GameOptionsEnum.valueOf(option));
    }

    @Override
    public GameOptionsEnum getComputerOption() {
        return gameService.generateRandomOption();
    }

    @Override
    public Optional<GameResult> playGame(final GameRequest gameRequest) {
        return gameService.playGame(gameRequest);
    }

    private boolean validateOption(final Integer userOption){
        if (Arrays.stream(GameOptionsEnum.values()).anyMatch(options -> options.getValue().equals(userOption)))
            return true;
        return false;
    }
}
