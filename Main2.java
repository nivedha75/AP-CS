class Main2{
    public static void main(String[] args){
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
        int x = 0;
        int y = 0;
        for(int i = 0; i <= 7; i++){
            for(int j = 0; j <= 8; j++){
                Card c = new Card(x, y, true);
                y++;
                if(y == 14) {
                	x++;
                	y = 0;
                }
            }
        }
    }
}