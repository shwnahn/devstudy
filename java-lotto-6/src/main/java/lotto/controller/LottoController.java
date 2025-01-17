package lotto.controller;

import lotto.model.Lotto;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    public void run() {
//        1. 로또 구입
//        구입 금액 입력
        OutputView.askPurchaseInput();
        int purchaseAmount = InputView.readPurchaseAmount();
//        입력한만큼 로또 구매
        int lottoAmount = purchaseAmount / 1000;

//        2. 로또 발행
        List<Lotto> purchasedLottos = new ArrayList<>();
        for (int i = 0; i < lottoAmount; i++) {
            purchasedLottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }

//        3. 발행 내역 출력
        OutputView.printLottoAmount(lottoAmount);
        OutputView.printLottoNumbers(purchasedLottos);

//        4. 당첨 번호 입력
        OutputView.askWinningInput();
        List<Integer> winningNumbers = InputView.readWinningNumbers();
        WinningLotto.validate(winningNumbers);

        OutputView.askBonusInput();
        int bonusNumber = InputView.readBonusNumber();
        WinningLotto.validate(bonusNumber);

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

//        5. 당첨 여부 조회
        // 번호마다 순회하며 비교
        List<Integer> matchCounts = checkWinning(purchasedLottos, winningLotto);

//        6. 당첨 내역 출력
        OutputView.printWinningStatus(matchCounts);

//        7. 수익률 계산 및 출력
        double profitRate = calculateProfitRate(matchCounts);
        OutputView.printProfitRate(profitRate);
//
    }

    private double calculateProfitRate(List<Integer> matchCounts) {
        return 0;
    }

    private List<Integer> checkWinning(List<Lotto> purchasedLottos, WinningLotto winningLotto) {
        return List.of();
    }
}
