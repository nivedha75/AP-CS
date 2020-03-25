package Inheritance;
public class Recursion {
	public static void main(String[] args) {
		// linear test
		System.out.println("x \t y");
		for (int i = 0; i <= 10; i++) {
			System.out.println(i + " \t " + linear(i, 2, 3));
		}
		System.out.println();
		// fib test
		System.out.println("n \t nth Fib number");
		for (int i = 1; i <= 25; i++) {
			System.out.println(i + " \t " + fib(i));
		}
		System.out.println();
		// pascals test
		int row = 1;
		for (int column = 1; column <= row; column++) {
			System.out.print(pascals(row, column) + " ");
			if (column == row) {
				if (column != 10) {
					row++;
					column = 0;
					System.out.println();
				} else
					break;
			}
		}
		System.out.println();
		System.out.println();
		//quadratic test
		System.out.println("x\ty");
		for(int i = 0; i <= 10; i++) {
			System.out.println(i + "\t" + quadratic(i, 2, 1, 1));
		}
		System.out.println();
		System.out.println(doubleLetters("Hello"));
		System.out.println(capVowel("Hello"));
		System.out.println(reverse("Hello"));
		System.out.println(isPallindrome("Hello"));
		System.out.println(isPallindrome("noon"));
		for(int i = 1000; i <= 9999; i++) {
			if(isPallindrome(Integer.toString(i)))
				System.out.println(i);
		}
		System.out.println();
		System.out.println(beforeVowel("vowel"));
		System.out.println(beforeVowel("owl"));
		System.out.println(noLeadingWhiteSpace("  He llo"));
		System.out.println(beforeSpace("Hello Dave"));
		System.out.println(afterVowel("vowel"));
		System.out.println(afterVowel("owl"));
		System.out.println(afterSpace("Hello Dave"));
		//System.out.println(" ");
		//System.out.println(" ".substring(1)); // is ""
		System.out.println(noLeadingWhiteSpace(""));
		System.out.println(pigLatin("hello world"));
	}

	public static int linear(int x, int m, int b) {
		if (x == 0)
			return b;
		return m + linear(x - 1, m, b);
	}

	public static int fib(int n) {
		if (n <= 2)
			return 1;
		return fib(n - 1) + fib(n - 2);
	}

	public static int pascals(int r, int c) {
		if (r == c || c == 1)
			return 1;
		return pascals(r - 1, c - 1) + pascals(r - 1, c);
	}

	public static double quadratic(int x, int a, int b, int c) {
		if (x == 0)
			return c;
		else
			return quadratic(x - 1, a, b, c) + a * (x + (x - 1)) + b;
	}

	public static double quadratic2(int x, int a, int b, int c) {
		if (x == 0)
			return c;
		else
			return quadratic(x - 1, a, b, c) + linear(x, 2 * a, b - a);
	}

	public static String doubleLetters(String s) {
		if (s == null  || s.equals(""))
			return "";
		return s.substring(0, 1) + s.substring(0, 1) + doubleLetters(s.substring(1));
	}

	public static String capVowel(String s) {
		if (s == null || s.equals(""))
			return "";
		else if ("AEIOUaeiou".indexOf(s.substring(0, 1)) >= 0) {
			return s.substring(0, 1).toUpperCase() + capVowel(s.substring(1));
		} else
			return s.substring(0, 1) + capVowel(s.substring(1));
	}

	public static String reverse(String s) {
		if (s == null || s.equals(""))
			return "";
		else if (s.length() == 1)
			return s;
		else
			return s.substring(s.length() - 1) + reverse(s.substring(0, s.length() - 1));
	}

	public static boolean isPallindrome(String s) {
		if (s == null)
			return false;
		else if (reverse(s).compareTo(s) == 0)
			return true;
		return false;
	}

	public static String beforeVowel(String s) {
		if (s == null || s.equals(""))
			return "";
		else if ("AEIOUaeiou".indexOf(s.substring(0, 1)) >= 0) {
			return "";
		} else {
			return s.substring(0, 1) + beforeVowel(s.substring(1));
		}
	}

	boolean noVowel = true;

	public static String afterVowel(String s) {
    	if(s == null || s.equals("")) {
    		return "";
    	}else if("AEIOUaeiou".indexOf(s.substring(0, 1)) >= 0) {
    		return s;
    	}else {
    		return afterVowel(s.substring(1));
    	}
    	
    }
	public static String noLeadingWhiteSpace(String s) {
		if(s == null || s.equals("")) {
    		return "";
    	}else if(s.substring(0, 1).compareTo(" ") != 0) {
    		return s;
    	}else {
    		return noLeadingWhiteSpace(s.substring(1));
    	}
	}
	public static String beforeSpace(String s) {
		if (s == null || s.equals(""))
			return "";
		else if (s.substring(0, 1).compareTo(" ") == 0) {
			return "";
		} else {
			return s.substring(0, 1) + beforeSpace(s.substring(1));
		}
	}
	public static String afterSpace(String s) {
		//s.equals("") is very important since afterSpace("world") becomes afterSpace(" ")
		//and then afterSpace("") and s.substring(0, 1) where s is "" does not work-it is indexOutOfBounds
		//similar idea for beforeSpace("world") and noLeadingWhiteSpace(" ")
    	if(s == null || s.equals("")) {
    		return "";
    	}else if(s.substring(0, 1).compareTo(" ") == 0) {
    		return s.substring(1);
    	}else {
    		return afterSpace(s.substring(1));
    	}
    	
    }
	public static String pigLatin(String s) {
		s = noLeadingWhiteSpace(s);
		String w = beforeSpace(s);
		String rest = afterSpace(s);
		if(w.compareTo("") == 0)
			return "";
		else
			return afterVowel(w) + beforeVowel(w) + "ay " + pigLatin(rest);
	}
}
