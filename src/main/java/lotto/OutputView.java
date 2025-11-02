package lotto;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void printQuantity(int quantity) {
        System.out.println();
        System.out.println(quantity + "개를 구매했습니다.");
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public void printStatisticsHeader() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public void printWinningStatistics(Map<Rank, Integer> statistics) {
        List<Rank> ranksToPrint = List.of(
                Rank.FIFTH,
                Rank.FOURTH,
                Rank.THIRD,
                Rank.SECOND,
                Rank.FIRST
        );

        for (Rank rank : ranksToPrint) {
            String description = rank.getDescriptionAndMoney();
            int count = statistics.get(rank);

            System.out.println(description + " - " + count + "개");
        }
    }

    public void printProfitRate(double profitRate) {
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", profitRate));
    }
}
