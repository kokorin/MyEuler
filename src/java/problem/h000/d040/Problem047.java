package problem.h000.d040;

import problem.Problem;
import util.Divisors;

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
        long result;
        List<Long> numbers = new LinkedList<>();
        List<List<Divisors.PrimeDivisor>> primeDivisors = new LinkedList<>();

        for (int i = 0; i < TEST; i++) {
            long value = 2 + i;
            numbers.add(value);
            primeDivisors.add(Divisors.getPrimeDivisors(value));
        }

        while (true) {
            boolean everyNumberHasNFactors = true;
            for (List<Divisors.PrimeDivisor> divisors : primeDivisors) {
                if (divisors.size() < TEST) {
                    everyNumberHasNFactors = false;
                    break;
                }
            }

            if (everyNumberHasNFactors) {
                boolean allDivisorsAreDistinct = true;
                divisorsCheck:
                for (int i = 1; i < TEST; i++) {
                    List<Divisors.PrimeDivisor> divisorsI = primeDivisors.get(i);
                    for (int j = 0; j < i; j++) {
                        List<Divisors.PrimeDivisor> divisorsJ = primeDivisors.get(j);

                        for (Divisors.PrimeDivisor divisorI : divisorsI) {
                            for (Divisors.PrimeDivisor divisorJ : divisorsJ) {
                                if (divisorI.prime == divisorJ.prime && divisorI.power == divisorJ.power) {
                                    allDivisorsAreDistinct = false;
                                    break divisorsCheck;
                                }
                            }
                        }
                    }
                }

                if (allDivisorsAreDistinct) {
                    result = numbers.get(0);
                    break;
                }
            }

            long nextValue = numbers.remove(0) + TEST;
            primeDivisors.remove(0);

            numbers.add(nextValue);
            primeDivisors.add(Divisors.getPrimeDivisors(nextValue));
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Problem047().solve());
    }
}
