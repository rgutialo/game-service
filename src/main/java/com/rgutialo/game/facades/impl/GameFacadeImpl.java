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

/**
 * Implementation of {@link GameFacade}
 */
@Component
public class GameFacadeImpl implements GameFacade {

    @Autowired
    private final GameService gameService;

    public GameFacadeImpl(final GameService gameService) {
        this.gameService = gameService;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<GameOptionsEnum> setUserOption(final Integer option) {
        if (!validateOption(option))
            return Optional.empty();
        return Optional.of(GameOptionsEnum.valueOf(option));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GameOptionsEnum getComputerOption() {
        return gameService.generateRandomOption();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<GameResult> playGame(final GameRequest gameRequest) {
        return gameService.playGame(gameRequest);
    }

    /**
     * {@inheritDoc}
     */
    private boolean validateOption(final Integer userOption) {
        if (Arrays.stream(GameOptionsEnum.values()).anyMatch(options -> options.getValue().equals(userOption)))
            return true;
        return false;
    }

    private boolean validateOption2(final String userOption) {
        if (Arrays.stream(GameOptionsEnum.values()).anyMatch(options -> options.getValue().equals(userOption)))
            return true;
        return false;
    }

}
