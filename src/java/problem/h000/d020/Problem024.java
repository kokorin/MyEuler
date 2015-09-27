package problem.h000.d020;

import problem.Problem;

/**
 * A permutation is an ordered arrangement of objects.
 * For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4.
 * If all of the permutations are listed numerically or alphabetically, we call it lexicographic order.
 * The lexicographic permutations of 0, 1 and 2 are:
 * <p>
 * 012   021   102   120   201   210
 * <p>
 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 */
public class Problem024 implements Problem {
    private static final int DIGITS = 10;
    private static final int COUNT = 1_000_000;

    @Override
    public long solve() {
        int[] permutation = new int[DIGITS];

        for (int i = 0; i < DIGITS; i++) {
            permutation[i] = i;
        }

        int count = 1;


        boolean mutated = true;
        while (mutated) {
            mutation:
            for (int i = DIGITS - 2; i >= 0; i--) {
                for (int j = DIGITS - 1; j > i; j--) {
                    mutated = false;
                    if (count == COUNT) {
                        break mutation;
                    }

                    if (permutation[i] >= permutation[j]) {
                        continue;
                    }

                    int temp = permutation[i];
                    permutation[i] = permutation[j];
                    permutation[j] = temp;

                    //bubble sorting of right part
                    for (int k = i + 1; k < DIGITS - 1; k++) {
                        for (int t = k + 1; t < DIGITS; t++) {
                            if (permutation[k] > permutation[t]) {
                                temp = permutation[t];
                                permutation[t] = permutation[k];
                                permutation[k] = temp;
                            }
                        }
                    }

                    count++;
                    mutated = true;
                    break mutation;
                }
            }
        }

        long result = 0;
        for (int digit : permutation) {
            result = result * 10 + digit;
        }

        return result;
    }
}
