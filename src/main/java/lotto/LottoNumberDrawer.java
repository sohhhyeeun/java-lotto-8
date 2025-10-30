package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoNumberDrawer {
    public List<Integer> draw() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
