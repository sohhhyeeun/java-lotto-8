package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {
    private final InputValidator inputValidator = new InputValidator();

    @DisplayName("구입 금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void 구입_금액이_숫자가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> inputValidator.validatePurchaseAmount("abcdef"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 0 이하면 예외가 발생한다.")
    @Test
    void 구입_금액이_0_이하면_예외가_발생한다() {
        assertThatThrownBy(() -> inputValidator.validatePurchaseAmount("-1000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1,000원 단위가 아니면 예외가 발생한다.")
    @Test
    void 구입_금액이_1000원_단위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> inputValidator.validatePurchaseAmount("1400"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 숫자가 아니면 예외가 발생한다.")
    @Test
    void 당첨_번호가_숫자가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> inputValidator.validateWinningNumbers("1,2,3,4,5,a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 빈 값이 있으면 예외가 발생한다.")
    @Test
    void 당첨_번호에_빈_값이_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> inputValidator.validateWinningNumbers("1,2,3,,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 개수가 6개가 아니면 예외가 발생한다.")
    @Test
    void 당첨_번호의_개수가_6개가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> inputValidator.validateWinningNumbers("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 당첨_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> inputValidator.validateWinningNumbers("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 숫자가 아니면 예외가 발생한다.")
    @Test
    void 보너스_번호가_숫자가_아니면_예외가_발생한다() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> inputValidator.validateBonusNumber("a", winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 45를 초과하면 예외가 발생한다.")
    @Test
    void 보너스_번호가_45를_초과하면_예외가_발생한다() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> inputValidator.validateBonusNumber("46", winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1 미만이면 예외가 발생한다.")
    @Test
    void 보너스_번호가_1_미만이면_예외가_발생한다() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> inputValidator.validateBonusNumber("0", winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void 보너스_번호가_당첨_번호와_중복되면_예외가_발생한다() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> inputValidator.validateBonusNumber("6", winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
