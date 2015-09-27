package problem.h000.d000;

import problem.Problem;

import java.util.stream.LongStream;

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5,
 * we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * <p>
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
public class Problem001 implements Problem {
    @Override
    public long solve() {
        return LongStream.range(1, 1000).
                filter(value -> value % 3 == 0 || value % 5 == 0).
                sum();
    }
}
