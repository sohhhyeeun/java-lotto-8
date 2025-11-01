package lotto;

import java.util.ArrayList;
import java.util.List;

public class InputValidator {
    public int validatePurchaseAmount(String amountString) {
        int amount = parseAmount(amountString);
        validatePositive(amount);
        validateDivisible(amount);

        return amount;
    }

    private int parseAmount(String amountString) {
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
        List<Integer> numbers = parseNumberList(numbersString);
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

    private List<Integer> parseNumberList(List<String> numbersString) {
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

    public int validateBonusNumber(String bonusNumberString, List<Integer> winningNumbers) {
        int bonusNumber = parseBonusNumber(bonusNumberString);
        validateBonusRange(bonusNumber);
        validateDuplicateWithWinningNumbers(bonusNumber, winningNumbers);

        return bonusNumber;
    }

    private int parseBonusNumber(String bonusNumberString) {
        try {
            return Integer.parseInt(bonusNumberString.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }

    private void validateBonusRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateDuplicateWithWinningNumbers(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
        }
    }
}
