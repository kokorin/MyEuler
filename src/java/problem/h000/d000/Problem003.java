package problem.h000.d000;

import problem.Problem;
import util.Divisors;

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * <p>
 * What is the largest prime factor of the number 600851475143 ?
 */
public class Problem003 implements Problem {
    private static final long VALUE = 600851475143L;

    @Override
    public long solve() {
        return Divisors.getPrimeDivisors(VALUE).stream().
                reduce((divisor1, divisor2) -> divisor1.prime > divisor2.prime ? divisor1 : divisor2).
                get().prime;
    }
}
