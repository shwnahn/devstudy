package baseball.view;

import baseball.model.InputValidator;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static baseball.model.InputValidator.validateRestartNumber;

public class InputView {

    public static List<Integer> getUserNumbers() {
        OutputView.askNumber();
        String input = Console.readLine();
        InputValidator.validate(input);
        return toList(input);
    }

    public static boolean getIfRestart() {
        OutputView.printGameEndMessage();
        String input = Console.readLine();
        // 입력값 검증
        validateRestartNumber(input);
        if (input.equals("1")) {
            return true; // 재시작
        } else if (input.equals("2")) {
            return false; // 종료
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> toList(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (char ch : input.toCharArray()) {
            numbers.add(Character.getNumericValue(ch));
        }
        return numbers;
    }
}
