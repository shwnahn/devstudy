package baseball;

import baseball.model.InputValidator;
import baseball.view.InputView;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserInputTest {
    @Test
    void testGetUserInput() {
        // 모의 사용자 입력을 제공
        String mockInput = "123\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(mockInput.getBytes());
        System.setIn(inputStream);

        // 메서드 실행
        List<Integer> result = InputView.getUserNumbers();

        // 예상 값 확인
        assertEquals(List.of(1, 2, 3), result);
    }

    @Test
    void testToList() {
        // 테스트용 입력값
        String input = "678";

        // 메서드 실행
        List<Integer> result = InputView.toList(input);

        // 예상 값 확인
        assertEquals(List.of(6, 7, 8), result);
    }

    @Test
    void testInputValidation_ValidInput() {
        // 유효한 입력 처리 테스트
        String validInput = "123";
        assertDoesNotThrow(() -> InputValidator.validate(validInput));
    }

    @Test
    void testInputValidation_InvalidLength() {
        // 길이가 3이 아닌 입력 처리 테스트
        String invalidInput = "12";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validate(invalidInput);
        });

        // 예외 메시지 확인
        assertEquals("입력값은 정확히 3자리여야 합니다.", exception.getMessage());
    }

    @Test
    void testInputValidation_NonNumericInput() {
        // 숫자가 아닌 입력 처리 테스트
        String invalidInput = "12a";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validate(invalidInput);
        });

        // 예외 메시지 확인
        assertEquals("입력값은 숫자로만 구성되어야 합니다.", exception.getMessage());
    }

    @Test
    void testInputValidation_DuplicateNumbers() {
        // 중복된 숫자가 포함된 입력 처리 테스트
        String invalidInput = "112";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validate(invalidInput);
        });

        // 예외 메시지 확인
        assertEquals("입력값은 중복되지 않은 숫자여야 합니다.", exception.getMessage());
    }
}
