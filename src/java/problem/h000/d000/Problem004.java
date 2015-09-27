package problem.h000.d000;

import problem.Problem;
import util.Palindrome;

/**
 * A palindromic number reads the same both ways.
 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 ? 99.
 * <p>
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class Problem004 implements Problem {
    @Override
    public long solve() {
        long result = 0;

        for (long mult1 = 999; mult1 >= 100; mult1--) {
            for (long mult2 = 999; mult2 >= mult1; mult2--) {
                long product = mult1 * mult2;
                if (product < result) {
                    continue;
                }

                if (Palindrome.isPalindrome(product)) {
                    result = product;
                }
            }
        }

        return result;
    }
}
