import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
    private ArrayList<Card> allCards;
    private Random rand;
    
    public Deck(int seed) {
        allCards = new ArrayList<>();
        rand = new Random(seed);
        
        for (int i = 0; i < 52; i++) {
            allCards.add(new Card(i));
        }
        
        Collections.sort(allCards);
    }
    
    public void shuffle(int n) {
        for (int i = 0; i < n; i++) {
            int index1 = rand.nextInt(allCards.size());
            int index2 = rand.nextInt(allCards.size());
            
            Collections.swap(allCards, index1, index2);
        }
    }
    
    public Hand deal() {
        Card[] handCards = new Card[5];
        for (int i = 0; i < 5; i++) {
            handCards[i] = allCards.get(i);
        }
        
        return new Hand(handCards);
    }
}