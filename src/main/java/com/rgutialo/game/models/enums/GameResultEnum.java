package com.rgutialo.game.models.enums;

public enum GameResultEnum {

    WIN("WIN"),
    LOOSE("LOOSE"),
    TIE ("TIE");

    private String value;

    GameResultEnum(final String value) {
        this.value = value;
    }
}
