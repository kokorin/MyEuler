package problem.h000.d050;

import java.util.*;
import java.util.stream.Collectors;

public class Hand implements Comparable<Hand>{
    private final Card[] cards;
    private final Value value;

    private Hand(Card[] cards) {
        this.cards = cards;
        value = evaluate(cards);
    }

    public Value getValue() {
        return value;
    }

    @Override
    public int compareTo(Hand other) {
        return this.getValue().compareTo(other.getValue());
    }

    private static Value evaluate(Card[] cards) {
        if (cards.length != 5) {
            throw new IllegalArgumentException();
        }
        Map<Card.Rank, Integer> rankCounts = new EnumMap<>(Card.Rank.class);
        Set<Card.Suit> suits = EnumSet.noneOf(Card.Suit.class);

        for (Card card : cards) {
            Integer rankCount = rankCounts.getOrDefault(card.getRank(), 0);
            rankCounts.put(card.getRank(), rankCount + 1);
            suits.add(card.getSuit());
        }

        Map<Integer, List<Card.Rank>> countRanks = new HashMap<>();
        for (Card.Rank rank : rankCounts.keySet()) {
            Integer count = rankCounts.get(rank);

            List<Card.Rank> ranks = countRanks.get(count);
            if (ranks == null) {
                ranks = new ArrayList<>();
                countRanks.put(count, ranks);
            }

            ranks.add(rank);
        }

        boolean flush = suits.size() == 1;
        boolean straight = false;
        Card.Rank straightHigh = null;

        //The ace may also be played as a low card (Steel Wheel)
        if (rankCounts.getOrDefault(Card.Rank.ACE, 0) == 1) {
            boolean steelWheel = true;
            for (int i = 0; i < 4; i++) {
                Card.Rank rank = Card.Rank.values()[i];
                if (rankCounts.getOrDefault(rank, 0) != 1) {
                    steelWheel = false;
                    break;
                }
            }

            if (steelWheel) {
                straight = true;
                straightHigh = Card.Rank.FIVE;
            }
        }

        if (!straight) {
            for (int i = 0; i <= Card.Rank.values().length - cards.length; i++) {
                boolean consecutiveRanks = true;
                for (int j = 0; j < 5; j++) {
                    Card.Rank rank = Card.Rank.values()[i + j];
                    if (rankCounts.getOrDefault(rank, 0) != 1) {
                        consecutiveRanks = false;
                        break;
                    }
                }
                if (consecutiveRanks) {
                    straight = true;
                    straightHigh = Card.Rank.values()[i + 4];
                    break;
                }
            }
        }

        if (straight && flush) {
            return new Value(Combination.STRAIGHT_FLUSH, Collections.singletonList(straightHigh));
        }
        //If we have FLUSH or STRAIGHT, we can't get FOUR_OF_A_KIND or FULL_HOUSE in the same Hand
        if (flush) {
            return new Value(Combination.FLUSH, addAbsentRanks(rankCounts));
        }
        if (straight) {
            return new Value(Combination.STRAIGHT, Collections.singletonList(straightHigh));
        }

        //There is only 2 distinct ranks in Hand.
        //It can be 4-1 or 3-2, e.g. FOUR_OF_A_KIND or FULL_HOUSE
        if (rankCounts.size() == 2) {
            if (countRanks.containsKey(4)) {
                Card.Rank four = countRanks.get(4).get(0);
                Card.Rank fifth = countRanks.get(1).get(0);
                return new Value(Combination.FOUR_OF_A_KIND, addAbsentRanks(rankCounts, four, fifth));
            }

            Card.Rank three = countRanks.get(3).get(0);
            Card.Rank pair = countRanks.get(2).get(0);
            return new Value(Combination.FULL_HOUSE, addAbsentRanks(rankCounts, three, pair));
        }

        //There is 3 distinct ranks in Hand.
        //It can be 3-1-1 or 2-2-1, e.g. THREE_OF_A_KIND or TWO_PAIRS
        if (rankCounts.size() == 3) {
            if (countRanks.containsKey(3)) {
                Card.Rank three = countRanks.get(3).get(0);
                return new Value(Combination.THREE_OF_A_KIND, addAbsentRanks(rankCounts, three));
            }

            Card.Rank highPair = countRanks.get(2).get(0);
            Card.Rank lowPair = countRanks.get(2).get(1);
            if (highPair.getValue() < lowPair.getValue()) {
                Card.Rank temp = highPair;
                highPair = lowPair;
                lowPair = temp;
            }
            return new Value(Combination.TWO_PAIRS, addAbsentRanks(rankCounts, highPair, lowPair));
        }

        //There is 4 distinct ranks in Hand.
        //It can only be 2-1-1-1, e.g. PAIR
        if (rankCounts.size() == 4) {
            Card.Rank pair = countRanks.get(2).get(0);
            return new Value(Combination.PAIR, addAbsentRanks(rankCounts, pair));
        }

        return new Value(Combination.HIGH_CARD, addAbsentRanks(rankCounts));
    }

    private static List<Card.Rank> addAbsentRanks(Map<Card.Rank, Integer> rankCounts, Card.Rank ...ranks) {
        List<Card.Rank> result = new ArrayList<>();
        if (ranks != null) {
            result.addAll(Arrays.asList(ranks));
        }

        for (int i = Card.Rank.values().length - 1; i >= 0; i--) {
            Card.Rank rank = Card.Rank.values()[i];
            if (rankCounts.containsKey(rank) && !result.contains(rank)) {
                result.add(rank);
            }
        }
        return result;
    }



    @Override
    public String toString() {
        return String.format("%s %s %s %s %s (%s)", cards[0], cards[1], cards[2], cards[3], cards[4], value);
    }

    public static Hand valueOf(String value) {
        if (value.length() != 14) {
            throw new IllegalArgumentException();
        }
        Card[] cards = new Card[5];
        for (int i = 0; i < cards.length; i++) {
            cards[i] = Card.valueOf(value.substring(3 * i, 3 * i + 2));
        }

        return new Hand(cards);
    }

    public enum Combination {
        HIGH_CARD,
        PAIR,
        TWO_PAIRS,
        THREE_OF_A_KIND,
        STRAIGHT,
        FLUSH,
        FULL_HOUSE,
        FOUR_OF_A_KIND,
        STRAIGHT_FLUSH,
    }

    public static class Value implements Comparable<Value>{
        private final Combination combination;
        private final List<Card.Rank> ranks;

        private Value(Combination combination, List<Card.Rank> ranks) {
            this.combination = combination;
            this.ranks = ranks;
        }

        public Combination getCombination() {
            return combination;
        }

        public List<Card.Rank> getRanks() {
            return ranks;
        }

        @Override
        public int compareTo(Value other) {
            int result = this.getCombination().compareTo(other.getCombination());
            if (result != 0) {
                return result;
            }

            if (this.getRanks().size() != other.getRanks().size()) {
                throw new IllegalArgumentException();
            }
            for (int i = 0; i < this.getRanks().size(); i++) {
                Card.Rank thisRank = this.getRanks().get(i);
                Card.Rank otherRank = other.getRanks().get(i);
                result = thisRank.compareTo(otherRank);
                if (result != 0) {
                    return result;
                }
            }

            return 0;
        }

        @Override
        public String toString() {
            return combination + " " +
                    ranks.stream().map(rank -> String.valueOf(rank.getLetter()))
                            .collect(Collectors.joining(""));
        }
    }
}
