package problem.h000.d050;

import problem.Problem;
import util.Numbers;

import java.math.BigInteger;

/**
 * A googol (10<sup>100</sup>) is a massive number: one followed by one-hundred zeros;
 * 100<sup>100</sup> is almost unimaginably large: one followed by two-hundred zeros.
 * Despite their size, the sum of the digits in each number is only 1.
 * <p>
 * Considering natural numbers of the form, a<sup>b</sup>, where a, b < 100, what is the maximum digital sum?
 */
public class Problem056 implements Problem {
    @Override
    public long solve() {
        long result = 0;

        for (int a = 1; a < 100; a++) {
            for (int b = 1; b < 100; b++) {
                BigInteger value = BigInteger.valueOf(a).pow(b);
                result = Math.max(result, Numbers.sumOfDigits(value));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Problem056().solve());
    }
}
