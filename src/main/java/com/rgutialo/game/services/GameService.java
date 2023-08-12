package com.rgutialo.game.services;

import com.rgutialo.game.models.GameRequest;
import com.rgutialo.game.models.GameResult;
import com.rgutialo.game.models.enums.GameOptionsEnum;

import java.util.Optional;

public interface GameService {

    GameOptionsEnum generateRandomOption();
    Optional<GameResult> playGame(final GameRequest gameRequest);
}
