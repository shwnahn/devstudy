package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    // 자동차 이름 List에 저장
    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputNames = Console.readLine();
        return parseCarNames(inputNames);
    }

    // 검증
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

    // 시도회수 저장
    public static int getTrialCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return parseTrialCount(Console.readLine());
    }

    // 검증
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
