public class MoneyUsingArrays {
	public static void main(String[] args) {
		// createMoney()
	    int[] a = createMoney(4,115);
	    System.out.println("5 15: " + a[0] + " " + a[1]);
	    // copyMoney()
	    int[] b = copyMoney(a);
	    a[1] = 50;
	    System.out.println("5 50: " + a[0] + " " + a[1]);
	    System.out.println("5 15: " + b[0] + " " + b[1]);
	    // dollars()
	    System.out.println("Dollars: 5: " + dollars(a));
	    // cents()
	    System.out.println("Cents: 50: " + cents(a));
	    // moneyToString()
	    System.out.println("$5.50: " + moneyToString(a));
	    int[] c = createMoney(1,2);
	    System.out.println("$1.02: " + moneyToString(c));
	    // moneyToText()
	    System.out.println("five dollars and fifty cents: " + moneyToText(a));
	    // isGreater()
	    System.out.println("isGreater: true: " + isGreaterThan(a,b));
	    // isEqual()
	    System.out.println("isEqual: false: " + isEqual(a,b));
	    // adder()
	    a = createMoney(1,10);
	    b = createMoney(2,20);
	    adder(a,b);
	    System.out.println("$3.30: " + moneyToString(a));
	    System.out.println("$2.20: " + moneyToString(b));
	    // add()
	    b = add(a,b);
	    System.out.println("$3.30: " + moneyToString(a));
	    System.out.println("$5.50: " + moneyToString(b));
	    //subber()
	    a = createMoney(1,10);
	    b = createMoney(4,40);
	    subber(b,a);
	    System.out.println("$1.10: " + moneyToString(a));
	    System.out.println("$3.30: " + moneyToString(b));
	    // sub()
	    c = sub(b,a);
	    System.out.println("$1.10: " + moneyToString(a));
	    System.out.println("$3.30: " + moneyToString(b));
	    //payWith20
	    int [] d = new int [2];
	    d[0] = 9;
	    d[1] = 40;
	    c = payWith20(d);
	    System.out.println("$10.60: " + moneyToString(c));
	    //payWith20
	    int [] e = new int [2];
	    e[0] = 9;
	    e[1] = 0;
	    c = payWith20(e);
	    System.out.println("$11.00: " + moneyToString(c));
	    //applyInterest
	    int [] f = new int [2];
	    f[0] = 3;
	    f[1] = 25;
	    c = applyInterest(f,5);
	    System.out.println("$3.41: " + moneyToString(c));
	    

	}

	public static int[] createMoney(int dollars, int cents) {
		int money[] = new int[2];
		money[0] = dollars;
		money[1] = cents;

		while (money[1] > 99) {
			money[0] = money[0] + 1;
			money[1] = money[1] - 100;
		}

		return money;

	}

	public static int[] copyMoney(int[] money) {
		int copy[] = new int[2];
		for (int i = 0; i < money.length; i++) {
			copy[i] = money[i];
		}
		return copy;
	}

	public static int dollars(int[] money) {
		return money[0];
	}

	public static int cents(int[] money) {
		return money[1];
	}

	public static String moneyToString(int[] money) {
		int dollars = money[0];
		int cents = money[1];

		if (cents < 10)
			return "$" + dollars + ".0" + cents;
		return "$" + dollars + "." + cents;
	}

	public static String moneyToText(int[] money) {
		String words = "";
		String number = Integer.toString(money[0]);
		int length = number.length();
		int hundredsDigit = money[0] / 100;
		int tensDigit = money[0] / 10 % 10;
		int onesDigit = money[0] % 10;
		if (length == 3 && tensDigit == 1)
			words += numberInWords(hundredsDigit) + "hundred and " + numberInWords2(tensDigit, onesDigit) + "dollars";
		else if (length == 3 && tensDigit != 1)
			words += numberInWords(hundredsDigit) + "hundred and " + numberInWords2(tensDigit, onesDigit)
					+ numberInWords(onesDigit) + "dollars";
		else if (length == 2 && tensDigit == 1)
			words += numberInWords2(tensDigit, onesDigit) + "dollars";
		else if (length == 2 && tensDigit != 1)
			words += numberInWords2(tensDigit, onesDigit) + " " + numberInWords(onesDigit) + "dollars";
		else if (length == 1)
			words += numberInWords(onesDigit) + "dollars";

		// String number2 = Integer.toString(money[0]);
		// int length2 = number2.length();

		if (length > 0 && money[1] != 0) {
			words += " and ";
		}

		int tensDigit2 = money[1] / 10 % 10;
		int onesDigit2 = money[1] % 10;
		if (tensDigit2 == 1)
			words += numberInWords2(tensDigit2, onesDigit2) + "cents";
		else if (tensDigit2 != 0 && tensDigit2 != 1)
			words += numberInWords2(tensDigit2, onesDigit2) + numberInWords(onesDigit2) + "cents";
		else if (tensDigit2 == 0)
			words += numberInWords(onesDigit2) + "cents";

		return words;
	}

