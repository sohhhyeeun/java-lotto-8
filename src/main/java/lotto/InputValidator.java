package lotto;

public class InputValidator {
    public int validatePurchaseAmount(String amountString) {
        int amount = parseNumeric(amountString);
        validatePositive(amount);
        validateDivisible(amount);

        return amount;
    }

    private int parseNumeric(String amountString) {
        try {
            return Integer.parseInt(amountString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
    }

    private void validatePositive(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 0보다 커야 합니다.");
        }
    }

    private void validateDivisible(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(
                    "[ERROR] 구입 금액은 1,000원 단위여야 합니다."
            );
        }
    }
}
