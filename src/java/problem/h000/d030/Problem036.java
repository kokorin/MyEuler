package problem.h000.d030;

import problem.Problem;
import util.Palindrome;

import java.util.stream.LongStream;

/**
 * The decimal number, 585 = 10010010012 (binary), is palindromic in both bases.
 * <p>
 * Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.
 * <p>
 * (Please note that the palindromic number, in either base, may not include leading zeros.)
 */
public class Problem036 implements Problem {
    private static final long N = 1_000_000;
    @Override
    public long solve() {
        return LongStream.rangeClosed(1, N).
                filter(value -> Palindrome.isPalindrome(value, 10) && Palindrome.isPalindrome(value, 2)).
                sum();
    }
}
