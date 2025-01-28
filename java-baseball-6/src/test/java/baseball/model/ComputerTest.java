package baseball.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ComputerTest {

    @Test
    void 랜덤숫자_3개_생성() {
        Computer computer = new Computer();
        // 1000번 테스트
        for (int i = 0; i < 100; i++) {
            List<Integer> numbers = computer.generateNumbers();
//            System.out.println(numbers);
            // 테스트 검증: (1) 3개의 숫자 (2) 중복되지 않은 숫자 (3) 범위(1~9)의 숫자
            assertEquals(3,numbers.size());
            assertEquals(3, numbers.stream().distinct().count());
            assertTrue(numbers.stream().allMatch(n -> n >= 1 && n <= 9));
        }
    }
}
