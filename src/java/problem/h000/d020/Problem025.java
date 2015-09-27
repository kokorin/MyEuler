package problem.h000.d020;

import problem.Problem;
import util.FibonacciIterator;

import java.math.BigInteger;

/**
 * The Fibonacci sequence is defined by the recurrence relation:
 * <p>
 * F<sub>n</sub> = F<sub>n?1</sub> + F<sub>n?2</sub>, where F<sub>1</sub> = 1 and F<sub>2</sub> = 1.
 * <p>
 * The 12th term, F12, is the first term to contain three digits.
 * <p>
 * What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
 */
public class Problem025 implements Problem {
    public static final int DIGITS = 1000;

    @Override
    public long solve() {
        BigInteger MAX = BigInteger.TEN.pow(DIGITS - 1);
        FibonacciIterator iterator = new FibonacciIterator();

        int index = 1;
        while (iterator.hasNext()) {
            BigInteger number = iterator.next();
            if (number.compareTo(MAX) >= 0) {
                break;
            }
            index++;
        }

        return index;
    }
}
