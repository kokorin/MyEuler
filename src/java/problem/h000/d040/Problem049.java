package problem.h000.d040;

import problem.Problem;
import util.Numbers;
import util.Primes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330, is unusual in two ways:
 * <p>
 * (i) each of the three terms are prime, and,<br/>
 * (ii) each of the 4-digit numbers are permutations of one another.<br/>
 * <p>
 * There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes, exhibiting this property,
 * but there is one other 4-digit increasing sequence.
 * <p>
 * What 12-digit number do you form by concatenating the three terms in this sequence?
 */
public class Problem049 implements Problem {
    @Override
    public long solve() {
        long result = 0;

        Iterator<Long> primeIterator = Primes.iterator();
        List<Long> primes = new ArrayList<>();

        while (primeIterator.hasNext()) {
            long prime = primeIterator.next();
            long digits = Numbers.numOfDigits(prime);
            if (digits > 4) {
                break;
            }
            if (digits == 4) {
                primes.add(prime);
            }
        }

        search:
        for (int i = 0; i < primes.size() - 2; i++) {
            long firstPrime = primes.get(i);

            for (int j = i + 1; j < primes.size() - 1; j++) {
                long secondPrime = primes.get(j);
                long thirdPrime = 2 * secondPrime - firstPrime;
                if (!primes.contains(thirdPrime)) {
                    continue;
                }

                if (!Numbers.arePermutations(firstPrime, secondPrime, thirdPrime)) {
                    continue;
                }

                if (firstPrime == 1487 && secondPrime == 4817 && thirdPrime == 8147) {
                    continue;
                }

                result = Numbers.concat(firstPrime, secondPrime, thirdPrime);
                break search;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Problem049().solve());
    }
}
