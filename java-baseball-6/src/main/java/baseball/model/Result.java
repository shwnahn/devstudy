package baseball.model;

import java.util.List;

public class Result {

    public static String calculate(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        final int NUMBER_SIZE = 3;
        int strike = 0;
        int ball = 0;

        // 3개 숫자 순회하며 스트라이크와 볼 계산
        for (int i = 0; i < NUMBER_SIZE; i++) {
            if (computerNumbers.get(i).equals(playerNumbers.get(i))) {
                strike++;
            } else if (playerNumbers.contains(computerNumbers.get(i))) {
                ball++;
            }
        }

        // 결과 생성
        if (strike == 0 && ball == 0) {
            return "낫싱";
        }

        StringBuilder result = new StringBuilder();
        if (ball > 0) {
            result.append(ball).append("볼 ");
        }
        if (strike > 0) {
            result.append(strike).append("스트라이크");
        }
        return result.toString().trim();
    }
}
