package problem.h000.d050;

import java.util.HashMap;
import java.util.Map;

public class Card {
    private final Rank rank;
    private final Suit suit;
    private static final Map<Suit, Map<Rank, Card>> map = new HashMap<>();

    static {
        for (Suit suit : Suit.values()) {
            Map<Rank, Card> rankMap = new HashMap<>();
            for (Rank rank : Rank.values()) {
                Card card = new Card(rank, suit);
                rankMap.put(rank, card);
            }
            map.put(suit, rankMap);
        }
    }

    private Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return String.format("%c%c", rank.getLetter(), suit.getLetter());
    }

    public static Card valueOf(String value) {
        if (value.length() != 2) {
            throw new IllegalArgumentException();
        }

        Rank rank = Rank.valueOf(value.charAt(0));
        Suit suit = Suit.valueOf(value.charAt(1));
        return map.get(suit).get(rank);
    }

    public enum Rank {
        TWO('2', 2),
        THREE('3', 3),
        FOUR('4', 4),
        FIVE('5', 5),
        SIX('6', 6),
        SEVEN('7', 7),
        EIGHT('8', 8),
        NINE('9', 9),
        TEN('T', 10),
        JACK('J', 11),
        QUEEN('Q', 12),
        KING('K', 13),
        ACE('A', 14)
        ;

        private final char letter;
        private final int value;

        Rank(char letter, int value) {
            this.letter = letter;
            this.value = value;
        }

        public char getLetter() {
            return letter;
        }

        public int getValue() {
            return value;
        }

        public static Rank valueOf(char letter) {
            for (Rank rank : Rank.values()) {
                if (letter == rank.letter) {
                    return rank;
                }
            }
            return null;
        }
    }

    public enum Suit {
        HEARTS('H'),
        DIAMONDS('D'),
        CLUBS('C'),
        SPADES('S'),
        ;
        private final char letter;

        Suit(char letter) {
            this.letter = letter;
        }

        public char getLetter() {
            return letter;
        }

        public static Suit valueOf(char letter) {
            for (Suit suit : Suit.values()) {
                if (letter == suit.letter) {
                    return suit;
                }
            }
            return null;
        }
    }
}
