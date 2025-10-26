package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.domain.RandomNumbers;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RandomNumbers randomNumbers;

    public GameController(InputView inputView, OutputView outputView, RandomNumbers randomNumbers) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.randomNumbers = randomNumbers;
    }

    public void run() {
        try {
            Cars cars = new Cars(inputView.readCarNames());
            RacingGame racingGame = new RacingGame(cars, randomNumbers);
            int rounds = inputView.readRoundCounts();

            playGame(racingGame, cars, rounds);
            showResult(racingGame);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }
    }

    private void playGame(RacingGame racingGame, Cars cars, int rounds) {
        outputView.printResultMessage();
        for (int i = 0; i < rounds; i++) {
            racingGame.runOneRound();
            outputView.printRound(cars);
        }

    }

    private void showResult(RacingGame racingGame) {
        outputView.printWinners(racingGame.getWinners());
    }
}
