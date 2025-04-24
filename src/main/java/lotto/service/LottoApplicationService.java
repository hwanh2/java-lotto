package lotto.service;

import lotto.generator.NumberGenerator;
import lotto.model.LottoRank;
import lotto.model.Lottos;
import java.util.List;
import java.util.Map;

public class LottoApplicationService {

    public Lottos createLottos(int money, NumberGenerator generator){
        int count = money/1000;
        return Lottos.from(count, generator);
    }

    public Map<LottoRank, Integer> matchLotto(Lottos lottos, List<Integer> winningNumbers, int bonusNumber) {
        return LottoResultService.getResult(lottos, winningNumbers, bonusNumber);
    }


    public double checkProfitRate(int money, Map<LottoRank,Integer> result){
        return LottoProfitService.calculate(money, result);
    }

}
