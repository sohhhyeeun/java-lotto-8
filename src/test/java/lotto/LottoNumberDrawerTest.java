package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberDrawerTest {
    @DisplayName("1~45의 숫자 범위에서 중복되지 않는 6개의 숫자를 뽑는다.")
    @Test
    void draw() {
        LottoNumberDrawer lottoNumberDrawer = new LottoNumberDrawer();

        List<Integer> numbers = lottoNumberDrawer.draw();

        assertThat(numbers)
                .hasSize(6)
                .doesNotHaveDuplicates()
                .allSatisfy(number -> {
                    assertThat(number).isBetween(1, 45);
                });
    }
}