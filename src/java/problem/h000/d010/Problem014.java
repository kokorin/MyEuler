package problem.h000.d010;

import problem.Problem;

import java.util.stream.LongStream;

/**
 * The following iterative sequence is defined for the set of positive integers:
 * <p>
 * n ? n/2 (n is even)
 * n ? 3n + 1 (n is odd)
 * <p>
 * Using the rule above and starting with 13, we generate the following sequence:
 * 13 ? 40 ? 20 ? 10 ? 5 ? 16 ? 8 ? 4 ? 2 ? 1
 * <p>
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
 * Although it has not been proved yet (Collatz Problem),
 * it is thought that all starting numbers finish at 1.
 * <p>
 * Which starting number, under one million, produces the longest chain?
 * <p>
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 */
public class Problem014 implements Problem {
    private static final long LIMIT = 1_000_000L;

    @Override
    public long solve() {
        CollatzLength result = LongStream.range(1, LIMIT).parallel().mapToObj(value -> {
            long count = 1;
            long test = value;
            while (test != 1) {
                if (test % 2 == 0) {
                    test = test / 2;
                } else {
                    test = 3 * test + 1;
                }
                count++;
            }
            return new CollatzLength(value, count);
        }).reduce((left, right) -> left.length > right.length ? left : right).get();

        return result.term;
    }

    private static class CollatzLength {
        public final long term;
        public final long length;

        public CollatzLength(long term, long length) {
            this.term = term;
            this.length = length;
        }

        @Override
        public String toString() {
            return "term=" + term + ", length=" + length;
        }
    }
}
