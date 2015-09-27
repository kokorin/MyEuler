package util;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

public class PrimesTest {
    private static final long[] FIRST_PRIMES = {
            2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97,
            101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173
    };

    @Test
    public void testIsPrime() {
        for (int i = FIRST_PRIMES.length-1; i >=0; i--) {
            long prime = FIRST_PRIMES[i];
            Assert.assertTrue(Primes.isPrime(prime));
        }
    }

    @Test
    public void testThousandthPrime() {
        //The 1,000th prime is 7,919.
        Iterator<Long> primeIterator = Primes.iterator();
        for (int i = 0; i < 999; i++) {
            primeIterator.next();
        }
        Assert.assertEquals(7_919, primeIterator.next().longValue());
    }
}
