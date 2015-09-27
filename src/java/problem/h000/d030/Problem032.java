package problem.h000.d030;

import problem.Problem;
import util.Numbers;

import java.util.HashSet;
import java.util.Set;

/**
 * We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once;
 * for example, the 5-digit number, 15234, is 1 through 5 pandigital.
 * <p>
 * The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, multiplier,
 * and product is 1 through 9 pandigital.
 * <p>
 * Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.
 * HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.
 */
public class Problem032 implements Problem {

    @Override
    public long solve() {
        Set<Long> result = new HashSet<>();

        for (long a = 1; a < 100_000; a++) {
            for (long b = a; b <= 100_000; b++) {
                long product = a * b;
                long totalDigits = Numbers.numOfDigits(a) + Numbers.numOfDigits(b) + Numbers.numOfDigits(product);
                if (totalDigits > 9) {
                    break;
                }

                long concatenated = Numbers.concat(a, b, product);
                if (Numbers.isPandigital_1_to_9(concatenated)) {
                    result.add(product);
                }
            }
        }

        return result.stream().mapToLong(Long::longValue).sum();
    }

    public static void main(String[] args) {
        System.out.println(new Problem032().solve());
    }
}
