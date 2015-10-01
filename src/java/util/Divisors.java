package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Divisors {
    public static List<PrimeDivisor> getPrimeDivisors(long value) {
        List<PrimeDivisor> result = new ArrayList<>();

        if (value > 1L) {
            Iterator<Long> primeIterator = Primes.iterator();


            while (value != 1) {
                Long prime = primeIterator.next();
                long power = 0;

                while (value % prime == 0) {
                    value /= prime;
                    power++;
                }

                if (power > 0) {
                    result.add(new PrimeDivisor(prime, power));
                }
            }
        }
        return result;
    }

    public static List<Long> getDivisors(final long value, final boolean proper) {
        List<Long> result = new ArrayList<>();
        if (value > 1L) {
            List<PrimeDivisor> primeDivisors = getPrimeDivisors(value);

            for (PrimeDivisor primeDivisor : primeDivisors) {
                List<Long> toAdd = new ArrayList<>();
                long primeInPower = 1;

                for (long power = 1; power <= primeDivisor.power; power++) {
                    primeInPower *= primeDivisor.prime;

                    for (Long prev : result) {
                        Long divisor = prev * primeInPower;
                        toAdd.add(divisor);
                    }

                    toAdd.add(primeInPower);
                }

                result.addAll(toAdd);
            }

            result.add(1L);
            if (proper) {
                result.remove(value);
            }

            Collections.sort(result);
        }
        return result;
    }

    //TODO possible optimization
    public static long getSumOfDivisors(final long value, final boolean proper) {
        long result = 0;
        for (Long divisor : getDivisors(value, proper)) {
            result += divisor;
        }
        return result;
    }

    public static long getDivisorsCount(final long value, final boolean proper) {
        long result = 1;

        if (value > 1L) {
            Iterator<Long> primeIterator = Primes.iterator();
            long remainder = value;
            while (remainder != 1) {
                long prime = primeIterator.next();
                long power = 0;

                //if remainder isn't prime
                if (prime * prime < remainder) {
                    while (remainder % prime == 0) {
                        remainder /= prime;
                        power++;
                    }
                } else {
                    power = 1;
                    remainder = 1;
                }

                if (power > 0) {
                    result *= power + 1;
                }
            }

            if (proper) {
                result--;
            }
        }

        return result;
    }

    public static class PrimeDivisor {
        public final long prime;
        public final long power;

        public PrimeDivisor(long prime, long power) {
            this.prime = prime;
            this.power = power;
        }

        @Override
        public String toString() {
            return prime + "^" + power;
        }
    }
}
