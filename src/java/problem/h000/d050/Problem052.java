package problem.h000.d050;

import problem.Problem;
import util.Numbers;

/**
 * It can be seen that the number, 125874, and its double, 251748, contain exactly
 * the same digits, but in a different order.
 * <p>
 * Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.
 */
public class Problem052 implements Problem {
    @Override
    public long solve() {
        long result;

        for (result = 1;
             !Numbers.arePermutations(result, 2*result, 3*result, 4*result, 5*result, 6*result);
             result++);

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Problem052().solve());
    }
}
