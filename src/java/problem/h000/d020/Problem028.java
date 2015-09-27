package problem.h000.d020;

import problem.Problem;

/**
 * Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:
 * <p>
 * <code>
 * 21 22 23 24 25<br/>
 * 20  7  8  9 10<br/>
 * 19  6  1  2 11<br/>
 * 18  5  4  3 12<br/>
 * 17 16 15 14 13<br/>
 * </code>
 * <p>
 * It can be verified that the sum of the numbers on the diagonals is 101.
 * <p>
 * What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?
 */
public class Problem028 implements Problem {
    private static final long SIZE = 1001;

    @Override
    public long solve() {
        long result = 1;

        for (long n = 1, prevUpperRightCorner = 1; n <= SIZE / 2; n++) {
            long downRight = prevUpperRightCorner + 2 * n;
            long downLeft = downRight + 2 * n;
            long upLeft = downLeft + 2 * n;
            long upRight = upLeft + 2 * n;

            result += downRight + downLeft + upLeft + upRight;

            prevUpperRightCorner = upRight;
        }

        return result;
    }
}
