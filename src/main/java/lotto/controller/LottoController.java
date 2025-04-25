package lotto.controller;

import lotto.generator.NumberGenerator;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.Lottos;
import lotto.service.LottoApplicationService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoApplicationService lottoService;
    private final NumberGenerator generator;

    public LottoController(InputView inputView, OutputView outputView, LottoApplicationService lottoService, NumberGenerator generator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
        this.generator = generator;
    }

    public void run(){
        int money = inputView.readMoneyInput(); // 돈 입력
        Lottos lottos = lottoService.createLottos(money,generator); // 로또 생성
        List<Lotto> lottoTickets = lottos.getLottos(); // 생성한 로또 가져오기

        outputView.printLotto(money,lottoTickets); // 생성한 로또 출력

        List<Integer> winningnumbers = inputView.readWinningNumbersInput(); // 당첨번호 입력
        int bonusNumber = inputView.readBonusInput(winningnumbers); // 보너스 번호 입력, 검증을 위해 당첨번호 넘겨줌

        Map<LottoRank,Integer> result = lottoService.matchLotto(lottos,winningnumbers,bonusNumber);

        outputView.printResult(result); // 결과 출력

        double profitRate = lottoService.checkProfitRate(money,result);

        outputView.printProfitRate(profitRate); // 수익률 출력
    }
}
