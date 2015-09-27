package problem.h000.d020;

import problem.Problem;
import util.Numbers;

import java.math.BigInteger;

/**
 * n! means n ? (n ? 1) ? ... ? 3 ? 2 ? 1
 * <p>
 * For example, 10! = 10 ? 9 ? ... ? 3 ? 2 ? 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 * <p>
 * Find the sum of the digits in the number 100!
 */
public class Problem020 implements Problem {
    private static final long N = 100;

    @Override
    public long solve() {
        BigInteger value = Numbers.factorial(N);
        long result = Numbers.sumOfDigits(value);
        return result;
    }
}
