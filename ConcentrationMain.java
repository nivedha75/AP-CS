public class ConcentrationMain{
    public static void main(String[] args){
        System.out.println("New Test");
        //Concentration.printBoard(Concentration.createBoardPart3B());
        //Concentration.printBoardFaceUp(Concentration.createBoardPart3B());
        for(int i = 1; i <= 4; i++){
            for(int j = 1; j <= 13; j++){
                Card c = new Card(i, j, true);
                if(j < 13)
                    System.out.print(Card.cardToString(c) + " ");
                else
                    System.out.print(Card.cardToString(c) +"\n");
            }
        }
        
        System.out.println();
        
        Card[][] cards = new Card[7][8];
        int x = 1;
        int y = 1;
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 8; j++){
                Card c = new Card(x, y, true);
                if(i == 0)
                    c.isFaceUp = false;
                cards[i][j] = c;
                y++;
                if(y == 14) {
                    x++;
                    y = 1;
                }
                if(i == 6 && j>=4) {
                	for(int k = 0; k < 4; k++) {
                		Card c2 = null;
                		cards[i][j] = c2;
                		j++;
                	}
                    break;
                }
            }
            if(i == 6)
                break;
        }
        Concentration.printBoard(cards);
        System.out.println();
        Concentration.printBoardFaceUp(cards);
        System.out.println("Cards");
        //Card[] randomDeck = Concentration.createRandomDeck();
        Card[][] d = Concentration.createRandomBoard();
        Concentration.printBoardFaceUp(d);
        Concentration.play();
    }
    
}

