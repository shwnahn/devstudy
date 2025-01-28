package baseball.controller;

import baseball.model.Computer;
import baseball.model.Result;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class GameController {
    public void startGame() {
        boolean isRunning = true;
        // 게임 시작 메세지 출력
        OutputView.printGameStartMessage();

        while (isRunning) {
            playGame();
            isRunning = InputView.getIfRestart();
        }
    }

    private void playGame() {
        // 정답 숫자 생성
        Computer computer = new Computer();
        List<Integer> computerNumbers = computer.generateNumbers();

        boolean isCorrect = false;
        while (!isCorrect) {
            // 사용자에게 숫자 받기
            List<Integer> userNumbers = InputView.getUserNumbers();
            // 사용자에게 받은 숫자로 게임 진행 (정답 맞출때까지)
            String result = Result.calculate(computerNumbers, userNumbers);
            OutputView.printResult(result);

            if (result.equals("3스트라이크")) {
                OutputView.printGameWinMessage();
                isCorrect = true;
            }
        }
    }
}
