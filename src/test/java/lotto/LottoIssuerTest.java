package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoIssuerTest {
    @DisplayName("구입 금액에 해당하는 만큼 로또를 발행한다.")
    @Test
    void 구입_금액에_해당하는_만큼_로또를_발행한다() {
        LottoIssuer lottoIssuer = new LottoIssuer();

        List<Lotto> lottos = lottoIssuer.issueLottos(14000);

        assertThat(lottos).hasSize(14);
    }
}
