package problem.h000.d040;

import problem.Problem;
import util.Divisors;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * The first two consecutive numbers to have two distinct prime factors are:
 * <p>
 * 14 = 2 × 7<br/>
 * 15 = 3 × 5<br/>
 * <p>
 * The first three consecutive numbers to have three distinct prime factors are:
 * <p>
 * 644 = 2² × 7 × 23<br/>
 * 645 = 3 × 5 × 43<br/>
 * 646 = 2 × 17 × 19<br/>
 * <p>
 * Find the first four consecutive integers to have four distinct prime factors. What is the first of these numbers?
 */
public class Problem047 implements Problem {
    private static final int TEST = 4;

    @Override
    public long solve() {
        long firstValue = 2;
        search:
        while (true) {
            long lastValue = firstValue + TEST - 1;
            List<Divisors.PrimeDivisor> lastDivisors = Divisors.getPrimeDivisors(lastValue);
            //There can't be four consecutive integers with such property
            if (lastDivisors.size() != TEST) {
                firstValue = lastValue + 1;
                continue;
            }

            List<List<Divisors.PrimeDivisor>> allDivisors = new ArrayList<>();
            for (int i = TEST - 2; i >= 0; i--) {
                List<Divisors.PrimeDivisor> iDivisors = Divisors.getPrimeDivisors(firstValue + i);
                //if (firstValue + i) doesn't meet requirements with lastValue, than continue search
                if (iDivisors.size() != TEST ) {
                    firstValue += i + 1;
                    continue search;
                }
                if (!haveNoCommonDivisor(iDivisors, lastDivisors)) {
                    firstValue = lastValue + 1;
                    continue search;
                }
                allDivisors.add(0, iDivisors);
            }
            allDivisors.add(lastDivisors);

            boolean allDivisorsAreDistinct = true;
            divisorsCheck:
            //All numbers were already checked for having common divisor with lastValue
            for (int i = 1; i < allDivisors.size() - 1; i++) {
                List<Divisors.PrimeDivisor> divisorsI = allDivisors.get(i);
                for (int j = 0; j < i; j++) {
                    List<Divisors.PrimeDivisor> divisorsJ = allDivisors.get(j);

                    if (!haveNoCommonDivisor(divisorsI, divisorsJ)) {
                        allDivisorsAreDistinct = false;
                        break divisorsCheck;
                    }
                }
            }

            if (allDivisorsAreDistinct) {
                return firstValue;
            }
        }
    }

    private static boolean haveNoCommonDivisor(List<Divisors.PrimeDivisor> divisors1, List<Divisors.PrimeDivisor> divisors2) {
        for (Divisors.PrimeDivisor divisor1 : divisors1) {
            for (Divisors.PrimeDivisor divisor2 : divisors2) {
                if (divisor1.prime == divisor2.prime && divisor1.power == divisor2.power) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Problem047().solve());
    }
}
