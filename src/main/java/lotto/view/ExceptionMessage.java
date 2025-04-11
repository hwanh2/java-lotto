package lotto.view;

public enum ExceptionMessage {
    NOT_NUMBER_RANGE("[ERROR] 숫자는 1부터 45 사이의 숫자여야 합니다."),
    NOT_NUMBER_SIZE("[ERROR] 당첨 번호는 6개 입력 가능합니다."),
    NOT_NUMBER_OVERLAP("[ERROR] 중복된 숫자를 입력하셨습니다."),
    INPUT_TYPE_ERROR("[ERROR] 숫자만 입력해 주세요."),
    NOT_NUMBER_ERROR("[ERROR] 금액은 숫자만 등록 가능합니다."),
    NOT_MINIMUM_AMOUNT_ERROR("[ERROR] 금액은 1000원 이상이어야 합니다."),
    NOT_DIVISIBLE_NUMBER_ERROR("[ERROR] 금액은 1000단위여야 합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public void print() {
        System.out.println(message);
    }

    public String getMessage() {
        return message;
    }
}
