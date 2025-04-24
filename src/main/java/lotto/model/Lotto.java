package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.generator.NumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<LottoNumber> lotto;

    public Lotto(NumberGenerator generator) {
        List<Integer> tmpLotto = generator.generate();
        Collections.sort(tmpLotto); // 오름차순 정렬

        this.lotto = tmpLotto.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public List<LottoNumber> getNumbers() {
        return lotto;
    }

    public int getMatchCount(List<Integer> winningNumbers) {
        return (int) lotto.stream()
                .map(LottoNumber::getLottoNumber)
                .filter(winningNumbers::contains)
                .count();
    }


    public boolean getBonusCount(int bonus) {
        return lotto.stream()
                .map(LottoNumber::getLottoNumber)
                .anyMatch(number -> number == bonus);
    }

}
