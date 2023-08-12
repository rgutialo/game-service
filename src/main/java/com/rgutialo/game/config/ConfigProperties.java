package com.rgutialo.game.config;

import com.rgutialo.game.models.enums.GameOptionsEnum;
import com.rgutialo.game.models.enums.GameResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@Slf4j
public class ConfigProperties {

    @Bean
    public Map<GameOptionsEnum, List<Pair<GameOptionsEnum, GameResultEnum>>> winLoseMatrix() {
        Map<GameOptionsEnum, List<Pair<GameOptionsEnum, GameResultEnum>>> winLoseMatrix = new HashMap<>();
        winLoseMatrix.put(GameOptionsEnum.STONE, List.of(Pair.of(GameOptionsEnum.STONE, GameResultEnum.TIE), Pair.of(GameOptionsEnum.PAPER, GameResultEnum.LOOSE), Pair.of(GameOptionsEnum.SCISSORS, GameResultEnum.WIN)));
        winLoseMatrix.put(GameOptionsEnum.PAPER, List.of(Pair.of(GameOptionsEnum.STONE, GameResultEnum.WIN), Pair.of(GameOptionsEnum.PAPER, GameResultEnum.TIE), Pair.of(GameOptionsEnum.SCISSORS, GameResultEnum.LOOSE)));
        winLoseMatrix.put(GameOptionsEnum.SCISSORS, List.of(Pair.of(GameOptionsEnum.STONE, GameResultEnum.LOOSE), Pair.of(GameOptionsEnum.PAPER, GameResultEnum.WIN), Pair.of(GameOptionsEnum.SCISSORS, GameResultEnum.TIE)));
        return winLoseMatrix;
    }

}
