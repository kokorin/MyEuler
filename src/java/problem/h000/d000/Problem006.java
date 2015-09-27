package problem.h000.d000;

import problem.Problem;

import java.util.stream.LongStream;

/**
 * The sum of the squares of the first ten natural numbers is,
 * 1<sup>2</sup> + 2<sup>2</sup> + ... + 10<sup>2</sup> = 385
 * The square of the sum of the first ten natural numbers is,
 * (1 + 2 + ... + 10)<sup>2</sup> = 55<sup>2</sup> = 3025
 * <p>
 * Hence the difference between the sum of the squares of the first ten natural numbers
 * and the square of the sum is 3025 ? 385 = 2640.
 * <p>
 * Find the difference between the sum of the squares of the first one hundred natural numbers
 * and the square of the sum.
 */
public class Problem006 implements Problem {
    private static final long N = 100;

    @Override
    public long solve() {
        long summOfSquares = LongStream.rangeClosed(1, N).
                map(num -> num * num).
                sum();
        long summ = (1 + N) * N / 2;
        long squareOfSum = summ * summ;

        return squareOfSum - summOfSquares;
    }
}
