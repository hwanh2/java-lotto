package lotto.model;

public class LottoNumber {
    public static final int MIN_LOTTO_NUM = 1;
    public static final int MAX_LOTTO_NUM = 45;
    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validate(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }

    private void validate(int lottoNumber){
        if (lottoNumber < MIN_LOTTO_NUM || lottoNumber > MAX_LOTTO_NUM) {
            throw new IllegalArgumentException("[ERROR] 로또에 사용되는 번호는 1~45 사이의 숫자만 가능합니다.");
        }
    }
}
