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
}
