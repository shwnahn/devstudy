package baseball.view;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    @Test
    void 유효한_입력값_처리() {
        List<Integer> result = InputView.toList("123");
        assertEquals(3, result.size());
        assertTrue(result.containsAll(List.of(1, 2, 3)));
    }
}