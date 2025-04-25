package lotto.model;

import lotto.generator.NumberGenerator;
import lotto.generator.RandomNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

public class LottoTest {

    NumberGenerator generator;

    @BeforeEach
    void setUp() {
        generator = new RandomNumberGenerator();
    }

    @Test
    void 로또는_6개의_번호를_가진다() {
        Lotto lotto = new Lotto(generator);
        List<LottoNumber> numbers = lotto.getNumbers();

        assertThat(numbers.size()).isEqualTo(6);
    }

    @Test
    void 로또_번호는_중복되지_않는다() {
        Lotto lotto = new Lotto(generator);
        List<LottoNumber> numbers = lotto.getNumbers();

        // LottoNumber를 int 로 변환
        List<Integer> intValues = new ArrayList<>();
        for (LottoNumber number : numbers) {
            intValues.add(number.getLottoNumber());
        }

        HashSet<Integer> unique = new HashSet<>(intValues);
        assertThat(unique.size()).isEqualTo(6);
    }

    @Test
    void 로또_번호는_오름차순으로_정렬되어_있다() {
        Lotto lotto = new Lotto(generator);
        List<LottoNumber> numbers = lotto.getNumbers();

        // LottoNumber를 Integer 변환
        List<Integer> intValues = new ArrayList<>();
        for (LottoNumber number : numbers) {
            intValues.add(number.getLottoNumber());
        }

        // 복사 후 정렬
        List<Integer> sorted = new ArrayList<>(intValues);
        Collections.sort(sorted);

        // Integer 리스트끼리 비교
        assertThat(intValues).isEqualTo(sorted);
    }

}
