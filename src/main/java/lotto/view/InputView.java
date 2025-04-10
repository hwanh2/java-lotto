package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputView {
    public int moneyInput(){
        while (true) {
            System.out.println("구입금액을 입력해주세요.");
            String input = Console.readLine();

            try {
                validation.validateMoneyInput(input); // 입력받은 금액 검증
                return Integer.parseInt(input); // 검증 성공 시 숫자로 변환해서 반환
            } catch (IllegalArgumentException e) {
                // 예외 메시지는 validation 클래스에서 이미 출력했으니 여기선 무시하고 반복
            }
        }
    }

    public List<Integer> winningInput() {
        while(true){
            System.out.println("\n당첨번호를 입력해주세요.");
            String input = Console.readLine();

            try{
                List<Integer> winningNumbers = parseInput(input);
                validation.validateWinningInput(winningNumbers); // 당점번호 검증
                return winningNumbers;
            } catch (IllegalArgumentException e){

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

    public int bonusInput(List<Integer> winningNumbers){
        while(true){
            System.out.println("\n보너스 번호를 입력해주세요.");
            String input = Console.readLine();

            try {
                int bonusNumber = Integer.parseInt(input); // 숫자인지 확인
                validation.validateBonusNumber(bonusNumber, winningNumbers); // 범위와 중복 검증
                return bonusNumber;
            } catch (NumberFormatException e) {
                ExceptionMessage.numberException(); // 숫자가 아닐 경우
            } catch (IllegalArgumentException e) {

            }
        }
    }
}
