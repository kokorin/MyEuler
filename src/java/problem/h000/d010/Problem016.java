package problem.h000.d010;

import problem.Problem;
import util.Numbers;

import java.math.BigInteger;

/**
 * 2<sup>15</sup> = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * <p>
 * What is the sum of the digits of the number 2<sup>1000</sup>?
 */
public class Problem016 implements Problem {
    private static final int POWER = 1000;

    @Override
    public long solve() {
        BigInteger value = BigInteger.valueOf(2).pow(POWER);
        return Numbers.sumOfDigits(value);
    }
}
