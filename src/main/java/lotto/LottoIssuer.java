package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoIssuer {
    private final LottoNumberDrawer lottoNumberDrawer;

    public LottoIssuer() {
        this.lottoNumberDrawer = new LottoNumberDrawer();
    }

    public List<Lotto> issueLottos(int amount) {
        int quantity = calculateQuantity(amount);
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            lottos.add(issueNewLotto());
        }

        return lottos;
    }

    private int calculateQuantity(int amount) {
        return amount / 1000;
    }

    private Lotto issueNewLotto() {
        List<Integer> numbers = lottoNumberDrawer.draw();

        return new Lotto(numbers);
    }
}
