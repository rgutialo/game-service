package com.rgutialo.game.models.enums;

import lombok.Builder;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@Getter
public enum GameOptionsEnum {

    STONE(0),
    SCISSORS(1),
    PAPER(2);

    private Integer value;

    GameOptionsEnum(final Integer value) {
        this.value = value;
    }

    public static final GameOptionsEnum valueOf (Integer incomingValue) {
        final Optional<GameOptionsEnum> optionFound = Arrays.stream(GameOptionsEnum.values()).filter(option -> option.getValue().equals(incomingValue)).findFirst();
        if (optionFound.isPresent())
            return optionFound.get();
        return null;
    }
}
