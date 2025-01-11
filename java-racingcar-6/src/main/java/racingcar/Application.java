package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO 1. input 구현 -> View로 이동
        List<String> carNames = InputView.getCarNames();
        int trialCount = InputView.getTrialCount();

        // TODO 2. 게임 실행 + TODO 3. 최종 우승자 선정
        RacingGame game = new RacingGame(carNames, trialCount);
        game.start();

        List<String> winners = game.findWinners();
        OutputView.printWinners(winners);

    }
}
