package lotto.view;

import lotto.model.Lotto;

import java.util.List;
import java.util.Map;

public class outputView {
    public void printLotto(int money, List<Lotto> lottos){
        System.out.println(money/1000+"개를 입력했습니다.");
        for (int i = 0; i < lottos.size(); i++) {
            System.out.println(lottos.get(i).getNumbers());
        }
    }

    public void printResult(Map<String, Integer> result){
        System.out.println("\n당첨 통계");
        System.out.println("---");

        System.out.println("3개 일치 (5,000원) - " + result.get("3개") + "개");
        System.out.println("4개 일치 (50,000원) - " + result.get("4개") + "개");
        System.out.println("5개 일치 (1,500,000원) - " + result.get("5개") + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.get("5개,보너스") + "개");
        System.out.println("6개 일치 (200,000,000원) - " + result.get("6개") + "개");
    }

    public void printProfitRate(double profitRate){
        System.out.println("총 수익률은 "+profitRate+"입니다.");
    }
}
