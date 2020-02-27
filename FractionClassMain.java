
public class FractionClassMain {
	public static void main(String[] args) {
		for (int i = 1; i <= 90; i++) {
			System.out.println(new FractionClass(1, i));
		}
		FractionClass f = new FractionClass(26, 3);
		FractionClass g = new FractionClass(4, 0);
		FractionClass h = new FractionClass(3, -7);
		System.out.println("8 2/3:\t" + f.toMixedNumber());
		System.out.println("8:\t" + f.integerPart());
		System.out.println("2:\t" + f.remainder());
		System.out.println("true:\t" + g.isError());
		System.out.println("false:\t" + h.isPositive());
		System.out.println("26/3:\t" + FractionClass.max(f, h).toString());
		System.out.println();
		FractionClass[] j = FractionClass.quadraticFormula(new FractionClass(2, 1), new FractionClass(3, 1),
				new FractionClass(1, 1));
		for (int i = 0; i < j.length; i++) {
			System.out.println(j[i]);
		}
		System.out.println();
		FractionClass[] k = FractionClass.quadraticFormula(new FractionClass(4, 1), new FractionClass(0, 1),
				new FractionClass(-9, 1));
		for (int i = 0; i < k.length; i++) {
			System.out.println(k[i]);
		}
		System.out.println();
		FractionClass[] l = FractionClass.quadraticFormula(new FractionClass(1, 1), new FractionClass(0, 1),
				new FractionClass(1, 1));
		if (l == null) {
			System.out.println("null");
		} else {
			for (int i = 0; i < l.length; i++) {
				System.out.println(l[i]);
			}
		}
	}
}
