package com.rgutialo.game.facades;

import com.rgutialo.game.models.GameRequest;
import com.rgutialo.game.models.GameResult;
import com.rgutialo.game.models.enums.GameOptionsEnum;

import java.util.Optional;

/**
 * Manages the business logic and transformations between internal and external model
 */
public interface GameFacade {

    /**
     * Validates and returns a valid option based on the incoming parameter
     *
     * @param option
     * @return {@link Optional<GameOptionsEnum>} Valid user option based on the incoming value
     */
    Optional<GameOptionsEnum> setUserOption (final Integer option);

    /**
     * Generates a random option for the computer player
     *
     * @return {@link GameOptionsEnum} Valid computer random option
     */
    GameOptionsEnum getComputerOption();

    /**
     * Play game with user and computer options
     *
     * @param gameRequest
     * @return {@link Optional<GameResult>} with the result of the {@link GameRequest} received
     */
    Optional<GameResult> playGame (final GameRequest gameRequest);

}
