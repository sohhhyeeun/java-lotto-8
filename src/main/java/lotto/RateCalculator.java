package lotto;

import java.util.Map;

public class RateCalculator {
    public double calculateRate(int purchaseAmount, Map<Rank, Integer> statistics) {
        long totalPrize = calculateTotalPrize(statistics);

        if (purchaseAmount == 0) {
            return 0.0;
        }

        return (double) totalPrize / purchaseAmount * 100.0;
    }

    private long calculateTotalPrize(Map<Rank, Integer> statistics) {
        long totalPrize = 0;

        for (Rank rank : statistics.keySet()) {
            int count = statistics.get(rank);
            long prizeMoney = rank.getPrizeMoney();

            totalPrize += prizeMoney * count;
        }

        return totalPrize;
    }
}
