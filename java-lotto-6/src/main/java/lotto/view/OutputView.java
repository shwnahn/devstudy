package lotto.view;

import lotto.model.Lotto;

import java.util.List;

public class OutputView {
    public static void printLottoAmount(int lottoAmount) {
        System.out.printf("\n%d개를 구매했습니다.\n", lottoAmount);
    }

    public static void printLottoNumbers(List<Lotto> purchasedLottos) {
        purchasedLottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }


    public static void printProfitRate(double profitRate) {

    }

    public static void askPurchaseInput() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printWinningStatus(List<Integer> matchCounts) {
    }
}
