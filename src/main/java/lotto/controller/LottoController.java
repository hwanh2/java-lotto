package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run(){
        int money = inputView.moneyInput(); // 돈 입력
        Lottos lottos = lottoService.createLottos(money); // 로또 생성
        List<Lotto> lottoList = lottos.getLottos(); // 생성한 로또 가져오기

        outputView.printLotto(money,lottoList); // 생성한 로또 출력

        List<Integer> winningnumbers = inputView.winningInput(); // 당첨번호 입력
        int bonusNumber = inputView.bonusInput(); // 보너스 번호 입력

        Map<String,Integer> result = lottoService.matchLotto(lottos,winningnumbers,bonusNumber);

        outputView.printResult(result);
    }
}
