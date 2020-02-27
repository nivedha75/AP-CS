
class MathClass {
	// Constants (Final Static Variables)
	public static final double E = 2.72;
	public static final double PI = 3.14;
	// Static/Class Variables
	private static int count = 0;

	// Nonstatic/Instance Variables
	// Constructors
	public MathClass() {
	}

	// Getters/Setters
	public static int getCount() {
		return count;
	}

	// Static Methods
	public static double abs(double value) {
		count++;
		if (value < 0)
			return -value;
		return value;
	}

	public static String abs(int value) {
		count++;
		if (value < 0)
			return -value + "";
		//MathClass obj = new MathClass();
		//System.out.println(obj.absNS(9));
		return value + "";
		
	}

	// Nonstatic Methods
	public double absNS(double value) {
		count++;
		if (value < 0)
			return -value;
		return value;
	}

	public int absNS(int value) {
		count++;
		if (value < 0)
			return -value;
		return value;
	}

	public int sqrtNS(int value) {
		count++;
		for (int i = 0; i < value; i++) {
			if (i * i > value)
				return i - 1;
		}
		return 0;
	}

}

public class MathClassMain {

	public static void main(String[] args) {
		System.out.println("Math.E = " + Math.E);
		System.out.println("MathClass.E = " + MathClass.E);
		System.out.println("Math.PI = " + Math.PI);
		System.out.println("MathClass.PI = " + MathClass.PI);
		MathClass m = new MathClass();
		// You can access static variables through objects and class.
		// But you cannot access nonstatic variables through the class.
		System.out.println("m.E = " + m.E);
		System.out.println("m.PI = " + m.PI);

		System.out.println("Math.abs(4.0) = " + Math.abs(4.0));//count does not increase here
		System.out.println("MathClass.abs(4.0) = " + MathClass.abs(4.0));
		System.out.println("Math.abs(4) = " + Math.abs(4));//count does not increase here
		System.out.println("MathClass.abs(4) = " + MathClass.abs(4));
		
		MathClass m2 = new MathClass();
		System.out.println("m2.absNS(4.0) = " + m2.absNS(4.0));
		System.out.println("m2.abs(4.0) = " + m2.abs(4.0));
		System.out.println("m2.absNS(4) = " + m2.absNS(4));
		System.out.println("m2.abs(4) = " + m2.abs(4));

		// Illegal Method Calls
		// MathClass.absNS(4);
		// MathClass.absNS(4.0);

		MathClass m3 = new MathClass();
		System.out.println("m3.sqrtNS(5) = " + m3.sqrtNS(5));
		System.out.println("m3.sqrtNS(8) = " + m3.sqrtNS(8));
		System.out.println("m3.sqrtNS(9) = " + m3.sqrtNS(9));
		
		// Illegal Method Calls
		// MathClass.sqrtNS(4);
		// MathClass.sqrtNS(4.0);
		
		//this is the code that was m3 in the instructions
		MathClass m4 = new MathClass();
		for (int i = 0; i < 10; i++)
			System.out.println("m4.sqrtNS(" + i + ") = " + m4.sqrtNS(i));
		// Guess what this will print out before running:
		System.out.println("MathClass.getCount() = " + MathClass.getCount()); //9+10 = 19
		System.out.println("m4.getCount() = " + m4.getCount());

	}

}
