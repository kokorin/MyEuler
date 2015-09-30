package problem.h000.d050;

import problem.Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * In the card game poker, a hand consists of five cards and are ranked, from lowest to highest, in the following way:
 * <ul>
 * <li>High Card: Highest value card.</li>
 * <li>One Pair: Two cards of the same value.</li>
 * <li>Two Pairs: Two different pairs.</li>
 * <li>Three of a Kind: Three cards of the same value.</li>
 * <li>Straight: All cards are consecutive values.</li>
 * <li>Flush: All cards of the same suit.</li>
 * <li>Full House: Three of a kind and a pair.</li>
 * <li>Four of a Kind: Four cards of the same value.</li>
 * <li>Straight Flush: All cards are consecutive values of same suit.</li>
 * <li>Royal Flush: Ten, Jack, Queen, King, Ace, in same suit.</li>
 * </ul>
 * The cards are valued in the order:
 * 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, Ace.
 * <p>
 * If two players have the same ranked hands then the rank made up of the highest value wins;
 * for example, a pair of eights beats a pair of fives (see example 1 below). But if two ranks tie,
 * for example, both players have a pair of queens, then highest cards in each hand are compared (see example 4 below);
 * if the highest cards tie then the next highest cards are compared, and so on.
 * <p>
 * The file, poker.txt, contains one-thousand random hands dealt to two players.
 * Each line of the file contains ten cards (separated by a single space): the first five are Player 1's cards and
 * the last five are Player 2's cards. You can assume that all hands are valid (no invalid characters or repeated cards),
 * each player's hand is in no specific order, and in each hand there is a clear winner.
 * <p>
 * How many hands does Player 1 win?
 */
public class Problem054 implements Problem {
    @Override
    public long solve() {
        long result = 0;
        List<String> combinations = new ArrayList<>();
        String path = getClass().getName().replaceAll("\\.", "/") + ".dat";

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path)) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader wordReader = new BufferedReader(inputStreamReader);
            for (String line = wordReader.readLine(); line != null; line = wordReader.readLine()) {
                combinations.add(line);
            }
        } catch (IOException exception) {

        }

        for (String combination : combinations) {
            Hand hand1 = Hand.valueOf(combination.substring(0, 14));
            Hand hand2 = Hand.valueOf(combination.substring(15, 29));
            if (hand1.compareTo(hand2) > 0) {
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Problem054().solve());
    }
}
