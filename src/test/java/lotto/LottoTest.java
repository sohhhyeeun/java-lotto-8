package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 45를 초과하면 예외가 발생한다.")
    @Test
    void 로또_번호가_45를_초과하면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1 미만이면 예외가 발생한다.")
    @Test
    void 로또_번호가_1_미만이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호는 오름차순으로 정렬한다.")
    @Test
    void 로또_번호는_오름차순으로_정렬한다() {
        List<Integer> numbers = List.of(3, 2, 1, 5, 4, 6);

        Lotto lotto = new Lotto(numbers);
        List<Integer> sortedNumbers = lotto.getNumbers();

        assertThat(sortedNumbers).containsExactly(1, 2, 3, 4, 5, 6);
    }
}
