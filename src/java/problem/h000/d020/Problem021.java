package problem.h000.d020;

import problem.Problem;
import util.Divisors;

/**
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
 * If d(a) = b and d(b) = a, where a ? b, then a and b are an amicable pair
 * and each of a and b are called amicable numbers.
 * <p>
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110;
 * therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
 * <p>
 * Evaluate the sum of all the amicable numbers under 10000.
 */
public class Problem021 implements Problem {
    private static final long N = 10000;

    @Override
    public long solve() {
        long result = 0;
        for (long value = 2; value <= N; value++) {
            long pair = Divisors.getSumOfDivisors(value, true);

            if (pair != value && pair < N) {
                long pairOfPair = Divisors.getSumOfDivisors(pair, true);
                if (pairOfPair == value) {
                    result += value;
                }
            }
        }

        return result;
    }

}
