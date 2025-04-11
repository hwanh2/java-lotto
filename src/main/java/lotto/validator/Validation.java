package lotto.validator;

import lotto.view.ExceptionMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {
    public static void validateMoneyInput(String input) {
        int money;
        try {
            money = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NUMBER_ERROR.getMessage());
        }

        if(money<1000){
            throw new IllegalArgumentException(ExceptionMessage.NOT_MINIMUM_AMOUNT_ERROR.getMessage());
        }

        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_DIVISIBLE_NUMBER_ERROR.getMessage());
        }
    }

    public static void validateWinningInput(List<Integer> winningNumbers){
        if(winningNumbers.size()!=6){
            throw new IllegalArgumentException(ExceptionMessage.NOT_NUMBER_SIZE.getMessage());
        }

        Set<Integer> check = new HashSet<>();
        for(int number : winningNumbers){
            if(number<1 || number>45){
                throw new IllegalArgumentException(ExceptionMessage.NOT_NUMBER_RANGE.getMessage());
            }
            if(check.contains(number)){
                throw new IllegalArgumentException(ExceptionMessage.NOT_NUMBER_OVERLAP.getMessage());
            }
            check.add(number);
        }
    }

    public static void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers){
        if(bonusNumber<1 || bonusNumber>45){
            throw new IllegalArgumentException(ExceptionMessage.NOT_NUMBER_RANGE.getMessage());
        }
        if(winningNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException(ExceptionMessage.NOT_NUMBER_OVERLAP.getMessage());
        }
    }
}
