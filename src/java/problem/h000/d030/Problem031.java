package problem.h000.d030;

import problem.Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:
 * <p>
 * 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
 * <p>
 * It is possible to make £2 in the following way:
 * <p>
 * 1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
 * <p>
 * How many different ways can £2 be made using any number of coins?
 */
public class Problem031 implements Problem {
    private static final int AMOUNT = 200;
    private static final int[] COINS = new int[]{1, 2, 5, 10, 20, 50, 100, 200};

    @Override
    public long solve() {
        List<int[]> result = distributeByCoins(AMOUNT);
        return result.size();
    }

    private static List<int[]> distributeByCoins(int amount) {
        return distributeByCoins(amount, new int[COINS.length], COINS.length - 1);
    }

    private static List<int[]> distributeByCoins(int amount, int[] wallet, int index) {
        List<int[]> result = new ArrayList<>();

        for (int i = index; i >= 0; i--) {
            for (int quantity = amount / COINS[i]; quantity >= 1; quantity--) {
                int[] nextWallet = Arrays.copyOf(wallet, wallet.length);
                nextWallet[i] = quantity;
                int amountLeft = amount - quantity * COINS[i];

                if (amountLeft == 0) {
                    result.add(nextWallet);
                } else if (i > 0) {
                    List<int[]> distributions = distributeByCoins(amountLeft, nextWallet, i - 1);
                    result.addAll(distributions);
                }
            }
        }

        return result;
    }
}
