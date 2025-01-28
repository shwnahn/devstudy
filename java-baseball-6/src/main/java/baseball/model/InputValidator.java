package baseball.model;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {

    public static void validate(String input) {
        validateLength(input);
        validateNumeric(input);
        validateUniqueDigits(input);
    }

    private static void validateLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력값은 정확히 3자리여야 합니다.");
        }
    }

    private static void validateNumeric(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("입력값은 숫자로만 구성되어야 합니다.");
        }
    }

    private static void validateUniqueDigits(String input) {
        Set<Character> uniqueDigits = new HashSet<>();
        for (char ch : input.toCharArray()) {
            if (!uniqueDigits.add(ch)) {
                throw new IllegalArgumentException("입력값은 중복되지 않은 숫자여야 합니다.");
            }
        }
    }

    public static void validateRestartNumber(String input) {
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException("입력값은 1 또는 2여야 합니다."); // 예외 발생
        }
    }
}