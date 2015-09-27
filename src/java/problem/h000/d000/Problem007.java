package problem.h000.d000;

import problem.Problem;
import util.Primes;

import java.util.Iterator;

/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * <p>
 * What is the 10 001st prime number?
 */
public class Problem007 implements Problem{
    private static final int INDEX = 10_001;
    @Override
    public long solve() {
        Iterator<Long> primeIterator = Primes.iterator();
        for (int index = 1; index < INDEX;
             primeIterator.next(), index++){}

        return primeIterator.next();
    }
}