	public static String numberInWords(int num) {
		if (num == 1)
			return "one ";
		if (num == 2)
			return "two ";
		if (num == 3)
			return "three ";
		if (num == 4)
			return "four ";
		if (num == 5)
			return "five ";
		if (num == 6)
			return "six ";
		if (num == 7)
			return "seven ";
		if (num == 8)
			return "eight ";
		if (num == 0)
			return "";
		else
			return "nine ";
	}

	public static String numberInWords2(int num1, int num2) {
		if (num1 == 0)
			return "";
		if (num1 == 1) {
			if (num2 == 0)
				return "ten ";
			if (num2 == 1)
				return "eleven ";
			if (num2 == 2)
				return "twelve ";
			if (num2 == 3)
				return "thirteen ";
			if (num2 == 4)
				return "fourteen ";
			if (num2 == 5)
				return "fifteen ";
			if (num2 == 6)
				return "sixteen ";
			if (num2 == 7)
				return "seventeen ";
			if (num2 == 8)
				return "eighteen ";
			if (num2 == 9)
				return "nineteen ";
		}
		if (num1 == 2)
			return "twenty ";
		if (num1 == 3)
			return "thirty ";
		if (num1 == 4)
			return "fourty ";
		if (num1 == 5)
			return "fifty ";
		if (num1 == 6)
			return "sixty ";
		if (num1 == 7)
			return "seventy ";
		if (num1 == 8)
			return "eighty ";
		else
			return "ninety ";

	}

	public static boolean isGreaterThan(int[] m1, int[] m2) {
		int d1 = m1[0];
		int c1 = m1[1];
		int d2 = m2[0];
		int c2 = m2[1];

		if (d1 > d2)
			return true;
		else if (d1 < d2)
			return false;
		else {
			if (c1 > c2)
				return true;
			else
				return false;
		}
	}

	public static boolean isEqual(int[] m1, int[] m2) {
		int d1 = m1[0];
		int c1 = m1[1];
		int d2 = m2[0];
		int c2 = m2[1];

		if (d1 == d2 && c1 == c2)
			return true;
		return false;

	}

	public static void adder(int[] m1, int[] m2) {
		int d1 = m1[0];
		int c1 = m1[1];
		int d2 = m2[0];
		int c2 = m2[1];

		int d = 0;
		int c = 0;

		d = d1 + d2;
		c = c1 + c2;

		while (c >= 100) {
			c -= 100;
			d++;
		}

		m1[0] = d;
		m1[1] = c;

		System.out.println(moneyToString(m1));
	}

	public static int[] add(int[] m1, int[] m2) {
		int d1 = m1[0];
		int c1 = m1[1];
		int d2 = m2[0];
		int c2 = m2[1];

		int[] money = new int[2];

		int d = 0;
		int c = 0;

		d = d1 + d2;
		c = c1 + c2;

		while (c >= 100) {
			c -= 100;
			d++;
		}

		money[0] = d;
		money[1] = c;

		System.out.println(moneyToString(money));
		return money;
	}

	public static void subber(int[] m1, int[] m2) {
		int d1 = m1[0];
		int c1 = m1[1];
		int d2 = m2[0];
		int c2 = m2[1];

		int d = 0;
		int c = 0;

		if (c2 > c1) {
			c1 += 100;
			d1--;
		}

		d = d1 - d2;
		c = c1 - c2;

		m1[0] = d;
		m1[1] = c;

		System.out.println(moneyToString(m1));
	}

	public static int[] sub(int[] m1, int[] m2) {
		int d1 = m1[0];
		int c1 = m1[1];
		int d2 = m2[0];
		int c2 = m2[1];

		int d = 0;
		int c = 0;

		int[] money = new int[2];

		if (c2 > c1) {
			c1 += 100;
			d1--;
		}

		d = d1 - d2;
		c = c1 - c2;

		money[0] = d;
		money[1] = c;

		System.out.println(moneyToString(money));
		return money;
	}

	public static int[] payWith20(int[] owe) {
		int[] money = new int[2];

		if (owe[1] != 0) {
			money[0] = 19 - owe[0];
			money[1] = 100 - owe[1];
		} else {
			money[0] = 20 - owe[0];
			money[1] = owe[1];
		}

		System.out.println(moneyToString(money));
		return money;
	}
	
	public static int[] applyInterest(int[] balance, int interest) {
		int storage = 0;
		int interestAmount = 0;//in cents
		storage = balance[0] * 100 + balance[1];
		interestAmount = (storage*interest)/100;//16 cents
		storage += interestAmount;
		balance[0] = storage/100;
		balance[1] = storage % 100;
		return balance;
	}

}
