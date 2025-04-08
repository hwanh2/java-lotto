package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @Test
    void 지정한_개수의_Lotto_객체를_생성한다() {
        // given
        int count = 8;

        // when
        Lottos lottos = Lottos.from(count);
        List<Lotto> lottoList = lottos.getLottos();
        for (int i = 0; i < lottoList.size(); i++) {
            System.out.println("로또 " + (i + 1) + "번: " + lottoList.get(i).getNumbers());
        }

        // then
        assertThat(lottoList).hasSize(count);
    }
}
