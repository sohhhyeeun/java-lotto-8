package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningStatisticsAggregatorTest {
    private final WinningStatisticsAggregator winningStatisticsAggregator = new WinningStatisticsAggregator();

    @DisplayName("사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역을 집계한다.")
    @Test
    void 사용자가_구매한_로또_번호와_당첨_번호를_비교하여_당첨_내역을_집계한다() {
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);
        int bonusNumber = 7;

        List<Lotto> issuedLottos = List.of(
                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45))
        );

        Map<Rank, Integer> statistics = winningStatisticsAggregator.aggregate(issuedLottos, winningNumbers, bonusNumber);

        assertThat(statistics.get(Rank.FIRST)).isEqualTo(0);
        assertThat(statistics.get(Rank.SECOND)).isEqualTo(0);
        assertThat(statistics.get(Rank.THIRD)).isEqualTo(0);
        assertThat(statistics.get(Rank.FOURTH)).isEqualTo(0);
        assertThat(statistics.get(Rank.FIFTH)).isEqualTo(1);
        assertThat(statistics.get(Rank.MISS)).isEqualTo(7);
    }
}
