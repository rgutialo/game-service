package com.rgutialo.game.controllers;

import com.rgutialo.game.facades.GameFacade;
import com.rgutialo.game.models.GameRequest;
import com.rgutialo.game.models.GameResult;
import com.rgutialo.game.models.enums.GameOptionsEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

/**
 * Game Controller
 */
@RestController
@RequestMapping("/game")
@CrossOrigin(origins = "http://localhost:4200/")
public class GameController {

    @Autowired
    private final GameFacade gameFacade;

    public GameController(final GameFacade gameFacade) {
        this.gameFacade = gameFacade;
    }

    /**
     * Get method which validates user option selection
     *
     * @param option
     * @return {@link ResponseEntity< GameOptionsEnum>} Return valid game option. Otherwise, BAD_REQUEST error.
     */
    @GetMapping("/user-option")
    public ResponseEntity<GameOptionsEnum> setUserOption(@RequestParam @NonNull Integer option) {

        Optional<GameOptionsEnum> userOption = gameFacade.setUserOption(option);
        if (userOption.isPresent())
            return ResponseEntity.accepted().body(userOption.get());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    /**
     * Get method which returns a random option
     *
     * @return {@link ResponseEntity< GameOptionsEnum>} Return valid game option.
     */
    @GetMapping("/computer-option")
    public ResponseEntity<GameOptionsEnum> getComputerOption() {
        final GameOptionsEnum computerOption = gameFacade.getComputerOption();
        return ResponseEntity.accepted().body(computerOption);
    }

    /**
     * Post method to play game
     *
     * @param gameRequest {@link GameRequest} with user and computer option to play
     * @return {@link ResponseEntity<GameResult>} with user option, computer option and result when input is correct. Otherwise, BAD_REQUEST error.
     */
    @PostMapping("/play")
    public ResponseEntity<GameResult> playGame(@RequestBody @NonNull GameRequest gameRequest) {
        if (Objects.isNull(gameRequest))
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).build();
        final Optional<GameResult> gameResult = gameFacade.playGame(gameRequest);
        if (gameResult.isPresent())
            return ResponseEntity.accepted().body(gameResult.get());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
