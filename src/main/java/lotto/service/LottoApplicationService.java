package lotto.service;

import lotto.generator.NumberGenerator;
import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.LottoRank;
import lotto.model.Lottos;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoService {

    public Lottos createLottos(int money, NumberGenerator generator){
        int count = money/1000;
        return Lottos.from(count, generator);
    }

    public Map<LottoRank, Integer> matchLotto(Lottos lottos, List<Integer> winningNumbers, int bonusNumber) {
        Map<LottoRank, Integer> result = initResult();

        for (Lotto lotto : lottos.getLottos()) {
            int matchCount = lotto.getMatchCount(winningNumbers);
            boolean bonusCount = lotto.getBonusCount(bonusNumber);

            LottoRank rank = LottoRank.of(matchCount, bonusCount);
            if (rank != LottoRank.NONE) {
                result.put(rank, result.get(rank) + 1);
            }
        }
        return result;
    }

    private Map<LottoRank, Integer> initResult() {
        Map<LottoRank, Integer> result = new LinkedHashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.NONE) {
                result.put(rank, 0);
            }
        }
        return result;
    }


    public double checkProfitRate(int money, Map<LottoRank,Integer> result){
        long sum = 0;
        for (LottoRank rank : result.keySet()) {
            int count = result.get(rank); // 키 값으로 가져오기
            sum += (long) rank.getPrize() * count;
        }

        return Double.parseDouble(String.format("%.1f", (double)sum/money*100));
    }

}
