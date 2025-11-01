package lotto;

import java.text.NumberFormat;

public enum Rank {
    FIRST(6, 2_000_000_000L, false, "6개 일치"),
    SECOND(5, 30_000_000L, true, "5개 일치, 보너스 볼 일치"),
    THIRD(5, 1_500_000L, false, "5개 일치"),
    FOURTH(4, 50_000L, false, "4개 일치"),
    FIFTH(3, 5_000L, false, "3개 일치"),
    MISS(0, 0L, false, "낙첨");

    private final int matchCount;
    private final long prizeMoney;
    private final boolean requiresBonus;
    private final String description;

    Rank(int matchCount, long prizeMoney, boolean requiresBonus, String description) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.requiresBonus = requiresBonus;
        this.description = description;
}

    public static Rank valueOf(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) {
            return FIRST;
        }
        if (matchCount == 5 && bonusMatch) {
            return SECOND;
        }
        if (matchCount == 5) {
            return THIRD;
        }
        if (matchCount == 4) {
            return FOURTH;
        }
        if (matchCount == 3) {
            return FIFTH;
        }

        return MISS;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public String getDescriptionAndMoney() {
        String money = NumberFormat.getInstance().format(prizeMoney);

        return description + " (" + money + "원)";
    }
}
