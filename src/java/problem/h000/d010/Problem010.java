package problem.h000.d010;

import problem.Problem;
import util.Primes;

import java.util.Iterator;

/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 *
 * Find the sum of all the primes below two million.
 */
public class Problem010 implements Problem {
    private static long LIMIT = 2_000_000;
    @Override
    public long solve() {
        Iterator<Long> primeIterator = Primes.iterator();

        long result = 0;
        for (long prime = primeIterator.next(); prime < LIMIT; prime = primeIterator.next()) {
            result += prime;
        }

        return result;
    }
}
