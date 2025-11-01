package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
