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
        //all pandigital numbers except 4- and 7-digit ones are divisible by 3
        for (long value = 7_654_321; ; value-=2) {
            if (Numbers.isPandigital_1_to_N(value) && Primes.isPrime(value)) {
                return value;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Problem041().solve());
    }
}
