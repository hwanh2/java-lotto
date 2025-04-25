package lotto.service;

import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.Lottos;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoResultService {
    // 정적 메서드 사용
    public static Map<LottoRank, Integer> getResult(Lottos lottos, List<Integer> winningNumbers, int bonusNumber) {
        Map<LottoRank, Integer> result = initResult();

        for (Lotto lotto : lottos.getLottos()) {
            int matchCount = lotto.getMatchCount(winningNumbers);
            boolean bonusMatch = lotto.getBonusCount(bonusNumber);
            LottoRank rank = LottoRank.of(matchCount, bonusMatch);
            if (rank != LottoRank.NONE) {
                result.put(rank, result.get(rank) + 1);
            }
        }
        return result;
    }

    private static Map<LottoRank, Integer> initResult() {
        Map<LottoRank, Integer> result = new LinkedHashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.NONE) {
                result.put(rank, 0);
            }
        }
        return result;
    }
}
