package lotto.service;

import lotto.model.LottoRank;
import lotto.model.Lottos;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ServiceTest {
    @Test
    void 로또결과를_확인한다(){
        // given
        List<Integer> winningNumbers = Arrays.asList(1, 12, 23, 34, 38, 45);
        int bonusNumber = 7;

        LottoService service = new LottoService();

        // 랜덤으로 생성된 로또 5개
        Lottos lottos = service.createLottos(100000); // 100장

        // when
        Map<LottoRank, Integer> result = service.matchLotto(lottos,winningNumbers,bonusNumber);

        // then - 그냥 콘솔에 찍어보기
        System.out.println("로또 결과 출력");
        for (Map.Entry<LottoRank, Integer> entry : result.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        double rate = service.checkProfitRate(100000,result);
        System.out.println("수익률 : "+rate+"%");
    }

}
