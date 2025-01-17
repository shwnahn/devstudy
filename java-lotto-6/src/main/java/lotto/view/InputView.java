package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.model.WinningLotto;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public static int readPurchaseAmount() {
        int amount = Integer.parseInt(Console.readLine());
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1,000원 단위여야 합니다.");
        }
        return amount;
    }

    public static List<Integer> readWinningNumbers() {
        String input = Console.readLine();

        // 쉼표로 구분하여 문자열 배열 생성
        List<Integer> numbers = Arrays.stream(input.split(","))
                .map(String::trim) // 공백 제거
                .map(Integer::parseInt) // 문자열을 숫자로 변환
                .collect(Collectors.toList()); // 리스트로 변환

        return numbers;
    }
    public static int readBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }
}

