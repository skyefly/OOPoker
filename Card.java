public class Card implements Comparable<Card> {
    private int rank;
    private int suit;
    
    public Card(int x) {
        rank = x / 4 + 1;
        suit = x % 4;
    }
    
    public int getSuit() {
        return suit;
    }
    
    public int getRank() {
        return rank;
    }
    
    public String toString() {
        String newRank = "";
        String newSuit = "";
        
        if (rank == 1) {
            newRank = "A";
        }
        else if (rank == 11) {
            newRank = "J";
        }
        else if (rank == 12) {
            newRank = "Q";
        }
        else if (rank == 13) {
            newRank = "K";
        }
        else {
            newRank = Integer.toString(rank);
        }
        
        if (suit == 0) {
            newSuit = "S";
        }
        else if (suit == 1) {
            newSuit = "H";
        }
        else if (suit == 2) {
            newSuit = "D";
        }
        else if (suit == 3) {
            newSuit = "C";
        }
        
        return newRank + newSuit;
    }
    
    @Override
    public int compareTo(Card other) {
        if (this.rank != other.rank) {
            return Integer.compare(this.rank, other.rank);
        }
        return Integer.compare(this.suit, other.suit);
    }
}