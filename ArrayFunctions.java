public class ArrayFunctions {
	public static void main(String[] args) {
		System.out.println(min(4, 3));
		int[] ex = new int[3];
		ex[0] = 3;
		ex[1] = 5;
		ex[2] = 1;
		System.out.println(min(ex));
		int[] a = new int[2];
		a[0] = 1;
		a[1] = 2;
		add(a, ex);// 4, 7, 1
		int[] b = { 2, 5, 4, 5 };
		System.out.println(mode(b));
		System.out.println(prettyPrint(b));
		copy(b);
		resize(b, 8);
		append(ex, b);
		remove(b, 1);
		System.out.println("\n\n\n");
		int[] s = { 10, 9, 8, 5, 6, 2};
		subArray(s, 1, 6);
		sort(s);
		System.out.print("10, 9, 8, 5, 6, 2: ");
		makeSorted(s);
		int[] e = { 1, 2, 3, 4 };
		int[] f = { 2, 5, 6, 7 };
		merge(e, f);
	}

	public static int min(int a, int b) {
		if (a <= b)
			return a;
		else
			return b;
	}

	public static int min(int[] a) {
		if (a == null)
			return 0;
		int rv = a[0];
		for (int i = 0; i < a.length; i++) {
			if (a[i] < rv)
				rv = a[i];
		}
		return rv;
	}

	public static int[] add(int[] a, int[] b) {
		if (a == null || b == null)
			return null;
		int[] rv = new int[a.length + b.length - min(a.length, b.length)];
		for (int i = 0; i < min(a.length, b.length); i++) {
			rv[i] = a[i] + b[i];
			System.out.println(rv[i]);
		}
		if (a.length > b.length)
			for (int i = b.length; i < a.length; i++) {
				rv[i] = a[i];
				System.out.println(rv[i]);
			}
		else
			for (int i = a.length; i < b.length; i++) {
				rv[i] = b[i];
				System.out.println(rv[i]);
			}
		return rv;
	}

	public static int mode(int[] a) {
		if (a == null)
			return 0;
		int mode = 0;
		int numOccurences = 0;
		for (int i = 0; i < a.length; i++) {
			int num = a[i];
			if (num == mode)
				continue;
			int count = 0;
			for (int j = 0; j < a.length; j++) {
				if (a[j] == a[i])
					count++;
			}
			if (count > numOccurences) {
				numOccurences = count;
				mode = num;
			}
		}
		return mode;
	}

	public static String prettyPrint(int[] a) {
		if (a == null)
			return "{}";
		String prettyString = "{";
		for (int i = 0; i < a.length; i++) {
			prettyString += a[i];
			if (i != a.length - 1)
				prettyString += ",";
		}
		prettyString += "}";
		return prettyString;
	}

	public static int[] copy(int[] a) {
		if (a == null)
			return null;
		int[] rv = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			rv[i] = a[i];
		}
		System.out.println("Copy Method: " + prettyPrint(a));
		return rv;
	}

	public static int[] resize(int[] a, int newLength) {
		if (a == null)
			return null;
		int[] resized = new int[newLength];
		for (int i = 0; i < newLength; i++) {
			if (i < a.length)
				resized[i] = a[i];
			else
				resized[i] = 0;
		}
		System.out.println(prettyPrint(resized));
		return resized;
	}

	public static int[] append(int[] a, int[] b) {
		if (a == null)
			return b;
		if (b == null)
			return a;
		int[] combined = new int[a.length + b.length];
		for (int i = 0; i < a.length; i++) {
			combined[i] = a[i];
		}
		for (int i = a.length; i < combined.length; i++) {
			combined[i] = b[i - a.length];
		}

		System.out.println(prettyPrint(combined));
		return combined;
	}

	public static int[] remove(int[] a, int index) {
		if (a == null)
			return null;
		int[] newArray = new int[a.length - 1];
		for (int i = 0; i < index; i++) {
			newArray[i] = a[i];
		}
		for (int i = index; i < newArray.length; i++) {
			newArray[i] = a[i + 1];
		}
		System.out.println(prettyPrint(newArray));
		return newArray;
	}

	public static int[] subArray(int[] a, int firstIncluded, int firstExcluded) {
		if (firstExcluded <= firstIncluded || a == null || firstIncluded > a.length || firstExcluded > a.length) {
			System.out.println(-1);
			return null;
		}
		int[] sub = new int[firstExcluded - firstIncluded];
		for (int i = firstIncluded; i < firstExcluded; i++) {
			sub[i - firstIncluded] = a[i];
		}
		System.out.println(prettyPrint(sub));
		return sub;
	}

	public static void makeSorted(int[] a) {
		if (a == null) {
			System.out.println(-1);
		} else {
			int storage = 0;
			for (int i = 0; i < a.length - 1; i++) {
				for (int j = 0; j < a.length - 1 - i; j++) {
					if (a[j] > a[j + 1]) {
						storage = a[j];
						a[j] = a[j + 1];
						a[j + 1] = storage;
					}
				}
			}
			System.out.println(prettyPrint(a));
		}
	}

	public static int[] sort(int a[]) {
		if (a == null)
			return null;
		int[] b = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			b[i] = a[i];
		}
		int storage = 0;
		for (int i = 0; i < b.length - 1; i++) {
			for (int j = 0; j < b.length - 1 - i; j++) {
				if (b[j] > b[j + 1]) {
					storage = b[j];
					b[j] = b[j + 1];
					b[j + 1] = storage;
				}
			}
		}
		System.out.println("\nchanged:" + prettyPrint(b));
		System.out.println(prettyPrint(a));
		return b;
	}

	public static int[] merge(int[] a, int[] b) {
		if (a == null || b == null)
			return null;
		int[] c = new int[a.length + b.length];
		int aNum = 0, bNum = 0;
		for (int i = 0; i < c.length; i++) {
			if (a[aNum] <= b[bNum]) {
				c[i] = a[aNum];
				aNum++;
			} else {
				c[i] = b[bNum];
				bNum++;
			}
			if (aNum == a.length) {
				for (int j = i + 1; j < c.length; j++) {
					c[j] = b[bNum];
					bNum++;
				}
				break;
			}
			if (bNum == b.length) {
				for (int j = i + 1; j < c.length; j++) {
					c[j] = a[aNum];
					aNum++;
				}
				break;
			}
		}
		System.out.println(prettyPrint(c));
		return c;
	}

}
