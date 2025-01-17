package lotto.model;

import java.util.List;
import java.util.Set;

public class WinningLotto {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int winningBonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = winningBonusNumber;
        validate(winningNumbers);
    }

    public static void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        // 숫자가 1~45 범위에 있는지 확인
        if (numbers.stream().anyMatch(n -> n < 1 || n > 45)) {
            throw new IllegalArgumentException("[ERROR] 숫자는 1~45 사이여야 합니다.");
        }
        // 중복 숫자가 없는지 확인
        Set<Integer> uniqueNumbers = Set.copyOf(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
        }
    }

    public static void validate(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 숫자는 1~45 사이여야 합니다.");
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getWinningBonusNumber() {
        return bonusNumber;
    }
}
