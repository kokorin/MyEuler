package problem.h000.d050;

import problem.Problem;
import util.Numbers;

import java.math.BigInteger;

/**
 * There are exactly ten ways of selecting three from five, 12345:
 * <p>
 * 123, 124, 125, 134, 135, 145, 234, 235, 245, and 345
 * <p>
 * In combinatorics, we use the notation, <sup>5</sup>C<sub>3</sub> = 10.
 * <p>
 * In general,
 * <p>
 * <sup>n</sup>C<sub>r</sub> = n! / ( r! * (n−r)! )
 * <p>
 * ,where r ≤ n, n! = n×(n−1)×...×3×2×1, and 0! = 1.
 * It is not until n = 23, that a value exceeds one-million: <sup>23</sup>C<sub>10</sub> = 1144066.
 * <p>
 * How many, not necessarily distinct, values of  <sup>n</sup>C<sub>r</sub>, for 1 ≤ n ≤ 100, are greater than one-million?
 */
public class Problem053 implements Problem {
    private static final BigInteger ONE_MILLION = BigInteger.TEN.pow(6);

    @Override
    public long solve() {
        long result = 0;

        for (long n = 23; n <= 100; n++) {
            //to maximize C we must minimize denominator. So r = n / 2
            for (long r = 0; r <= n; r++) {
                BigInteger nominator = Numbers.factorial(n);
                BigInteger denominator = Numbers.factorial(r).multiply(Numbers.factorial(n - r));
                if (nominator.compareTo(ONE_MILLION.multiply(denominator)) > 0) {
                    result++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Problem053().solve());
    }
}
