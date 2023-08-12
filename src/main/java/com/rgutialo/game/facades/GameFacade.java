package com.rgutialo.game.facades;

import com.rgutialo.game.models.GameRequest;
import com.rgutialo.game.models.GameResult;
import com.rgutialo.game.models.enums.GameOptionsEnum;

import java.util.Optional;

public interface GameFacade {

    Optional<GameOptionsEnum> setUserOption (final Integer option);
    GameOptionsEnum getComputerOption();
    Optional<GameResult> playGame (final GameRequest gameRequest);

}
