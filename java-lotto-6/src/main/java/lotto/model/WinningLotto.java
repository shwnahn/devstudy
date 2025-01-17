package lotto.model;

import java.util.List;

public class WinningLotto {
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int winningBonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = winningBonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getWinningBonusNumber() {
        return bonusNumber;
    }
}
