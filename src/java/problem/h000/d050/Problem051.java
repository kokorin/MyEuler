package problem.h000.d050;

import problem.Problem;
import util.Numbers;
import util.Primes;

import java.util.*;

/**
 * By replacing the 1st digit of the 2-digit number *3, it turns out that six of the nine possible values:
 * 13, 23, 43, 53, 73, and 83, are all prime.
 * <p>
 * By replacing the 3rd and 4th digits of 56**3 with the same digit, this 5-digit number is the first example
 * having seven primes among the ten generated numbers, yielding the family:
 * 56003, 56113, 56333, 56443, 56663, 56773, and 56993.
 * <p>
 * Consequently 56003, being the first member of this family, is the smallest prime with this property.
 * <p>
 * Find the smallest prime which, by replacing part of the number (not necessarily adjacent digits)
 * with the same digit, is part of an eight prime value family.
 */
public class Problem051 implements Problem {
    public static final long TEST = 8;

    @Override
    public long solve() {
        long result = 0;

        int lastNumOfDigits = 0;
        final List<boolean[]> masks = new ArrayList<>();

        search:
        for (Iterator<Long> primeIterator = Primes.iterator(); primeIterator.hasNext(); ) {
            long prime = primeIterator.next();
            int numOfDigits = Numbers.numOfDigits(prime);
            if (lastNumOfDigits != numOfDigits) {
                masks.clear();
                addMasks(masks, numOfDigits);
                lastNumOfDigits = numOfDigits;
            }

            for (boolean[] mask : masks) {
                long beginWithIndex = 0;
                //prime must be the first prime in sequence!
                while (beginWithIndex <= 9 && prime != replaceDigits(prime, mask, beginWithIndex)) {
                    beginWithIndex++;
                }

                //counting primes in sequence
                long generatedPrimes = 0;
                for (long digit = beginWithIndex; digit <= 9; digit++) {
                    long possiblePrime = replaceDigits(prime, mask, digit);
                    if (Primes.isPrime(possiblePrime)) {
                        generatedPrimes++;
                    }
                }

                if (generatedPrimes == TEST) {
                    result = prime;
                    break search;
                }
            }
        }

        return result;
    }

    private static void addMasks(List<boolean[]> masks, int digits) {
        boolean[] mask = new boolean[digits];
        addMasks(masks, digits, 0, mask);
    }
    private static void addMasks(List<boolean[]> masks, int digits, int position, boolean[] mask) {
        if (position >= digits) {
            return;
        }

        addMasks(masks, digits, position+1, mask);

        boolean[] changedMask = Arrays.copyOf(mask, digits);
        changedMask[position] = true;
        masks.add(changedMask);
        addMasks(masks, digits, position + 1, changedMask);
    }

    private static long replaceDigits(long value, boolean[] mask, long digit) {
        long[] valueDigits = new long[mask.length];
        for (int i = 0; i < mask.length; i++) {
            valueDigits[mask.length - i -1] = value % 10;
            value /= 10;
        }

        long result = 0;
        for (int i = 0; i < mask.length; i++) {
            result = 10*result + (mask[i] ? digit : valueDigits[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Problem051().solve());
    }
}
