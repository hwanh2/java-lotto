package lotto.validator;

import lotto.view.ExceptionMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    public static void validateMoneyInput(String input) {
        int money;
        try {
            money = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NUMBER_ERROR.getMessage());
        }

        if(money<LOTTO_PRICE){
            throw new IllegalArgumentException(ExceptionMessage.NOT_MINIMUM_AMOUNT_ERROR.getMessage());
        }

        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_DIVISIBLE_NUMBER_ERROR.getMessage());
        }
    }

    public static void validateWinningInput(List<Integer> winningNumbers){
        if(winningNumbers.size()!=LOTTO_NUMBER_COUNT){
            throw new IllegalArgumentException(ExceptionMessage.NOT_NUMBER_SIZE.getMessage());
        }

        Set<Integer> check = new HashSet<>();
        for(int number : winningNumbers){
            if(number<LOTTO_MIN_NUMBER || number>LOTTO_MAX_NUMBER){
                throw new IllegalArgumentException(ExceptionMessage.NOT_NUMBER_RANGE.getMessage());
            }
            if(check.contains(number)){
                throw new IllegalArgumentException(ExceptionMessage.NOT_NUMBER_OVERLAP.getMessage());
            }
            check.add(number);
        }
    }

    public static void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers){
        if(bonusNumber<LOTTO_MIN_NUMBER || bonusNumber>LOTTO_MAX_NUMBER){
            throw new IllegalArgumentException(ExceptionMessage.NOT_NUMBER_RANGE.getMessage());
        }
        if(winningNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException(ExceptionMessage.NOT_NUMBER_OVERLAP.getMessage());
        }
    }
}
