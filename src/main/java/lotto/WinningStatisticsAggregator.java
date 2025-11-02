package lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningStatisticsAggregator {
    public Map<Rank, Integer> aggregate(List<Lotto> issuedLottos, List<Integer> winningNumbers, int bonusNumber) {
        Map<Rank, Integer> statistics = initializeStatisticsMap();

        for (Lotto lotto : issuedLottos) {
            Rank rank = determineRank(lotto, winningNumbers, bonusNumber);
            statistics.put(rank, statistics.get(rank) + 1);
        }

        return statistics;
    }

    private Map<Rank, Integer> initializeStatisticsMap() {
        Map<Rank, Integer> statistics = new EnumMap<>(Rank.class);

        for (Rank rank : Rank.values()) {
            statistics.put(rank, 0);
        }

        return statistics;
    }

    private Rank determineRank(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = countMatches(lotto, winningNumbers);
        boolean bonusMatch = checkBonusMatch(lotto, bonusNumber);

        return Rank.valueOf(matchCount, bonusMatch);
    }

    private int countMatches(Lotto lotto, List<Integer> winningNumbers) {
        int count = 0;

        for (int number : lotto.getNumbers()) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }

        return count;
    }

    private boolean checkBonusMatch(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
