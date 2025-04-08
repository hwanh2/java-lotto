package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputView {
    public int moneyInput(){
        System.out.println("구입금액을 입력해주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public List<Integer> winningInput() {
        System.out.println("당첨번호를 입력해주세요.");
        String input = Console.readLine();

        StringTokenizer tokenizer = new StringTokenizer(input, ",");
        List<Integer> numbers = new ArrayList<>();

        while (tokenizer.hasMoreTokens()) {
            numbers.add(Integer.parseInt(tokenizer.nextToken().trim()));
        }

        return numbers;
    }

    public int bonusInput(){
        System.out.println("보너스 번호를 입력해주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
