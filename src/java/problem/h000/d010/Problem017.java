package problem.h000.d010;

import problem.Problem;

import java.util.stream.IntStream;

/**
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five,
 * then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 *
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words,
 * how many letters would be used?
 *
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two)
 * contains 23 letters and 115 (one hundred and fifteen) contains 20 letters.
 * The use of "and" when writing out numbers is in compliance with British usage.
 */
public class Problem017 implements Problem {
    private static int LIMIT = 1000;

    private static String[] FIRST_TWENTY = new String[]{ "",
            "ONE", "TWO", "THREE", "FOUR", "FIVE",
            "SIX", "SEVEN", "EIGHT", "NINE", "TEN",
            "ELEVEN", "TWELVE", "thirteen", "fourteen", "fifteen",
            "sixteen", "seventeen", "eighteen", "nineteen", "twenty"};

    private static String[] TENS = new String[]{ null,
            null, "twenty", "thirty", "forty", "fifty",
            "sixty", "seventy", "eighty", "ninety"
    };

    private static String and = "and";

    @Override
    public long solve() {
        int result = IntStream.rangeClosed(1, LIMIT).map(value -> {
            int thousands = value / 1000;
            int hundreds = (value / 100) % 10;
            int remainder = value % 100;

            int count = 0;

            if (thousands > 0) {
                if (count > 0) {
                    count += and.length();
                }
                count += FIRST_TWENTY[thousands].length() + "thousand".length();
            }
            if (hundreds > 0) {
                if (count > 0) {
                    count += and.length();
                }
                count += FIRST_TWENTY[hundreds].length() + "hundred".length();
            }
            if (remainder > 0 && remainder <= 20) {
                if (count > 0) {
                    count += and.length();
                }
                count += FIRST_TWENTY[remainder].length();
            } else if (remainder > 20) {
                if (count > 0) {
                    count += and.length();
                }
                count += TENS[remainder / 10].length() + FIRST_TWENTY[remainder % 10].length();
            }

            return count;
        }).sum();

        return result;
    }
}
