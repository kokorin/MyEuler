package problem.h000.d020;

import problem.Problem;
import util.Divisors;

import java.util.HashSet;
import java.util.Set;

/**
 * A perfect number is a number for which the sum of its proper divisors is exactly equal to the number.
 * For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28,
 * which means that 28 is a perfect number.
 * A number n is called deficient if the sum of its proper divisors is less than n
 * and it is called abundant if this sum exceeds n.
 * <p>
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written
 * as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers
 * greater than 28123 can be written as the sum of two abundant numbers. However, this upper limit
 * cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed
 * as the sum of two abundant numbers is less than this limit.
 * <p>
 * Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
 */

public class Problem023 implements Problem {
    private static final long LIMIT = 28123L;

    @Override
    public long solve() {
        Set<Long> abundants = new HashSet<>();

        for (long value = 1; value <= LIMIT; value++) {
            long summ = Divisors.getSumOfDivisors(value, true);
            if (summ > value) {
                abundants.add(value);
            }
        }

        long result = 0;
        for (long test = 1; test <= LIMIT; test++) {
            boolean isSumOfTwoAbdundants = false;
            for (long left : abundants) {
                long right = test - left;

                if (abundants.contains(right)) {
                    isSumOfTwoAbdundants = true;
                    break;
                }
            }

            if (!isSumOfTwoAbdundants) {
                result += test;
            }
        }

        return result;
    }
}
