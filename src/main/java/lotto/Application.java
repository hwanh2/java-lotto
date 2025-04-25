package lotto;

import lotto.controller.LottoController;
import lotto.generator.NumberGenerator;
import lotto.generator.RandomNumberGenerator;
import lotto.service.LottoApplicationService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        LottoApplicationService lottoService = new LottoApplicationService();
        NumberGenerator generator = new RandomNumberGenerator();

        LottoController lottoController = new LottoController(inputView, outputView, lottoService, generator);
        lottoController.run();
    }
}
