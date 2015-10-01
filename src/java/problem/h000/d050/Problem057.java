package problem.h000.d050;

import problem.Problem;
import util.Numbers;

import java.math.BigInteger;

/**
 * It is possible to show that the square root of two can be expressed as an infinite continued fraction.
 * <p>
 * √2 = 1 + 1/(2 + 1/(2 + 1/(2 + ... ))) = 1.414213...
 * <p>
 * By expanding this for the first four iterations, we get:
 * <p>
 * 1 + 1/2 = 3/2 = 1.5<br/>
 * 1 + 1/(2 + 1/2) = 7/5 = 1.4<br/>
 * 1 + 1/(2 + 1/(2 + 1/2)) = 17/12 = 1.41666...<br/>
 * 1 + 1/(2 + 1/(2 + 1/(2 + 1/2))) = 41/29 = 1.41379...<br/>
 * <p>
 * The next three expansions are 99/70, 239/169, and 577/408, but the eighth expansion, 1393/985, is the first example
 * where the number of digits in the numerator exceeds the number of digits in the denominator.
 * <p>
 * In the first one-thousand expansions, how many fractions contain a numerator with more digits than denominator?
 */
public class Problem057 implements Problem {
    private static final BigInteger TWO = BigInteger.valueOf(2L);
    @Override
    public long solve() {
        long result = 0;

        BigInteger numerator = BigInteger.ONE;
        BigInteger denominator = BigInteger.ONE;
        for (int i = 0; i < 1000; i++) {
            BigInteger nextNumerator = denominator.multiply(TWO).add(numerator);
            BigInteger nextDenominator = denominator.add(numerator);
            numerator = nextNumerator;
            denominator = nextDenominator;

            //It seems that toString is not mush slower, than continues division by 10 for big numbers
            if (numerator.toString().length() > denominator.toString().length()) {
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Problem057().solve());
    }
}
