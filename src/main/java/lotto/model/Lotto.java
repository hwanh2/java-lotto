package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.generator.NumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<LottoNumber> lotto;

    public Lotto(NumberGenerator generator) {
        List<Integer> tmpLotto = generator.generate();
        Collections.sort(tmpLotto); // 오름차순 정렬

        List<LottoNumber> lotto = new ArrayList<>();
        for (Integer number : tmpLotto) {
            lotto.add(new LottoNumber(number));
        }
        this.lotto = lotto;
    }

    public List<LottoNumber> getNumbers() {
        return lotto;
    }

    public int getMatchCount(List<Integer> winningNumbers){
        int count = 0;
        for (LottoNumber number : lotto) {
            if (winningNumbers.contains(number.getLottoNumber())) {
                count++;
            }
        }
        return count;
    }

    public boolean getBonusCount(int bonus) {
        for (LottoNumber number : lotto) {
            if (number.getLottoNumber() == bonus) {
                return true;
            }
        }
        return false;
    }

}
