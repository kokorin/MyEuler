package problem.h000.d020;

import problem.Problem;
import util.Primes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10 are given:
 * <p>
 * 1/2	= 	0.5<br/>
 * 1/3	= 	0.(3)<br/>
 * 1/4	= 	0.25 <br/>
 * 1/5	= 	0.2 <br/>
 * 1/6	= 	0.1(6)<br/>
 * 1/7	= 	0.(142857) <br/>
 * 1/8	= 	0.125 <br/>
 * 1/9	= 	0.(1)<br/>
 * 1/10	= 	0.1 <br/>
 * <p>
 * Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring cycle.
 * <p>
 * Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.
 */
public class Problem026 implements Problem {
    public static int N = 1_000;

    @Override
    public long solve() {
        Fraction maxCycle = Fraction.getFraction(1, 1);

        Iterator<Long> primeIterator = Primes.iterator();
        while (primeIterator.hasNext()) {
            long prime = primeIterator.next();
            if (prime > N) {
                break;
            }

            Fraction fraction = Fraction.getFraction(1, prime);
            if (fraction.getCycleLength() > maxCycle.getCycleLength()) {
                maxCycle = fraction;
            }
        }

        return maxCycle.divisor;
    }

    private static class Fraction {
        public final long dividend;
        public final long divisor;

        public final long integral;
        public final String fractional;
        public final String cycled;

        private Fraction(long dividend, long divisor, long integral, String fractional, String cycled) {
            this.dividend = dividend;
            this.divisor = divisor;
            this.integral = integral;
            this.fractional = fractional;
            this.cycled = cycled;
        }

        public int getCycleLength() {
            return cycled != null ? cycled.length() : 0;
        }

        public static Fraction getFraction(final long dividend, final long divisor) {
            long integral = dividend / divisor;
            long remainder = dividend % divisor;

            List<Long> remainders = new ArrayList<>();
            List<Byte> digits = new ArrayList<>();

            while (remainder != 0) {
                remainder *= 10;
                byte digit = (byte) (remainder / divisor);
                remainder = remainder % divisor;

                int cycleIndex = remainders.lastIndexOf(remainder);
                if (cycleIndex != -1 && digits.get(cycleIndex) == digit) {
                    String fractional = jointBytes(digits.subList(0, cycleIndex));
                    String cycled = jointBytes(digits.subList(cycleIndex, digits.size()));
                    return new Fraction(dividend, divisor, integral, fractional, cycled);
                }

                remainders.add(remainder);
                digits.add(digit);
            }

            String fractional = jointBytes(digits);
            return new Fraction(dividend, divisor, integral, fractional, null);
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();

            builder.append(dividend).append(":").append(divisor).append(" = ").
                    append(integral).append(".").append(fractional);

            if (cycled != null) {
                builder.append("(").append(cycled).append(")");
            }
            return builder.toString();
        }

        private static String jointBytes(List<Byte> list) {
            return list.stream().map(value -> String.valueOf(value)).collect(Collectors.joining());
        }

    }

}
