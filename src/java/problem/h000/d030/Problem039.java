package problem.h000.d030;

import problem.Problem;

/**
 * If p is the perimeter of a right angle triangle with integral length sides, {a,b,c},
 * there are exactly three solutions for p = 120.
 * <p>
 * {20,48,52}, {24,45,51}, {30,40,50}
 * <p>
 * For which value of p ≤ 1000, is the number of solutions maximised?
 */
public class Problem039 implements Problem {
    public static void main(String[] args) {
        System.out.println(new Problem039().solve());
    }

    @Override
    public long solve() {
        long maxSolutions = 0;
        long result = 0;

        for (long p = 1; p <= 1000; p++) {
            long solutions = 0;

            for (long a = 1; a <= p / 3; a++) {
                for (long b = a; b <= (p - a) / 2; b++) {
                    long c = p - a - b;
                    if (c * c == (a * a + b * b)) {
                        solutions++;
                    }
                }
            }

            if (solutions > maxSolutions) {
                maxSolutions = solutions;
                result = p;
            }
        }

        return result;
    }
}
