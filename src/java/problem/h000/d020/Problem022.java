package problem.h000.d020;

import problem.Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names,
 * begin by sorting it into alphabetical order. Then working out the alphabetical value for each name,
 * multiply this value by its alphabetical position in the list to obtain a name score.
 * <p>
 * For example, when the list is sorted into alphabetical order,
 * COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list.
 * So, COLIN would obtain a score of 938 ? 53 = 49714.
 * <p>
 * What is the total of all the name scores in the file?
 */
public class Problem022 implements Problem {
    @Override
    public long solve() {
        List<String> names = new ArrayList<>();

        String path = getClass().getName().replaceAll("\\.", "/") + ".dat";
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path)) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                names.add(line);
            }
        } catch (IOException exception) {

        }
        Collections.sort(names);

        long result = 0;
        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i).toLowerCase();

            long alphabeticalValue = 0;
            for (int pos = 0; pos < name.length(); pos++) {
                alphabeticalValue += name.charAt(pos) - 'a' + 1;
            }

            result += (i + 1) * alphabeticalValue;
        }

        return result;
    }
}
