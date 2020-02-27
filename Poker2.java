
import java.util.Scanner;
public class Poker2{
    public static void play(){
        Scanner userInput = new Scanner(System.in);
        String response = "";
        
        int[] deck = new int[52];
        for(int i=0; i<deck.length; i++)
            deck[i] = i+1;
        int[] player1 = new int[5], player2 = new int[5];
        shuffle(deck);
        System.out.println("Welcome to Poker!");
        // System.out.println(handToString(deck)); // mem address
        // Fill each player's hand
        for(int i=0; i<5; i++){
            player1[i] = deck[2*i];
            player2[i] = deck[2*i+1];
        }
        bubbleSort(player1);
        bubbleSort(player2);
        System.out.println("Player1: " + handToString(player1));
        // Ask which to keep
        for(int i=0; i<player1.length; i++){
            System.out.print("Keep " + cardName(player1[i]) + "? (y/n): ");
            response = userInput.next(); // Console.ReadLine()
            if(response.toLowerCase().compareTo("n") == 0)
                player1[i] = 0;
        }
        
        System.out.println("Player2: " + handToString(player2));
        for(int i=0; i<player2.length; i++){
            System.out.print("Keep " + cardName(player2[i]) + "? (y/n): ");
            response = userInput.next(); // Console.ReadLine()
            if(response.toLowerCase().compareTo("n") == 0)
                player2[i] = 0;
        }
        int counter = 10;
        for(int i=0; i<player1.length; i++)
            if(player1[i] == 0){
                player1[i] = deck[counter];
                counter++;
            }
        for(int i=0; i<player2.length; i++)
            if(player2[i] == 0){
                player2[i] = deck[counter];
                counter++;
            }
        bubbleSort(player1);
        bubbleSort(player2);
        System.out.println("Player1: " + handToString(player1));
        System.out.println("Player2: " + handToString(player2));
        if(handValue(player1) > handValue(player2))
            System.out.println("Player1 Wins!!!");
        else if(handValue(player2) > handValue(player1))
            System.out.println("Player2 Wins!!!");
        else
            System.out.println("Tie");
        System.out.println(handName(7));
        
    }
    
    public static String handName(int value) {
    	
    	/* 7 = full house
         * 6 = flush
         * 5 = straight
         * 4 = 3 of a kind
         * 3 = 2 pairs
         * 2 = pair
         * 1 = high card
         */
    	if(value == 1)
    		return "high card";
    	if(value == 2)
    		return "pair";
    	if(value == 3)
    		return "2 pairs";
    	if(value == 4)
    		return "3 of a kind";
    	if(value == 5)
    		return "straight";
    	if(value == 6)
    		return "flush";
    	else
    		return "full house";
    }
    
    public static void bubbleSort(int[] a){
        int storage = 0;
        for(int i=0; i<a.length-1; i++)
            for(int j=0; j<a.length-1-i; j++)
                if(face(a[j]) > face(a[j+1]) ||
                   face(a[j]) == face(a[j+1]) && suit(a[j]) > suit(a[j+1])){
                    storage = a[j];
                    a[j] = a[j+1];
                    a[j+1] = storage;
                }
    }
        
    public static int handValue(int[] hand){
        bubbleSort(hand);
        // 7 Full House
        if(face(hand[0]) == face(hand[1]) && face(hand[3]) == face(hand[4])
          && (face(hand[2])==face(hand[0]) || face(hand[2])==face(hand[4])))
            return 7;
        // 6 Flush
        boolean sameSuit = true;
        int suitValue = suit(hand[0]);
        for(int i=1; i<hand.length; i++)
            sameSuit &= (suitValue == suit(hand[i]));
        if(sameSuit)
            return 6;
        // 5 Straight A2345 10JQKA
        boolean isOrdered = true;
        for(int i=0; i<hand.length-1; i++)
            if(face(hand[i]) != face(hand[i+1]) - 1)
                isOrdered = false;
        if(isOrdered || face(hand[0]) == 1 && face(hand[1]) == 10 &&
            face(hand[2]) == 11 && face(hand[3]) == 12 &&
            face(hand[4]) == 13)
            return 5;
        // 4 Three of a kind
        for(int i=0; i<hand.length-2; i++)
            if(face(hand[i]) == face(hand[i+1]) &&
                face(hand[i]) == face(hand[i+2]))
                return 4;
        // 3 Two Pairs, 2 Pair
        int pairCount=0;
        for(int i=0; i<hand.length-1; i++)
            if(face(hand[i]) == face(hand[i+1]))
                pairCount++;
        if(pairCount == 2)
            return 3;
        if(pairCount == 1)
            return 2;
        return 1;
        // return pairCount + 1;
    }
    public static int face(int card){
        return (card - 1) % 13 + 1;
        /*
        while(card > 13)
            card -= 13;
        return card;*/
    }
    public static int suit(int card){
        return (card-1) / 13 + 1;
        /* if(card<=13)
            return 1;
        if(card<=26)
            return 2; // ...
            */
    }
    public static String cardName(int card){
        String rv = "";
        int s = suit(card); // 1-4
        if(s==1)
            rv = "S";
        if(s==2)
            rv = "H";
        if(s==3)
            rv = "C";
        if(s==4)
            rv = "D";
        String[] faceValues = {"A","2","3","4","5",
            "6","7","8","9","10","J","Q","K"};
        return rv + faceValues[face(card) - 1];
    }
    // handToString() should be given an array of cards and return a String
    // that looks like "[SA DQ H5 C2 S7]"
    public static String handToString(int[] hand){
        String rv = "";
        for(int i=0; i<hand.length; i++)
            if(i==0)
                rv = cardName(hand[0]);
            else
                rv += " " + cardName(hand[i]);
        return "[" + rv + "]";
    }
    public static String arrayToString(int[] a){
        String rv = "";
        for(int i=0; i<a.length; i++)
            if(i==0)
                rv = a[0] + "";
            else
                rv += ", " + a[i];
        return "{" + rv + "}";
    }
    public static void shuffle(int[] d){
        // algo: for each card, pick random card, swap
        int randomIndex=0, storage=0;
        for(int i=0; i<d.length; i++){
            // d[i] will be each card.
            // Want [0-51]
            // Have: double [0,1)  0-51.999
            randomIndex = (int)(Math.random()*52);
            // SWAP!
            storage = d[i];
            d[i] = d[randomIndex];
            d[randomIndex] = storage;
        }
    }
}
