package problem.h000.d040;

import problem.Problem;
import util.Numbers;
import util.Primes;

import java.util.Iterator;

/**
 * We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once.
 * For example, 2143 is a 4-digit pandigital and is also prime.
 * <p>
 * What is the largest n-digit pandigital prime that exists?
 */
public class Problem041 implements Problem {
    @Override
    public long solve() {
        long maxPandigitalPrime = 0;

        Iterator<Long> primeIterator = Primes.iterator();
        //all pandigital numbers except 4- and 7-digit ones are divisible by 3
        while (primeIterator.hasNext()) {
            long prime = primeIterator.next();
            long digits = Numbers.numOfDigits(prime);
            if (digits > 7) {
                break;
            }
            if (digits != 4 && digits != 7) {
                continue;
            }

            if (Numbers.isPandigital_1_to_N(prime)) {
                maxPandigitalPrime = prime;
            }
        }

        return maxPandigitalPrime;
    }

    public static void main(String[] args) {
        System.out.println(new Problem041().solve());
    }
}
