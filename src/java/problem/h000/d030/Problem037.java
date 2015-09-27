package problem.h000.d030;

import problem.Problem;
import util.Numbers;
import util.Primes;

import java.util.*;
import java.util.stream.Collectors;

/**
 * The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove
 * digits from left to right, and remain prime at each stage: 3797, 797, 97, and 7.
 * Similarly we can work from right to left: 3797, 379, 37, and 3.
 * <p>
 * Find the sum of the only eleven primes that are both truncatable from left to right and right to left.
 * <p>
 * NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
 */
public class Problem037 implements Problem {
    private static final List<Long> ONE_DIGIT_PRIMES = Arrays.asList(2L, 3L, 5L, 7L);

    @Override
    public long solve() {
        List<Long> leftTruncatablePrimes = new ArrayList<>(ONE_DIGIT_PRIMES);
        List<Long> rightTruncatablePrimes = new ArrayList<>(ONE_DIGIT_PRIMES);
        long result = 0;

        while (!leftTruncatablePrimes.isEmpty() && !rightTruncatablePrimes.isEmpty()) {
            List<Long> nextLeft = new ArrayList<>();
            List<Long> nextRight = new ArrayList<>();

            for (Long prime : leftTruncatablePrimes) {
                for (long i = 1; i <= 9; i++) {
                    long possiblePrime = Numbers.concat(i, prime);
                    if (Primes.isPrime(possiblePrime)) {
                        nextLeft.add(possiblePrime);
                    }
                }
            }

            for (Long prime : rightTruncatablePrimes) {
                for (long i = 1; i <= 9; i++) {
                    long possiblePrime = Numbers.concat(prime, i);
                    if (Primes.isPrime(possiblePrime)) {
                        nextRight.add(possiblePrime);
                        if (nextLeft.contains(possiblePrime)) {
                            result += possiblePrime;
                        }
                    }
                }
            }

            leftTruncatablePrimes = nextLeft;
            rightTruncatablePrimes = nextRight;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Problem037().solve());
    }
}
