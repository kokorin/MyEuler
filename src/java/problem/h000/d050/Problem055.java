package problem.h000.d050;

import problem.Problem;
import util.Numbers;

import java.math.BigInteger;

/**
 * If we take 47, reverse and add, 47 + 74 = 121, which is palindromic.
 * <p>
 * Not all numbers produce palindromes so quickly. For example,
 * <p>
 * 349 + 943 = 1292,<br/>
 * 1292 + 2921 = 4213<br/>
 * 4213 + 3124 = 7337<br/>
 * <p>
 * That is, 349 took three iterations to arrive at a palindrome.
 * <p>
 * Although no one has proved it yet, it is thought that some numbers, like 196, never produce a palindrome.
 * A number that never forms a palindrome through the reverse and add process is called a Lychrel number.
 * Due to the theoretical nature of these numbers, and for the purpose of this problem, we shall assume that
 * a number is Lychrel until proven otherwise. In addition you are given that for every number below ten-thousand,
 * it will either
 * <ol>
 * <li>become a palindrome in less than fifty iterations,</li> or,
 * <li>no one, with all the computing power that exists, has managed so far to map it to a palindrome.</li>
 * </ol>
 *  In fact, 10677 is the first number to be shown to require over fifty iterations before producing a palindrome:
 *  4668731596684224866951378664 (53 iterations, 28-digits).
 * Surprisingly, there are palindromic numbers that are themselves Lychrel numbers; the first example is 4994.
 * <p>
 * How many Lychrel numbers are there below ten-thousand?
 */
public class Problem055 implements Problem {
    @Override
    public long solve() {
        long result = 0;
        for (long i = 1; i < 10_000; i++) {
            BigInteger value = BigInteger.valueOf(i);

            boolean lychrel = true;
            for (int j = 0; j < 50; j++) {
                value = value.add(Numbers.revert(value));
                boolean palindromic = Numbers.revert(value).equals(value);
                if (palindromic) {
                    lychrel = false;
                    break;
                }
            }

            if (lychrel) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Problem055().solve());
    }
}
