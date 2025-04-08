package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    void 로또는_6개의_번호를_가진다() {
        Lotto lotto = new Lotto();
        List<Integer> numbers = lotto.getNumbers();

        assertThat(numbers.size()).isEqualTo(6);
    }

    @Test
    void 로또_번호는_중복되지_않는다() {
        Lotto lotto = new Lotto();
        List<Integer> numbers = lotto.getNumbers();

        HashSet<Integer> unique = new HashSet<>(numbers);
        assertThat(unique.size()).isEqualTo(6);
    }

    @Test
    void 로또_번호는_오름차순으로_정렬되어_있다() {
        Lotto lotto = new Lotto();
        List<Integer> numbers = lotto.getNumbers();

        List<Integer> copied = new ArrayList<>(numbers);
        Collections.sort(copied);

        assertThat(numbers).isEqualTo(copied);
    }
}
