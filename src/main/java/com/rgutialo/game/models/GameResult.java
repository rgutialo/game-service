package com.rgutialo.game.models;

import com.rgutialo.game.models.enums.GameResultEnum;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * GameResult model
 */
@Getter
@SuperBuilder
@Jacksonized
public class GameResult extends GameRequest {

    private GameResultEnum result;
}
