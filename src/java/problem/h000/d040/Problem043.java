package problem.h000.d040;

import problem.Problem;
import util.Numbers;

/**
 * The number, 1406357289, is a 0 to 9 pandigital number because it is made up of each of the digits 0 to 9 in some order, but it also has a rather interesting sub-string divisibility property.
 * <p>
 * Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:
 * <p>
 * d2d3d4=406 is divisible by 2<br/>
 * d3d4d5=063 is divisible by 3<br/>
 * d4d5d6=635 is divisible by 5<br/>
 * d5d6d7=357 is divisible by 7<br/>
 * d6d7d8=572 is divisible by 11<br/>
 * d7d8d9=728 is divisible by 13<br/>
 * d8d9d10=289 is divisible by 17<br/>
 * Find the sum of all 0 to 9 pandigital numbers with this property.
 */
public class Problem043 implements Problem {
    @Override
    public long solve() {
        long result = 0;

        for (long d1 = 1; d1 <= 9; d1++) {
            for (long d2 = 0; d2 <= 9; d2++) {
                for (long d3 = 0; d3 <= 9; d3++) {
                    //d2d3d4=406 is divisible by 2
                    for (long d4 = 0; d4 <= 9; d4 += 2) {
                        for (long d5 = 0; d5 <= 9; d5++) {
                            //d3d4d5=063 is divisible by 3
                            if ((d3 + d4 + d5) % 3 != 0) {
                                continue;
                            }
                            //d4d5d6=635 is divisible by 5
                            for (long d6 = 0; d6 <= 9; d6 += 5) {
                                for (long d7 = 0; d7 <= 9; d7++) {
                                    //d5d6d7=357 is divisible by 7
                                    if ((100 * d5 + 10 * d6 + d7) % 7 != 0) {
                                        continue;
                                    }

                                    for (long d8 = 0; d8 <= 9; d8++) {
                                        //d6d7d8=572 is divisible by 11
                                        if ((100 * d6 + 10 * d7 + d8) % 11 != 0) {
                                            continue;
                                        }

                                        for (long d9 = 0; d9 <= 9; d9++) {
                                            //d7d8d9=728 is divisible by 13
                                            if ((100 * d7 + 10 * d8 + d9) % 13 != 0) {
                                                continue;
                                            }

                                            for (long d10 = 0; d10 <= 9; d10++) {
                                                //d8d9d10=289 is divisible by 17
                                                if ((100 * d8 + 10 * d9 + d10) % 17 != 0) {
                                                    continue;
                                                }

                                                long value = 1_000_000_000 * d1 +
                                                        100_000_000 * d2 +
                                                        10_000_000 * d3 +
                                                        1_000_000 * d4 +
                                                        100_000 * d5 +
                                                        10_000 * d6 +
                                                        1_000 * d7 +
                                                        100 * d8 +
                                                        10 * d9 +
                                                        d10;

                                                if (!Numbers.isPandigital_0_to_9(value)) {
                                                    continue;
                                                }

                                                result += value;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Problem043().solve());
    }
}
