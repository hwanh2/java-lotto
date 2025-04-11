package lotto.model;

public enum LottoRank {
    THREE(3, 5_000, "3개 일치 (5,000원) - "),
    FOUR(4, 50_000, "4개 일치 (50,000원) - "),
    FIVE(5, 1_500_000, "5개 일치 (1,500,000원) - "),
    BONUS(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - "),
    NONE(0, 0, "");

    private final int matchCount;
    private final int prize;
    private final String message;

    LottoRank(int matchCount, int prize, String message) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.message = message;
    }

    public static LottoRank of(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) {
            return SIX;
        }
        if (matchCount == 5 && bonusMatch) {
            return BONUS;
        }
        if (matchCount == 5) {
            return FIVE;
        }
        if (matchCount == 4) {
            return FOUR;
        }
        if (matchCount == 3) {
            return THREE;
        }
        return NONE;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public String getMessage() {
        return message;
    }
}
