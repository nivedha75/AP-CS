
public class Poker3 {

	public static void main(String[] args) {
		//Round 1: Nivedha beats Yash with a Pair!"
		//Round 2: Nivedha beats Yash with a Flush!"
		//Round 3: Ishya Jalla beats Nivedha with a Pair!"
		//Round 4: Ishya Jalla beats Nivedha with a High Card!"
		System.out.println(handName(4));
	}

	public static String handName(int value) {

		/*
		 * 7 = full house 6 = flush 5 = straight 4 = 3 of a kind 3 = 2 pairs 2 = pair 1
		 * = high card
		 */
		
		if (value == 1)
			return "high card";
		if (value == 2)
			return "pair";
		if (value == 3)
			return "2 pairs";
		if (value == 4)
			return "3 of a kind";
		if (value == 5)
			return "straight";
		if (value == 6)
			return "flush";
		else
			return "full house";
	}

}
