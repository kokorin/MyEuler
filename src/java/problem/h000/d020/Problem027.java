package problem.h000.d020;

import problem.Problem;
import util.Primes;

/**
 * Euler discovered the remarkable quadratic formula:
 * <p>
 * n? + n + 41
 * <p>
 * It turns out that the formula will produce 40 primes for the consecutive values n = 0 to 39.
 * However, when n = 40, 402 + 40 + 41 = 40(40 + 1) + 41 is divisible by 41,
 * and certainly when n = 41, 41? + 41 + 41 is clearly divisible by 41.
 * <p>
 * The incredible formula  n? ? 79n + 1601 was discovered, which produces 80 primes for the consecutive
 * values n = 0 to 79. The product of the coefficients, ?79 and 1601, is ?126479.
 * <p>
 * Considering quadratics of the form:
 * <p>
 * n? + an + b, where |a| < 1000 and |b| < 1000
 * <p>
 * where |n| is the modulus/absolute value of n
 * e.g. |11| = 11 and |-4| = 4
 * <p>
 * Find the product of the coefficients, a and b, for the quadratic expression that produces the maximum number
 * of primes for consecutive values of n, starting with n = 0.
 */
public class Problem027 implements Problem {
    private static final long N = 1000;

    @Override
    public long solve() {
        long maxA = 0;
        long maxB = 0;
        long maxN = 0;

        for (long a = -N; a <= N; a++) {
            for (long b = -N; b <= N; b++) {
                long n = 0;
                while (Primes.isPrime(n * n + a * n + b)) {
                    n++;
                }

                if (n > maxN) {
                    maxN = n;
                    maxA = a;
                    maxB = b;
                }
            }
        }

        return maxA * maxB;
    }
}
