package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoRank;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void printLotto(int money, List<Lotto> lottos){
        System.out.println("\n"+money/1000+"개를 구매했습니다.");
        for (int i = 0; i < lottos.size(); i++) {
            System.out.println(lottos.get(i).getNumbers());
        }
    }

    public void printResult(Map<LottoRank, Integer> result) {
        System.out.println("\n당첨 통계");
        System.out.println("---");

        for (LottoRank rank : LottoRank.values()) {
            if (rank == LottoRank.NONE) continue; // NONE은 출력 안 함
            System.out.println(rank.getMessage() + result.get(rank) + "개");
        }
    }

    public void printProfitRate(double profitRate){
        System.out.println("총 수익률은 "+profitRate+"%입니다.");
    }
}
