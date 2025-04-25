package lotto.model;

import java.util.Arrays;

public enum LottoRank {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    BONUS(5, 30_000_000),
    SIX(6, 2_000_000_000),
    NONE(0, 0);

    private final int matchCount;
    private final int prize;

    LottoRank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static LottoRank of(int matchCount, boolean bonusMatch) {
        if (matchCount == 5 && bonusMatch) {
            return BONUS;
        }

        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount && rank != BONUS)
                .findFirst()
                .orElse(NONE);
    }


    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }
}
