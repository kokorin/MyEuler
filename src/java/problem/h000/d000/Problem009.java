package problem.h000.d000;

import problem.Problem;

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * a<sup>2</sup> + b<sup>2</sup> = c<sup>2</sup>
 * <p>
 * For example, 3<sup>2</sup> + 4<sup>2</sup> = 9 + 16 = 25 = 5<sup>2</sup>.
 * <p>
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * <p>
 * Find the product abc.
 */
public class Problem009 implements Problem {
    private static long PERIMETER = 1000;

    @Override
    public long solve() {
        long result = 0;

        seearch:
        for (long c = PERIMETER / 2; c > 0; c--) {
            for (long b = PERIMETER - c - 1; b > (PERIMETER - c) / 2; b--) {
                long a = PERIMETER - c - b;
                if ((a * a + b * b) == c * c) {
                    result = a * b * c;
                    break seearch;
                }
            }
        }

        return result;
    }
}
