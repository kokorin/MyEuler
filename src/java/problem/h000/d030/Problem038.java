package problem.h000.d030;

import problem.Problem;
import util.Numbers;

import java.util.stream.LongStream;

/**
 * Take the number 192 and multiply it by each of 1, 2, and 3:
 * <p>
 * 192 × 1 = 192<br/>
 * 192 × 2 = 384<br/>
 * 192 × 3 = 576<br/>
 * </p>
 * <p>
 * By concatenating each product we get the 1 to 9 pandigital, 192384576. We will call 192384576
 * the concatenated product of 192 and (1,2,3)
 * </p>
 * The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5, giving the pandigital,
 * 918273645, which is the concatenated product of 9 and (1,2,3,4,5).
 * <p>
 * What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated product
 * of an integer with (1,2, ... , n) where n > 1?
 * </p>
 */
public class Problem038 implements Problem {
    @Override
    public long solve() {
        return LongStream.range(1, 1_000_000).parallel().map(value -> {
            long concatProducts = value;

            for (int n = 2; n < 10; n++) {
                long product = value * n;
                concatProducts = Numbers.concat(concatProducts, product);
                if (concatProducts > 1_000_000_000) {
                    break;
                }

                if (Numbers.isPandigital_1_to_9(concatProducts)) {
                    return concatProducts;
                }
            }
            return 0;
        }).max().getAsLong();
    }

    public static void main(String[] args) {
        System.out.println(new Problem038().solve());
    }
}
