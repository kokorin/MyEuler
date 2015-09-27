package util;

import java.util.*;

public class Primes {
    private static final List<Long> primes = new ArrayList<>(5_000_000);

    static {
        synchronized (primes) {
            primes.add(0, 2L);
            primes.add(1, 3L);
        }
    }

    public static Iterator<Long> iterator() {
        return new PrimeIterator();
    }

    public static boolean isPrime(long value) {
        synchronized (primes) {
            long maxKnownPrime = primes.get(primes.size() - 1);
            while (value > maxKnownPrime * maxKnownPrime)  {
                maxKnownPrime = nextPrime();
            }
            if (value < maxKnownPrime) {
                return Collections.binarySearch(primes, value) >= 0;
            }

            for (long prime : primes) {
                if (prime * prime > value) {
                    break;
                }
                if (value % prime == 0) {
                    return false;
                }
            }

            return true;
        }
    }

    private static class PrimeIterator implements Iterator<Long> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Long next() {
            Long result;

            synchronized (primes) {
                while (index >= primes.size()) {
                    nextPrime();
                }
            }

            result = primes.get(index);
            index++;
            return result;
        }
    }

    private static long nextPrime() {
        long result;
        long lastKnownPrime = primes.get(primes.size()-1);

        for (long possiblePrime = lastKnownPrime + 2; ; possiblePrime += 2) {
            boolean isPrime = true;
            for (long prime : primes) {
                if (prime * prime > possiblePrime) {
                    break;
                }
                if (possiblePrime % prime == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(possiblePrime);
                result = possiblePrime;
                break;
            }
        }

        return result;
    }
}
