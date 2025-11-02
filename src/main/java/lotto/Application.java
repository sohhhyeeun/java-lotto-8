package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Map;

public class Application {
    private final InputValidator inputValidator;
    private final OutputView outputView;
    private final LottoIssuer lottoIssuer;
    private final WinningStatisticsAggregator winningStatisticsAggregator;
    private final RateCalculator rateCalculator;

    public Application() {
        this.inputValidator = new InputValidator();
        this.outputView = new OutputView();
        this.lottoIssuer = new LottoIssuer();
        this.winningStatisticsAggregator = new WinningStatisticsAggregator();
        this.rateCalculator = new RateCalculator();
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    public void run() {
        int purchaseAmount = getValidPurchaseAmount();
        List<Lotto> lottos = lottoIssuer.issueLottos(purchaseAmount);

        outputView.printQuantity(lottos.size());
        outputView.printLottos(lottos);

        List<Integer> winningNumbers = getValidWinningNumbers();
        int bonusNumber = getValidBonusNumber(winningNumbers);
        Map<Rank, Integer> statistics = winningStatisticsAggregator.aggregate(lottos, winningNumbers, bonusNumber);

        outputView.printStatisticsHeader();
        outputView.printWinningStatistics(statistics);

        double profitRate = rateCalculator.calculateRate(purchaseAmount, statistics);

        outputView.printProfitRate(profitRate);
    }

    private int getValidPurchaseAmount() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            String input = Console.readLine();

            try {
                return inputValidator.validatePurchaseAmount(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> getValidWinningNumbers() {
        while (true) {
            System.out.println("당첨 번호를 입력해 주세요.");
            String input = Console.readLine();

            try {
                return inputValidator.validateWinningNumbers(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getValidBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            System.out.println("보너스 번호를 입력해 주세요.");
            String input = Console.readLine();

            try {
                return inputValidator.validateBonusNumber(input, winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
