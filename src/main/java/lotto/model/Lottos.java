package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos from(int num){
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            lottoList.add(new Lotto());
        }
        return new Lottos(lottoList);
    }

    public List<Lotto> getLottos(){
        return lottos;
    }

}
