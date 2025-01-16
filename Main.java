import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the seed value : ");
        int seed = input.nextInt();
        
        Deck deck = new Deck(seed);
        
        for (int i = 0; i < 5; i++) {
            deck.shuffle(676);
            Hand hand = deck.deal();
            System.out.println(hand);
        }
        
        System.out.print("Enter the number of hands : ");
        int numHands = input.nextInt();
        
        int[] handTypeCount = new int[HandType.values().length];
        
        for (int i = 0; i < numHands; i++) {
            deck.shuffle(676);
            Hand hand = deck.deal();
            HandType handType = hand.getHandType();
            handTypeCount[handType.ordinal()]++;
        }
        
        for (HandType handType : HandType.values()) {
            int count = handTypeCount[handType.ordinal()];
            double percentage = (count / (double) numHands) * 100;
            System.out.printf("%-20s %10.5f%% %5d\n", handType.name(), percentage, count);
        }
	}
}