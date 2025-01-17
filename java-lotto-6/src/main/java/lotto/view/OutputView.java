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

    public static void askPurchaseInput() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void askWinningInput() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public static void askBonusInput() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public static void printWinningStatus(List<Integer> matchCounts) {
    }

    public static void printProfitRate(double profitRate) {

    }
}
