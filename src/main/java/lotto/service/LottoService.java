package lotto.service;

import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.LottoRank;
import lotto.model.Lottos;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoService {

    public Lottos createLottos(int money){
        int count = money/1000;
        return Lottos.from(count);
    }

    public Map<LottoRank, Integer> matchLotto(Lottos lottos, List<Integer> winningNumbers, int bonusNumber) {
        Map<LottoRank, Integer> result = initResult();

        for (Lotto lotto : lottos.getLottos()) {
            List<LottoNumber> lottoNumbers = lotto.getNumbers();
            int matchCount = getMatchCount(lottoNumbers, winningNumbers);
            boolean bonusMatch = lottoNumbers.contains(bonusNumber);

            LottoRank rank = LottoRank.of(matchCount, bonusMatch);
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

    private int getMatchCount(List<LottoNumber> lottoNumbers, List<Integer> winningNumbers){
        int count = 0;
        for(LottoNumber number : lottoNumbers){
            if(winningNumbers.contains(number.getLottoNumber())){
                count++;
            }
        }
        return count;
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
