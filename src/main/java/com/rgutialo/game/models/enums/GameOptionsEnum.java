package com.rgutialo.game.models.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

/**
 * Game option enum with all mappings between values and names
 */
@Getter
public enum GameOptionsEnum {

    STONE(0),
    SCISSORS(1),
    PAPER(2);

    private Integer value;

    GameOptionsEnum(final Integer value) {
        this.value = value;
    }

    /**
     * Transforms and incoming number value into a valud GameOptionsEnum value
     *
     * @param incomingValue
     * @return GameOptionsEnum based on the incoming parameter received. If incoming value is invalid, null value returned
     */
    public static final GameOptionsEnum valueOf(Integer incomingValue) {
        final Optional<GameOptionsEnum> optionFound = Arrays.stream(GameOptionsEnum.values()).filter(option -> option.getValue().equals(incomingValue)).findFirst();
        if (optionFound.isPresent())
            return optionFound.get();
        return null;
    }
}
