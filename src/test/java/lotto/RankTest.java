package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @DisplayName("6개의 번호가 일치하면 1등에 당첨된다.")
    @Test
    void 여섯개의_번호가_일치하면_1등에_당첨된다() {
        assertThat(Rank.valueOf(6, false)).isEqualTo(Rank.FIRST);
        assertThat(Rank.valueOf(6, true)).isEqualTo(Rank.FIRST);
    }

    @DisplayName("5개의 번호가 일치하고 보너스 번호가 일치하면 2등에 당첨된다.")
    @Test
    void 다섯개의_번호가_일치하고_보너스_번호가_일치하면_2등에_당첨된다() {
        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
    }

    @DisplayName("5개의 번호가 일치하고 보너스 번호가 불일치하면 3등에 당첨된다.")
    @Test
    void 다섯개의_번호가_일치하고_보너스_번호가_불일치하면_3등에_당첨된다() {
        assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD);
    }

    @DisplayName("4개의 번호가 일치하면 4등에 당첨된다.")
    @Test
    void 네개의_번호가_일치하면_4등에_당첨된다() {
        assertThat(Rank.valueOf(4, false)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.valueOf(4, true)).isEqualTo(Rank.FOURTH);
    }

    @DisplayName("3개의 번호가 일치하면 5등에 당첨된다.")
    @Test
    void 세개의_번호가_일치하면_5등에_당첨된다() {
        assertThat(Rank.valueOf(3, false)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.valueOf(3, true)).isEqualTo(Rank.FIFTH);
    }

    @DisplayName("2개 이하의 번호가 일치하면 낙첨이다.")
    @Test
    void 두개_이하의_번호가_일치하면_낙첨이다() {
        assertThat(Rank.valueOf(2, false)).isEqualTo(Rank.MISS);
        assertThat(Rank.valueOf(1, true)).isEqualTo(Rank.MISS);
        assertThat(Rank.valueOf(0, false)).isEqualTo(Rank.MISS);
    }
}
