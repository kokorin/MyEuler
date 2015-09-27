package problem.h000.d030;

import problem.Problem;
import util.Numbers;
import util.Primes;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.
 * <p>
 * There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
 * <p>
 * How many circular primes are there below one million?
 */
public class Problem035 implements Problem {
    private static final long N = 1_000_000;

    @Override
    public long solve() {
        Iterator<Long> primeIterator = Primes.iterator();
        Set<Long> primeSet = new HashSet<>();

        while (primeIterator.hasNext()) {
            long prime = primeIterator.next();
            if (prime > N) {
                break;
            }
            primeSet.add(prime);
        }

        long result = 0;
        for (long prime : primeSet) {
            long circular = prime;
            boolean isCircular = true;

            long order = (long) Math.pow(10, Numbers.numOfDigits(prime) - 1);

            do {
                circular = order * (circular % 10) + circular / 10;
                if (!primeSet.contains(circular)) {
                    isCircular = false;
                    break;
                }
            } while (circular != prime);

            if (isCircular) {
                result++;
            }
        }

        return result;
    }
}
