package com.rgutialo.game.services.impl;

import com.rgutialo.game.models.GameRequest;
import com.rgutialo.game.models.GameResult;
import com.rgutialo.game.models.enums.GameOptionsEnum;
import com.rgutialo.game.models.enums.GameResultEnum;
import com.rgutialo.game.services.GameService;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.random.RandomGenerator;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    @Qualifier("winLoseMatrix")
    private final Map<GameOptionsEnum, List<Pair<GameOptionsEnum, GameResultEnum>>> winLoseMatrix;

    public GameServiceImpl(final Map<GameOptionsEnum, List<Pair<GameOptionsEnum, GameResultEnum>>> winLoseMatrix) {
        this.winLoseMatrix = winLoseMatrix;
    }

    @Override
    public GameOptionsEnum generateRandomOption() {
        RandomGenerator generator = RandomGenerator.getDefault();
        final int randomOption = generator.nextInt(0, GameOptionsEnum.values().length);
        return GameOptionsEnum.valueOf(randomOption);
    }

    @Override
    public Optional<GameResult> playGame(final GameRequest gameRequest) {
        final GameOptionsEnum userOption = gameRequest.getUserOption();
        final GameOptionsEnum computerOption = gameRequest.getComputerOption();
        final Optional<Pair<GameOptionsEnum, GameResultEnum>> gameResult = winLoseMatrix.entrySet().stream()
                .filter(option -> option.getKey().equals(userOption))
                .flatMap(x -> x.getValue().stream())
                .filter(pairedOption -> pairedOption.getLeft().equals(computerOption))
                .findFirst();

        if (gameResult.isPresent()) {
            return Optional.of(GameResult.builder()
                    .userOption(userOption)
                    .computerOption(computerOption)
                    .result(gameResult.get().getRight())
                    .build());
        }
        return Optional.empty();
    }
}
