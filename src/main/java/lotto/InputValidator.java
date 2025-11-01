package lotto;

import java.util.ArrayList;
import java.util.List;

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

    public List<Integer> validateWinningNumbers(String winningNumbersString) {
        List<String> numbersString = splitByComma(winningNumbersString);

        List<Integer> numbers = parseNumericList(numbersString);

        Lotto winningLotto = new Lotto(numbers);

        return winningLotto.getNumbers();
    }

    private List<String> splitByComma(String winningNumbersString) {
        if (winningNumbersString == null || winningNumbersString.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호가 입력되어야 합니다.");
        }

        String[] parts = winningNumbersString.split(",");
        List<String> result = new ArrayList<>();

        for (String part : parts) {
            String trimmedPart = part.trim();

            if (trimmedPart.isEmpty()) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호에 빈 값이 없어야 합니다.");
            }

            result.add(trimmedPart);
        }

        return result;
    }

    private List<Integer> parseNumericList(List<String> numbersString) {
        List<Integer> numbers = new ArrayList<>();

        try {
            for (String s : numbersString) {
                numbers.add(Integer.parseInt(s));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자만 입력되어야 합니다.");
        }

        return numbers;
    }
}
