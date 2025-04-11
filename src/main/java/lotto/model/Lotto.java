package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> lotto;

    private static final Integer MIN_RANGE = 1;
    private static final Integer MAX_RANGE = 45;
    private static final Integer PICK_NUMBER = 6;

    public Lotto() {
        List<Integer> lotto = generateLottoNumbers();
        Collections.sort(lotto); // 오름차순 정렬
        this.lotto = lotto;
    }

    private List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, PICK_NUMBER);
    }

    public List<Integer> getNumbers() {
        return lotto;
    }

}
