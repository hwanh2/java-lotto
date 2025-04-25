package lotto.model;

import lotto.generator.NumberGenerator;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private final List<LottoNumber> lotto;

    public Lotto(NumberGenerator generator) {
        List<Integer> tmpLotto = generator.generate();
        validate(tmpLotto);
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

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복을 허용하지 않습니다.");
        }
    }

}
