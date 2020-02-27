import java.util.Scanner;
public class Poker{
    
    public static void main(String[] args){
        play();
    }
    
    public static void play(){
        Scanner userInput = new Scanner(System.in);
        String response = "";
        int[] deck = new int[52];
        for(int i = 0; i < deck.length; i++){
            deck[i] = i + 1;
        }
        int[] player1 = new int[5], player2 = new int[5];
        shuffle(deck);
        System.out.println("Welcome To Poker");
        System.out.println(handToString(deck));
        for(int i = 0; i < 5; i++){
            player1[i] = deck[2*i];
            player2[i] = deck[2*i + 1];
        }
        bubbleSort(player1);
        bubbleSort(player2);
        System.out.println(handToString(player1));
        //System.out.println(handToString(player2));
        //ask which cards to keep
        for(int i = 0; i < player1.length; i++){
            System.out.print("Keep " + cardName(player1[i]) + "? (y/n): ");
            response = userInput.next();
            if(response.toLowerCase().compareTo("n") == 0){
                player1[i] = 0;
                
            }
            System.out.println();
        }
        System.out.println(handToString(player2));
        
        //ask which cards to keep
        for(int i = 0; i < player2.length; i++){
            System.out.print("Keep " + cardName(player2[i]) + "? (y/n): ");
            response = userInput.next();
            if(response.toLowerCase().compareTo("n") == 0){
                player2[i] = 0;
            }
            System.out.println();
        }
        
        int counter = 10;
        for(int i = 0; i < player1.length; i++)
            if(player1[i] == 0){
                player1[i] = deck[counter];
                counter++;
            }
        for(int i = 0; i < player2.length; i++)
            if(player2[i] == 0){
                player2[i] = deck[counter];
                counter++;
            }
        System.out.println("Player1: " + handToString(player1));
        System.out.println("Player2: " + handToString(player2));
        
        if(handValue(player1) < handValue(player2))
            System.out.println("Player 1 Wins!!");
        else if(handValue(player1) < handValue(player2))
            System.out.println("Player 2 Wins!!");
        else
            System.out.println("Tie");
    }
    
    public static void bubbleSort(int[] a){
        int storage = 0;
        for(int i = 0; i < a.length - 1 ; i++) {
            for(int j = 0; j < a.length - 1 - i; j++) {
                //sorted by face(number or person) then suit
                if(face(a[j]) > face(a[j+1]) || face(a[j]) == face(a[j+1]) && suit(a[j]) > suit(a[j+1])){
                    storage = a[j];
                    a[j] = a[j+1];
                    a[j+1] = a[j];
                }
            }
        }
    }
    
    public static int handValue(int[] hand){
        /* 7 = full house
         * 6 = flush
         * 5 = straight
         * 4 = 3 of a kind
         * 3 = 2 pairs
         * 2 = pair
         * 1 = high card
         */
        if(hand[0] == hand[1] && hand[3] == hand[4] && (hand[2] == hand[3] || hand[2] == hand[3]))
            return 7;
            
        boolean sameSuit = true;
        int suitValue = suit(hand[0]);
        for(int i = 1; i < hand.length; i++){
            sameSuit &= (suitValue == suit(hand[i]));
        }
        if(sameSuit)
            return 6;
        
            //10JQKA
        boolean inOrder = true;
        for(int i = 0; i < hand.length - 1; i++){
            if(face(hand[i]) != face(hand[i+1] - 1))
                inOrder = false;
        }
        if(face(hand[0]) == 1 && face(hand[1]) == 10 && 
            face(hand[2]) == 111 && face(hand[3]) == 12 && face(hand[4]) == 13 || inOrder)
            return 5;
            
        //4 Three of a Kind
        for(int i = 0; i < hand.length - 2; i++)
            if(face(hand[i]) == face(hand[i+1]) && face(hand[i]) == face(hand[i+2]))
                return 4;
                
        int numPairs = 0;
        for(int i = 0; i < hand.length -1; i++)
            if(face(hand[i]) == face(hand[i+1]))
                numPairs++;
        if(numPairs == 2)
            return 3;
        if(numPairs == 1)
            return 2;
        return 1; //orig teacher said 0; I put 1
    }
    
    public static int suit(int card){
        return (card-1)/13+1;
    }
    
    public static String cardName(int card){
        int s = suit(card);
        String rv = "";
        if(s == 1)
            rv = "S";
        if(s == 2)
            rv = "H";
        if(s == 3)
            rv = "C";
        if(s == 4)
            rv = "D";
        String[] faceValues = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        rv += faceValues[face(card)-1];
        return rv;
    }
            
    public static String handToString(int [] hand){
        String rv = "";
        for(int i = 0; i < hand.length; i++){
            if(i == 0)
                rv += cardName(hand[0]);
            else
                rv += " " + cardName(hand[i]);
        }
        return rv;
    }
    
    public static int face(int card){
        return (card-1)%13+1; //1 -> 1 13-> 13 14 -> 1 16 -> 3
        /*while(card > 13){
            card -= 13;
        }
        return card;
        */
    }
    
    public static String arrayToString(int[] a){
        String rv = "";
        for(int i = 0; i < a.length; i++){
            if(i== 0)
                rv+= a[0];
            else
                rv += ", " + a[i];
        }
            return "{" + rv +"}";
    }
    
    public static void shuffle(int[] d){// d is the 52 cards
        //pick a random card and swap them
        int randomIndex = 0;
        int storage = 0;
        for(int i = 0; i < d.length; i++){
            randomIndex = (int)(Math.random()*52); //double between [0, 1) 0-0.99999 0-52.9999
            //now random int between 0 to 51
            storage = d[i];
            d[i] = d[randomIndex];
            d[randomIndex] = storage;
            
        }
    }
    
}





