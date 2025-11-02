package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RateCalculatorTest {
    private final RateCalculator rateCalculator = new RateCalculator();

    @DisplayName("수익률을 계산한다.")
    @Test
    void 수익률을_계산한다() {
        int purchaseAmount = 8000;

        Map<Rank, Integer> statistics = new EnumMap<>(Rank.class);
        statistics.put(Rank.FIRST, 0);
        statistics.put(Rank.SECOND, 0);
        statistics.put(Rank.THIRD, 0);
        statistics.put(Rank.FOURTH, 0);
        statistics.put(Rank.FIFTH, 1);
        statistics.put(Rank.MISS, 7);

        double profitRate = rateCalculator.calculateRate(purchaseAmount, statistics);

        assertThat(profitRate).isEqualTo(62.5);
    }
}
