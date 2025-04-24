package lotto.service;

import lotto.model.LottoRank;

import java.util.Map;

public class LottoProfitService {
    // 정적 메서드 사용
    public static double calculate(int money, Map<LottoRank, Integer> result) {
        long sum = 0;
        for (LottoRank rank : result.keySet()) {
            sum += (long) rank.getPrize() * result.get(rank);
        }
        return Double.parseDouble(String.format("%.1f", (double)sum / money * 100));
    }
}
