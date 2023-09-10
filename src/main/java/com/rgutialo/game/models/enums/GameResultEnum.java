package com.rgutialo.game.models.enums;

/**
 * Game result enum with all possible game results.
 */
public enum GameResultEnum {

    WIN("WIN"),
    LOOSE("LOOSE"),
    TIE("TIE");

    private String value;

    GameResultEnum(final String value) {
        this.value = value;
    }
}
