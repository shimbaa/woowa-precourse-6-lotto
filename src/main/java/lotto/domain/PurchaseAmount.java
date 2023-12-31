package lotto.domain;

public class PurchaseAmount {
    private static final int LOTTO_PRICE = 1000;
    private static final int PERCENTAGE = 100;
    private static final String NOT_DIVIDABLE_WITH_LOTTO_PRICE = "[ERROR] 구입 금액은 1,000원 단위로 입력해주세요.\n";
    private final int purchaseAmount;

    public static PurchaseAmount from(int purchaseAmount) {
        return new PurchaseAmount(purchaseAmount);
    }

    public int getAmountOfPurchasedLotto() {
        return purchaseAmount / LOTTO_PRICE;
    }

    public double getTotalReturn(int totalPrize) {
        return ((double) totalPrize / purchaseAmount) * PERCENTAGE;
    }

    private PurchaseAmount(int purchaseAmount) {
        validateIsDividableWithLottoPrice(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validateIsDividableWithLottoPrice(int purchaseAmount) {
        if (!isDividableWithLottoPrice(purchaseAmount)) {
            throw new IllegalArgumentException(NOT_DIVIDABLE_WITH_LOTTO_PRICE);
        }
    }

    private boolean isDividableWithLottoPrice(int purchaseAmount) {
        return purchaseAmount % LOTTO_PRICE == 0;
    }
}