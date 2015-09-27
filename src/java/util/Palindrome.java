package util;

public class Palindrome {
    public static boolean isPalindrome(long value) {
        return isPalindrome(value, 10);
    }

    public static boolean isPalindrome(long value, int base) {
        int multiplier = 1;

        while (multiplier < value) {
            multiplier *= base;
        }
        if (multiplier > value) {
            multiplier /= base;
        }

        while (value > 0) {
            long left = value / multiplier;
            long right = value % base;
            if (left != right) {
                return false;
            }

            value = (value % multiplier) / base;
            multiplier /= base * base;
        }

        return true;
    }
}
