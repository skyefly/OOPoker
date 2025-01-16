import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Hand {
    private Card[] fiveCards;
    
    public Hand(Card[] allCards) {
        this.fiveCards = Arrays.copyOf(allCards, 5);
        Arrays.sort(fiveCards);
    }
    
    public Card[] getCards() {
        return fiveCards;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card card : fiveCards) {
            sb.append(card.toString()).append(" ");
        }
        return sb.toString().trim();
    }
    
    public HandType getHandType() {
        Map<Integer, Integer> rankCounts = new HashMap<>();
        Map<Integer, Integer> suitCounts = new HashMap<>();
        boolean isStraight = true;
        int previousRank = -1;
        
        for (Card card : fiveCards) {
            int rank = card.getRank();
            int suit = card.getSuit();
            
            rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
            suitCounts.put(suit, suitCounts.getOrDefault(suit, 0) + 1);
            
            if (previousRank != -1 && rank != previousRank + 1) {
                isStraight = false;
            }
            previousRank = rank;
        }
        
        boolean isFlush = suitCounts.size() == 1;
        boolean isStraightFlush = isStraight && isFlush;
        
        if (isStraightFlush) {
            return HandType.StraightFlush;
        }
        else if (rankCounts.containsValue(4)) {
            return HandType.FourOfAKind;
        } 
        else if (rankCounts.containsValue(3) && rankCounts.containsValue(2)) {
            return HandType.FullHouse;
        } 
        else if (isFlush) {
            return HandType.Flush;
        } 
        else if (isStraight) {
            return HandType.Straight;
        } 
        else if (rankCounts.containsValue(3)) {
            return HandType.ThreeOfAKind;
        } 
        else if (rankCounts.containsValue(2)) {
            long pairCount = rankCounts.values().stream().filter(count -> count == 2).count();
            if (pairCount == 2) {
                return HandType.TwoPair;
            } 
            else {
                return HandType.OnePair;
            }
        } 
        else {
            return HandType.HighCard;
        }
    }
}