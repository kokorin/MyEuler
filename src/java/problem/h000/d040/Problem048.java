package problem.h000.d040;

import problem.Problem;

/**
 * The series, 1<sup>1</sup> + 2<sup>2</sup> + 3<sup>3</sup> + ... + 10<sup>10</sup> = 10405071317.
 * <p>
 * Find the last ten digits of the series, 1<sup>1</sup> + 2<sup>2</sup> + 3<sup>3</sup> + ... + 1000<sup>1000</sup>.
 */
public class Problem048 implements Problem {
    private static final long TEST = 1000;

    @Override
    public long solve() {
        long result = 0;

        for (long number = 1; number <= TEST; number++) {
            long summand = 1;
            for (long power = 1; power <= number; power++) {
                summand = (summand * number) % 10_000_000_000L;
            }

            result = (result + summand) % 10_000_000_000L;
        }

        String resultStr = String.valueOf(result);
        while (resultStr.length() < 10) {
            resultStr = "0" + resultStr;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Problem048().solve());
    }
}
