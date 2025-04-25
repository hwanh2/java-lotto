package lotto.model;

import lotto.generator.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos from(int num, NumberGenerator generator){
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            lottoList.add(new Lotto(generator));
        }
        return new Lottos(lottoList);
    }

    public List<Lotto> getLottos(){
        return lottos;
    }

}
