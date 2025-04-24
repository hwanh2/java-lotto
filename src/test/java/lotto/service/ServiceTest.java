package lotto.service;

import lotto.generator.FixNumberGenerator;
import lotto.model.LottoRank;
import lotto.model.Lottos;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;

public class ServiceTest {

    @Test
    void 로또_한장이_몇등인지_확인한다() {
        // given
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6); // 당첨 번호
        int bonusNumber = 7;

        FixNumberGenerator generator = new FixNumberGenerator(Arrays.asList(1, 2, 3, 4, 5, 7));
        LottoApplicationService service = new LottoApplicationService();

        Lottos lottos = service.createLottos(1000, generator);

        // when
        Map<LottoRank, Integer> result = service.matchLotto(lottos, winningNumbers, bonusNumber);

        // then
        assertThat(result.get(LottoRank.FIVE)).isEqualTo(1); // 5개 일치
    }
}