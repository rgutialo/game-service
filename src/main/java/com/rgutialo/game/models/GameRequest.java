package com.rgutialo.game.models;

import com.rgutialo.game.models.enums.GameOptionsEnum;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.io.Serializable;

@Getter
@SuperBuilder
@Jacksonized
public class GameRequest implements Serializable {

    protected GameOptionsEnum userOption;
    protected GameOptionsEnum computerOption;
}
