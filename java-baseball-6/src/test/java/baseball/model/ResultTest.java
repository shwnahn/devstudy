package baseball.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultTest {

    @Test
    void testStrikeAndBall() {
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> player = List.of(1, 3, 2);

        String result = Result.calculate(computer, player);
        System.out.println(result);

        // 1스트라이크, 2볼
        assertEquals("2볼 1스트라이크", result);
    }

    @Test
    void testAllStrike() {
        List<Integer> computer = List.of(4, 5, 6);
        List<Integer> player = List.of(4, 5, 6);

        String result = Result.calculate(computer, player);

        // 3스트라이크
        assertEquals("3스트라이크", result);
    }

    @Test
    void testAllBall() {
        List<Integer> computer = List.of(7, 8, 9);
        List<Integer> player = List.of(9, 7, 8);

        String result = Result.calculate(computer, player);
        System.out.println(result);

        // 3볼
        assertEquals("3볼", result);
    }

    @Test
    void testNothing() {
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> player = List.of(4, 5, 6);

        String result = Result.calculate(computer, player);
        System.out.println(result);

        // 낫싱
        assertEquals("낫싱", result);
    }

}
