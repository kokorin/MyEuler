package problem.h000.d030;

import problem.Problem;
import util.Divisors;

/**
 * The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it
 * may incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.
 * <p>
 * We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
 * <p>
 * There are exactly four non-trivial examples of this type of fraction, less than one in value,
 * and containing two digits in the numerator and denominator.
 * <p>
 * If the product of these four fractions is given in its lowest common terms, find the value of the denominator.
 */
public class Problem033 implements Problem {
    @Override
    public long solve() {
        int resultNumerator = 1;
        int resultDenominator = 1;

        for (int numeratorTens = 1; numeratorTens <= 9; numeratorTens++) {
            for (int numeratorOnes = 1; numeratorOnes <= 9; numeratorOnes++) {

                for (int denominatorTens = 1; denominatorTens <= 9; denominatorTens++) {
                    for (int denominatorOnes = 1; denominatorOnes <= 9; denominatorOnes++) {

                        int numerator = numeratorTens * 10 + numeratorOnes;
                        int denominator = denominatorTens * 10 + denominatorOnes;
                        if (numerator >= denominator) {
                            continue;
                        }

                        if (numeratorTens == denominatorOnes) {
                            if ((numerator * denominatorTens) == (denominator * numeratorOnes)) {
                                resultNumerator *= numeratorOnes;
                                resultDenominator *= denominatorTens;
                            }
                        }

                        if (numeratorOnes == denominatorTens) {
                            if ((numerator * denominatorOnes) == (denominator * numeratorTens)) {
                                resultNumerator *= numeratorTens;
                                resultDenominator *= denominatorOnes;
                            }
                        }

                    }
                }
            }
        }

        long result = resultDenominator;
        for (Divisors.PrimeDivisor primeDivisor : Divisors.getPrimeDivisors(resultNumerator)) {
            for (long power = 1; power <= primeDivisor.power; power++) {
                if (result % primeDivisor.prime != 0) {
                    break;
                }
                result /= primeDivisor.prime;
            }
        }

        return result;
    }
}
