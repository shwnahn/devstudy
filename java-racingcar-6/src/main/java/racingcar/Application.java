package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // TODO 1. input 구현
        // 자동차 이름 List에 저장
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputNames = Console.readLine();
        // 자동차 이름 List에 저장
        List<String> carNames = parseCarNames(inputNames);

        System.out.println("시도할 회수는 몇회인가요?");
        // 시도회수 저장
        int trialCount = parseTrialCount(Console.readLine());

        // TODO 2. 게임 실행
        RacingGame game = new RacingGame(carNames, trialCount);
        game.start();

        // TODO 3. 최종 우승자 선정

    }

    private static List<String> parseCarNames(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("올바른 자동차 이름을 입력해주세요.");
        }
        // 입력된 문자열을 ,로 분리하여, List<String> 형태로 저장
        List<String> carNames = Arrays.asList(input.split(","));
        // 이름 순회하며 검증
        for (String name : carNames) {
            if (name.isEmpty() || name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
        return carNames;
    }

    private static int parseTrialCount(String input) {
        try {
            int trialCount = Integer.parseInt(input);
            if (trialCount <= 0) {
                throw new IllegalArgumentException("시도 횟수는 양의 정수여야 합니다.");
            }
            return trialCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }
}
