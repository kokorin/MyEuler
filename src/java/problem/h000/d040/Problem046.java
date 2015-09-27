package problem.h000.d040;

import problem.Problem;
import util.Numbers;
import util.Primes;

import java.util.Iterator;

/**
 * It was proposed by Christian Goldbach that every odd composite number can be written
 * as the sum of a prime and twice a square.
 * <p>
 * 9 = 7 + 2×1<sup>2</sup><br/>
 * 15 = 7 + 2×2<sup>2</sup><br/>
 * 21 = 3 + 2×3<sup>2</sup><br/>
 * 25 = 7 + 2×3<sup>2</sup><br/>
 * 27 = 19 + 2×2<sup>2</sup><br/>
 * 33 = 31 + 2×1<sup>2</sup><br/>
 * <p>
 * It turns out that the conjecture was false.
 * <p>
 * What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?
 */
public class Problem046 implements Problem {
    @Override
    public long solve() {
        long result;

        for (long value = 3; ; value+=2) {
            Iterator<Long> primeIterator = Primes.iterator();

            boolean goldbachWasRight = false;
            for (long prime = primeIterator.next(); prime <= value; prime = primeIterator.next()) {
                if (Numbers.hasIntegerRoot(2, 0, prime - value)) {
                    goldbachWasRight = true;
                    break;
                }
            }

            if (!goldbachWasRight) {
                result = value;
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Problem046().solve());
    }
}
