package problem.h000.d000;

import problem.Problem;
import util.Divisors;

import java.util.HashMap;
import java.util.Map;

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * <p>
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
public class Problem005 implements Problem {
    private static final long N = 20;

    @Override
    public long solve() {
        Map<Long, Long> powers = new HashMap<>();

        for (long num = 1; num <= N; num++) {
            for (Divisors.PrimeDivisor divisor : Divisors.getPrimeDivisors(num)) {
                Long power = powers.get(divisor.prime);
                if (power == null || power < divisor.power) {
                    powers.put(divisor.prime, divisor.power);
                }
            }
        }

        long result = 1;
        for (Long prime : powers.keySet()) {
            for (long power = powers.get(prime); power > 0; power--) {
                result *= prime;
            }
        }
        return result;
    }
}
