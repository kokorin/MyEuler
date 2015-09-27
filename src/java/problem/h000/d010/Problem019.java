package problem.h000.d010;

import problem.Problem;

import java.util.Date;

/**
 * You are given the following information, but you may prefer to do some research for yourself.
 * <p>
 * 1 Jan 1900 was a Monday.<br/>
 * Thirty days has September,<br/>
 * April, June and November.<br/>
 * All the rest have thirty-one,<br/>
 * Saving February alone,<br/>
 * Which has twenty-eight, rain or shine.<br/>
 * And on leap years, twenty-nine.<br/>
 * <p>
 * A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
 * <p>
 * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 */
public class Problem019 implements Problem {
    @Override
    public long solve() {
        long result = 0;

        for (int year = 1901; year < 2000; year++) {
            for (int month = 0; month < 12; month++) {
                Date date = new Date(year, month, 1);
                if (date.getDay() == 0) {
                    result++;
                }
            }
        }

        return result;
    }
}
