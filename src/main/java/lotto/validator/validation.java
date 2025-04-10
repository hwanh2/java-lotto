package lotto.validator;

import lotto.view.ExceptionMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class validation {
    public static void validateMoneyInput(String input) {
        int money;
        try {
            money = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            ExceptionMessage.numberException();
            throw new IllegalArgumentException();
        }

        if(money<1000){
            ExceptionMessage.minimumException();
            throw new IllegalArgumentException();
        }

        if (money % 1000 != 0) {
            ExceptionMessage.divisibleException();
            throw new IllegalArgumentException();
        }
    }

    public static void validateWinningInput(List<Integer> winningNumbers){
        if(winningNumbers.size()!=6){
            ExceptionMessage.sizeException();
            throw new IllegalArgumentException();
        }

        Set<Integer> check = new HashSet<>();
        for(int number : winningNumbers){
            if(number<1 || number>45){
                ExceptionMessage.rangeException();
                throw new IllegalArgumentException();
            }
            if(check.contains(number)){
                ExceptionMessage.overlapException();
                throw new IllegalArgumentException();
            }
            check.add(number);
        }
    }

    public static void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers){
        if(bonusNumber<1 || bonusNumber>45){
            ExceptionMessage.rangeException();
            throw new IllegalArgumentException();
        }
        if(winningNumbers.contains(bonusNumber)){
            ExceptionMessage.overlapException();
            throw new IllegalArgumentException();
        }
    }
}
