package util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

public class Numbers {
    private static final long[] PANDIGITALS_1_TO_N = new long[10];
    private static final long[] PANDIGITALS_0_TO_N = new long[10];

    private static final int BITS_PER_DIGIT = 6;

    static {
        long pandigital0 = 0;
        for (int i = 0; i <= 9; i++) {
            PANDIGITALS_1_TO_N[i] = pandigital0 << BITS_PER_DIGIT;
            PANDIGITALS_0_TO_N[i] = pandigital0 = (pandigital0 << BITS_PER_DIGIT) + 1;
        }
    }

    public static boolean isPandigital_1_to_9(long value) {
        return isPandigital_1_to_N(value, 9);
    }

    public static boolean isPandigital_1_to_N(long value) {
        return isPandigital_1_to_N(value, numOfDigits(value));
    }

    public static boolean isPandigital_1_to_N(long value, int n) {
        if (n >= PANDIGITALS_1_TO_N.length) {
            return false;
        }
        return countDigits(value) == PANDIGITALS_1_TO_N[n];
    }

    public static boolean isPandigital_0_to_9(long value) {
        return isPandigital_0_to_N(value, 10);
    }

    public static boolean isPandigital_0_to_N(long value) {
        return isPandigital_0_to_N(value, numOfDigits(value));
    }

    public static boolean isPandigital_0_to_N(long value, int n) {
        if (n > PANDIGITALS_0_TO_N.length) {
            return false;
        }
        return countDigits(value) == PANDIGITALS_0_TO_N[n-1];
    }

    public static boolean arePermutations(long ...values) {
        if (values.length < 2) {
            throw new IllegalArgumentException("at least 2 values");
        }
        long digits = countDigits(values[0]);
        for (int i = 1; i < values.length; i++) {
            if (digits != countDigits(values[i])) {
                return false;
            }
        }
        return true;
    }

    private static long countDigits(final long value) {
        long result = 0;

        final long numOfDigits = numOfDigits(value);
        for (long i = 0; i < numOfDigits; i++) {
            long digit = getDigitAt(value, i);
            result += 1L << (digit * BITS_PER_DIGIT);
        }

        return result;
    }

    public static int numOfDigits(long value) {
        if (value == 0) {
            return 1;
        }

        int result = 0;
        while (value > 0) {
            result++;
            value /= 10;
        }

        return result;
    }

    public static long getDigitAt(long value, long index) {
        long order = (long)Math.pow(10, numOfDigits(value) - index - 1);
        return (value / order) % 10;
    }

    public static long concat(long ...values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("Values must be specified");
        }

        long result = values[0];

        for (int i = 1; i < values.length; i++) {
            long value = values[i];
            long multiplier = (long)Math.pow(10, numOfDigits(value));
            result = multiplier * result + value;
        }

        return result;
    }

    public static BigInteger factorial(long value) {
        return LongStream.rangeClosed(1, value).
                mapToObj(val -> BigInteger.valueOf(val)).
                reduce(BigInteger.ONE, (left, right) -> left.multiply(right));
    }

    public static long sumOfDigits(BigInteger value) {
        long result = 0;
        while (!value.equals(BigInteger.ZERO)) {
            BigInteger[] divideAndRemainder = value.divideAndRemainder(BigInteger.TEN);
            value = divideAndRemainder[0];
            result += divideAndRemainder[1].longValue();
        }
        return result;
    }

    public static boolean hasNaturalRoot(long a, long b, long c) {
        for (long root : getIntegerRoots(a, b, c)) {
            if (root > 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasIntegerRoot(long a, long b, long c) {
        List<Long> roots = getIntegerRoots(a, b, c);
        return roots.size() > 0;
    }

    private static List<Long> getIntegerRoots(long a, long b, long c) {
        List<Long> result = new ArrayList<>();

        long determinant = b * b - 4 * a * c;
        if (determinant < 0) {
            return result;
        }

        long determinantSqrt = (long)Math.sqrt(determinant);
        if (determinantSqrt * determinantSqrt != determinant) {
            return result;
        }


        long numerator1 = -b + determinantSqrt;
        if (numerator1 % (2 * a) == 0) {
            result.add(numerator1 / (2 * a));
        }

        long numerator2 = -b - determinantSqrt;
        if (numerator2 % (2 * a) == 0) {
            result.add(numerator2 / (2 * a));
        }

        return result;
    }
}
