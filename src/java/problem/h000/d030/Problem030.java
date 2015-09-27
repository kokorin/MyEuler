package problem.h000.d030;

import problem.Problem;

/**
 * Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:
 * <p>
 * 1634 = 1<sup>4</sup> + 6<sup>4</sup> + 3<sup>4</sup> + 4<sup>4</sup><br/>
 * 8208 = 8<sup>4</sup> + 2<sup>4</sup> + 0<sup>4</sup> + 8<sup>4</sup><br/>
 * 9474 = 9<sup>4</sup> + 4<sup>4</sup> + 7<sup>4</sup> + 4<sup>4</sup><br/>
 * <p>
 * As 1 = 14 is not a sum it is not included.
 * <p>
 * The sum of these numbers is 1634 + 8208 + 9474 = 19316.
 * <p>
 * Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
 */
public class Problem030 implements Problem {
    private static final int POWER = 5;

    @Override
    public long solve() {
        long[] powers = new long[10];
        for (int i = 0; i < 10; i++) {
            powers[i] = (long) Math.pow(i, POWER);
        }

        long limit = (long) Math.pow(10, POWER + 1) - 1;

        long result = 0;

        for (long value = 2; value <= limit; value++) {
            long test = value;
            long sumOfPowers = 0;
            while (test != 0) {
                sumOfPowers += powers[(int) test % 10];
                test /= 10;
            }
            if (sumOfPowers == value) {
                result += value;
            }
        }

        return result;
    }
}
