package problem.h000.d040;

import problem.Problem;
import util.Numbers;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The nth term of the sequence of triangle numbers is given by, tn = ½n(n+1); so the first ten triangle numbers are:
 * <p>
 * 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
 * <p>
 * By converting each letter in a word to a number corresponding to its alphabetical position and adding these values we form a word value. For example, the word value for SKY is 19 + 11 + 25 = 55 = t10. If the word value is a triangle number then we shall call the word a triangle word.
 * <p>
 * Using words.txt (right click and 'Save Link/Target As...'), a 16K text file containing nearly two-thousand common English words, how many are triangle words?
 */
public class Problem042 implements Problem {
    @Override
    public long solve() {
        List<String> words = new ArrayList<>();
        String path = getClass().getName().replaceAll("\\.", "/") + ".dat";

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path)) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader wordReader = new BufferedReader(inputStreamReader);
            for (String line = wordReader.readLine(); line != null; line = wordReader.readLine()) {
                words.add(line);
            }
        } catch (IOException exception) {

        }

        return words.stream().filter(word -> {
            long wordValue = 0;
            for (int i = 0; i < word.length(); i++) {
                wordValue += word.charAt(i) - 'A' + 1;
            }
            //t = ½n(n+1) is the quadratic equation n*n + n - 2*t = 0
            boolean isTriangleWord = Numbers.hasNaturalRoot(1, 1, -2*wordValue);
            return isTriangleWord;
        }).count();
    }

    public static void main(String[] args) {
        System.out.println(new Problem042().solve());
    }
}
