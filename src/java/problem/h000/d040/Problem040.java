package problem.h000.d040;

import problem.Problem;
import util.Numbers;

/**
 * An irrational decimal fraction is created by concatenating the positive integers:
 * <p>
 * 0.123456789101112131415161718192021...
 * <p>
 * It can be seen that the 12th digit of the fractional part is 1.
 * <p>
 * If dn represents the nth digit of the fractional part, find the value of the following expression.
 * <p>
 * d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000
 */
public class Problem040 implements Problem {
    private static final long[] TEST = new long[]{1, 10, 100, 1_000, 10_000, 100_000, 1_000_000};
    //private static final long[] TEST = new long[]{10};

    public static void main(String[] args) {
        System.out.println(new Problem040().solve());
    }

    @Override
    public long solve() {
        long result = 1;
        for (long position : TEST) {
            result *= getDigitAt(position);
        }
        return result;
    }

    private static long getDigitAt(final long position) {
        for (long value = 1, currentPosition = 0; ; value++) {
            long valueDigits = Numbers.numOfDigits(value);

            if ((currentPosition + valueDigits) < position) {
                currentPosition += valueDigits;
                continue;
            }

            return Numbers.getDigitAt(value, position - currentPosition - 1);
        }
    }
}
