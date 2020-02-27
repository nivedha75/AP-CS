import java.util.Scanner;

class Card {
	int suit;
	int face;
	boolean isFaceUp;

	public Card(int suit, int face) {
		this.suit = suit;
		this.face = face;
		this.isFaceUp = false;
	}

	public Card(int suit, int face, boolean isFaceUp) {
		this.suit = suit;
		this.face = face;
		this.isFaceUp = isFaceUp;

	}

	public static String cardToString(Card c) {
		if (c == null)
			return "  ";
		else if (c.isFaceUp == false)
			return "??";
		String cardName = "";
		if (c.suit == 1)
			cardName += "S";
		else if (c.suit == 2)
			cardName += "H";
		else if (c.suit == 3)
			cardName += "C";
		else
			cardName += "D";

		if (c.face == 1)
			cardName += "A";
		else if (c.face > 1 && c.face < 10)
			cardName += c.face;
		else if (c.face == 10)
			cardName += "X";
		else if (c.face == 11)
			cardName += "J";
		else if (c.face == 12)
			cardName += "Q";
		else
			cardName += "K";

		return cardName;
	}
}

public class Concentration {
	// can assume its rectangular
	public static void printBoard(Card[][] cards) {
		for (int i = 0; i < cards[0].length; i++) {
			if (i == 0)
				System.out.print("  ");
			System.out.print(i + 1 + "  ");
		}
		for (int i = 0; i < cards.length; i++) {
			System.out.print("\n" + (i + 1) + " ");
			for (int j = 0; j < cards[i].length; j++) {
				System.out.print(Card.cardToString(cards[i][j]) + " ");
			}
		}
		System.out.println();
	}

	public static void printBoardFaceUp(Card[][] cards) {
		for (int i = 0; i < cards[0].length; i++) {
			if (i == 0)
				System.out.print("  ");
			System.out.print(i + 1 + "  ");
		}
		for (int i = 0; i < cards.length; i++) {
			System.out.print("\n" + (i + 1) + " ");
			for (int j = 0; j < cards[i].length; j++) {
				if (cards[i][j] == null) {
					System.out.print(Card.cardToString(cards[i][j]) + " ");
				} else if (cards[i][j].isFaceUp == false) {
					cards[i][j].isFaceUp = true;
					System.out.print(Card.cardToString(cards[i][j]) + " ");
					cards[i][j].isFaceUp = false;
				} else {
					System.out.print(Card.cardToString(cards[i][j]) + " ");
				}
			}
		}
		System.out.println();
	}

	public static Card[][] createBoardPart3B() {
		// Create and fill a 7 by 8 board
		Card[][] b = new Card[7][8];
		for (int i = 0; i < 52; i++) {
			// suit then face
			b[i / 8][i % 8] = new Card(i % 13 + 1, i / 13 + 1, true);
		}
		return b;
	}

	public static Card[] createRandomDeck() {
		// (int)((Math.random() * ((max - min) + 1)) + min
		Card[] origDeck = new Card[52];
		int x = 1;// suit
		int y = 1;// face
		for (int i = 0; i < 52; i++) {
			Card c = new Card(x, y, true);
			origDeck[i] = c;
			y++;
			if (y == 14) {
				x++;
				y = 1;
			}
		}
		// x finally 5
		int counter = 0;
		Card[] shuffledDeck = new Card[52];
		for (int i = 0; i < 52; i++) {
			int position = (int) (Math.random() * 52);
			boolean notReplaced = true;
			while (notReplaced) {
				if (shuffledDeck[position] == null) {
					shuffledDeck[position] = origDeck[counter];
					System.out.println(Card.cardToString(origDeck[counter]) + " " + position);
					counter++;
					notReplaced = false;
				} else {
					position = (int) (Math.random() * 52);
				}
			}
		}
		return shuffledDeck;
	}

	public static Card[][] createRandomBoard() {
		Card[][] cards = new Card[7][8];
		Card[] randomDeck = createRandomDeck();
		int counter = 0;
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 8; j++) {
				Card c = randomDeck[counter];
				c.isFaceUp = false;
				cards[i][j] = c;
				counter++;
				if (counter == 52) {
					j++;
					for (int k = 0; k < 4; k++) {
						Card c2 = null;
						cards[i][j] = c2;
						j++;
					}
					break;
				}
			}
			if (i == 6)
				break;
		}
		return cards;
	}

	public static void play() {
		Card[][] c = createRandomBoard();
		Concentration.printBoard(c);
		System.out.println();
		int player1 = 0;
		int player2 = 0;
		int currentPlayer = 1;
		boolean gameIsNotOver = true;
		while (gameIsNotOver) {
			if (currentPlayer == 1 && play2(c) == 1) {
				System.out.println("Player 1 got the pair");
				player1 += 2;
			} else if (currentPlayer == -1 && play2(c) == 1) {
				System.out.println("Player 2 got the pair");
				player2 += 2;
			}else {
				System.out.println("Not matching");
				currentPlayer *= -1;
			}
			if(player1 + player2 == 52) {
				gameIsNotOver = false;
				if(player1 > player2)
					System.out.println("Player 1 wins!");
				else if(player2 > player1)
					System.out.println("Player 2 wins!");
				else
					System.out.println("Tie!");
			}
		}

	}

	public static int play2(Card[][] c) {
		Scanner row1 = new Scanner(System.in);
		System.out.println("row1:");
		int r1 = row1.nextInt();
		Scanner col1 = new Scanner(System.in);
		System.out.println("col1:");
		int c1 = col1.nextInt();
		Scanner row2 = new Scanner(System.in);
		System.out.println("row2:");
		int r2 = row2.nextInt();
		Scanner col2 = new Scanner(System.in);
		System.out.println("col2:");
		int c2 = col2.nextInt();
		if (c[r1 - 1][c1 - 1].suit == c[r2 - 1][c2 - 1].suit) {
			c[r1 - 1][c1 - 1].isFaceUp = true;
			c[r1 - 1][c1 - 1].isFaceUp = true;
			return 1;
		} else {
			return 0;
		}
	}

}
