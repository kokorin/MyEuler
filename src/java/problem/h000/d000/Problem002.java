package problem.h000.d000;

import problem.Problem;
import util.FibonacciIterator;

import java.math.BigInteger;

/**
 * Each new term in the Fibonacci sequence is generated by adding the previous two terms.
 * By starting with 1 and 2, the first 10 terms will be:
 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 * <p>
 * By considering the terms in the Fibonacci sequence whose values do not exceed four million,
 * find the sum of the even-valued terms.
 */
public class Problem002 implements Problem {
    private static final BigInteger TWO = BigInteger.valueOf(2);
    private static final BigInteger LIMIT = BigInteger.valueOf(4_000_000);

    @Override
    public long solve() {
        FibonacciIterator fibonacciIterator = new FibonacciIterator();
        BigInteger result = BigInteger.ZERO;

        for (BigInteger term = BigInteger.ZERO;
             fibonacciIterator.hasNext() && term.compareTo(LIMIT) <= 0;
             term = fibonacciIterator.next()) {
            if (term.remainder(TWO).equals(BigInteger.ZERO)) {
                result = result.add(term);
            }
        }

        return result.longValue();
    }
}
