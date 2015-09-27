package problem.h000.d050;

import problem.Problem;
import util.Primes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * The prime 41, can be written as the sum of six consecutive primes:
 * <p>
 * 41 = 2 + 3 + 5 + 7 + 11 + 13
 * This is the longest sum of consecutive primes that adds to a prime below one-hundred.
 * <p>
 * The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.
 * <p>
 * Which prime, below one-million, can be written as the sum of the most consecutive primes?
 */
public class Problem050 implements Problem {
    public static final long TEST = 1_000_000;

    @Override
    public long solve() {
        long result = 0;

        Iterator<Long> primeIterator = Primes.iterator();
        List<Long> primes = new ArrayList<>();

        int maxPossibleLength = 0;
        long sumOfFirstPrimes = 0;
        for (long prime = primeIterator.next(); prime < TEST; prime = primeIterator.next()) {
            primes.add(prime);
            sumOfFirstPrimes += prime;
            if (sumOfFirstPrimes < TEST) {
                maxPossibleLength++;
            }
        }

        search:
        for (int length = maxPossibleLength; length >= 1; length--) {
            for (int pos = 0; pos <= primes.size() - length; pos++) {
                long sum = 0;
                for (int i = 0; i < length; i++) {
                    sum += primes.get(pos + i);
                }

                if (sum > TEST) {
                    continue search;
                }

                if (Primes.isPrime(sum)) {
                    result = sum;
                    break search;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Problem050().solve());
    }

}
