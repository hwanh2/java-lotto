package lotto.service;

import lotto.model.Lotto;
import lotto.model.Lottos;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoService {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private HashMap<String,Integer> result;

    public LottoService(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Lottos createLottos(int money){
        int count = money/1000;
        return Lottos.from(count);
    }

    public Map<String,Integer> matchLotto(Lottos lottos){
        initResult(); // 등수별 초기값 세팅

        for(Lotto lotto : lottos.getLottos()){
            List<Integer> lottoNumbers = lotto.getNumbers(); // 로또 한 장
            int matchCount = getMatchCount(lottoNumbers);
            boolean bonusCount = lottoNumbers.contains(bonusNumber);

            checkLotto(matchCount,bonusCount);
        }
        return result;
    }

    private void initResult(){
        result = new LinkedHashMap<>();

        result.put("3개", 0);
        result.put("4개", 0);
        result.put("5개", 0);
        result.put("5개,보너스", 0);
        result.put("6개", 0);
    }

    private int getMatchCount(List<Integer> lottoNumbers){
        int count = 0;
        for(int number : lottoNumbers){
            if(winningNumbers.contains(number)){
                count++;
            }
        }
        return count;
    }

    private void checkLotto(int matchCount,boolean bonusCount){
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

}
