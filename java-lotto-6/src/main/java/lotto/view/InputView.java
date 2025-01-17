package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.awt.*;
import java.util.List;

public class InputView {

    public static int readPurchaseAmount() {
        OutputView.askPurchaseInput();
        int amount = Integer.parseInt(Console.readLine());
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1,000원 단위여야 합니다.");
        }
        return amount;
    }

    public static int readBonusNumber() {
        return 0;
    }

    public static List<Integer> readWinningNumbers() {
        return List.of();
    }
}
