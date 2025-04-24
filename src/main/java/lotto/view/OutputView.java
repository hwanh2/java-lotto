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
            if (rank == LottoRank.NONE) continue;

            String message = buildMessage(rank, result.get(rank));
            System.out.println(message);
        }
    }

    private String buildMessage(LottoRank rank, int count) {
        if (rank == LottoRank.BONUS) {
            return String.format("5개 일치, 보너스 볼 일치 (%s원) - %d개", formatMoney(rank.getPrize()), count);
        }
        return String.format("%d개 일치 (%s원) - %d개", rank.getMatchCount(), formatMoney(rank.getPrize()), count);
    }

    private String formatMoney(int prize) {
        return String.format("%,d", prize);
    }


    public void printProfitRate(double profitRate){
        System.out.println("총 수익률은 "+profitRate+"%입니다.");
    }
}
