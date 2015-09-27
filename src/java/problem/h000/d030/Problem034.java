package problem.h000.d030;

import problem.Problem;

import java.util.stream.LongStream;

/**
 * 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
 * <p>
 * Find the sum of all numbers which are equal to the sum of the factorial of their digits.
 * <p>
 * Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 */
public class Problem034 implements Problem {
    private static final long[] FACTORIAL = new long[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

    @Override
    public long solve() {
        long limitDigits = 10;
        long limit = (long) Math.pow(10, limitDigits);
        while (FACTORIAL[9] * limitDigits < limit / 10) {
            limitDigits--;
            limit /= 10;
        }

        return LongStream.rangeClosed(10, FACTORIAL[9] * limitDigits).parallel().filter(value -> {
            long sumOfFactorialsOfDigits = 0;
            long test = value;
            while (test > 0) {
                sumOfFactorialsOfDigits += FACTORIAL[(int) test % 10];
                test /= 10;
            }
            return sumOfFactorialsOfDigits == value;
        }).sum();
    }
}
