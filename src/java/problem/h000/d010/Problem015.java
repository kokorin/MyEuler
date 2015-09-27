package problem.h000.d010;

import problem.Problem;
import util.Numbers;

import java.math.BigInteger;
import java.util.stream.LongStream;

/**
 * Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down,
 * there are exactly 6 routes to the bottom right corner.
 * <p>
 * How many such routes are there through a 20×20 grid?
 */
public class Problem015 implements Problem {
    private static final long GRID_SIZE = 20;

    @Override
    public long solve() {
        BigInteger fact2TEST = Numbers.factorial(2 * GRID_SIZE);
        BigInteger factTEST = Numbers.factorial(GRID_SIZE);

        BigInteger result = fact2TEST.divide(factTEST).divide(factTEST);

        return result.longValue();
    }
}
