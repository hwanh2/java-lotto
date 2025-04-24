package lotto.model;

public class LottoNumber {
    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }
}
