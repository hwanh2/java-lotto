package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.Validation;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputView {
    public int readMoneyInput(){
        while (true) {
            System.out.println("구입금액을 입력해주세요.");
            String input = Console.readLine();

            try {
                Validation.validateMoneyInput(input); // 입력받은 금액 검증
                return Integer.parseInt(input); // 검증 성공 시 숫자로 변환해서 반환
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> readWinningNumbersInput() {
        while(true){
            System.out.println("\n당첨번호를 입력해주세요.");
            String input = Console.readLine();

            try{
                List<Integer> winningNumbers = parseInput(input);
                Validation.validateWinningInput(winningNumbers); // 당점번호 검증
                return winningNumbers;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> parseInput(String input){
        StringTokenizer tokenizer = new StringTokenizer(input, ",");
        List<Integer> numbers = new ArrayList<>();

        while (tokenizer.hasMoreTokens()) {
            numbers.add(Integer.parseInt(tokenizer.nextToken().trim()));
        }

        return numbers;
    }

    public int readBonusInput(List<Integer> winningNumbers){
        while(true){
            System.out.println("\n보너스 번호를 입력해주세요.");
            String input = Console.readLine();

            try {
                int bonusNumber = Integer.parseInt(input); // 숫자인지 확인
                Validation.validateBonusNumber(bonusNumber, winningNumbers); // 범위와 중복 검증
                return bonusNumber;
            } catch (NumberFormatException e) {
                System.out.println(ExceptionMessage.INPUT_TYPE_ERROR.getMessage()); // 숫자가 아닐 경우
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
