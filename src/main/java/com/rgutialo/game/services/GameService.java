package com.rgutialo.game.services;

import com.rgutialo.game.models.GameRequest;
import com.rgutialo.game.models.GameResult;
import com.rgutialo.game.models.enums.GameOptionsEnum;

import java.util.Optional;

/**
 * Service which manages game operations
 */
public interface GameService {

    /**
     * Generates a random option
     *
     * @return {@link GameOptionsEnum}
     */
    GameOptionsEnum generateRandomOption();

    /**
     * Play game
     *
     * @param gameRequest
     * @return {@link Optional<GameResult>} with the game result, based on the incoming request
     */
    Optional<GameResult> playGame(final GameRequest gameRequest);
}
