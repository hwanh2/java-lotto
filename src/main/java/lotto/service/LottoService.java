package lotto.service;

import lotto.model.Lotto;
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

    public Map<String, Integer> matchLotto(Lottos lottos, List<Integer> winningNumbers, int bonusNumber) {
        Map<String, Integer> result = initResult();

        for (Lotto lotto : lottos.getLottos()) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            int matchCount = getMatchCount(lottoNumbers, winningNumbers);
            boolean bonusCount = lottoNumbers.contains(bonusNumber);

            checkLotto(matchCount, bonusCount, result);
        }
        return result;
    }

    private Map<String, Integer> initResult() {
        Map<String, Integer> result = new LinkedHashMap<>();
        result.put("3개", 0);
        result.put("4개", 0);
        result.put("5개", 0);
        result.put("5개,보너스", 0);
        result.put("6개", 0);
        return result;
    }

    private int getMatchCount(List<Integer> lottoNumbers, List<Integer> winningNumbers){
        int count = 0;
        for(int number : lottoNumbers){
            if(winningNumbers.contains(number)){
                count++;
            }
        }
        return count;
    }

    private void checkLotto(int matchCount,boolean bonusCount,Map<String,Integer> result){
        if(matchCount==3){
            result.put("3개", result.get("3개") + 1);
        }
        else if(matchCount==4){
            result.put("4개", result.get("4개") + 1);
        }
        else if(matchCount==5 && bonusCount){
            result.put("5개,보너스", result.get("5개,보너스") + 1);
        }
        else if(matchCount==5){
            result.put("5개", result.get("5개") + 1);
        }
        else if(matchCount==6){
            result.put("6개", result.get("6개") + 1);
        }
    }

    public double checkProfitRate(int money,Map<String,Integer> result){
        long sum = 0;
        sum += result.get("3개")*5000;
        sum += result.get("4개")*50000;
        sum += result.get("5개")*1500000;
        sum += result.get("5개,보너스")*30000000;
        sum += result.get("6개")*2000000000;

        return Double.parseDouble(String.format("%.1f",(double)sum/money*100));
    }

}
