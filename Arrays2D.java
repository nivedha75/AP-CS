public class Arrays2D {
	public static void main(String[] args) {
		int[] a = new int[3];
		a[0] = 1;
		a[1] = 2;
		a[2] = 3;
		System.out.println(arrayToString(a));
		int[][] b = new int[3][];
		int n = 1;
		System.out.println("Start");
		for (int i = 0; i < b.length; i++) {
			b[i] = new int[3 + i];
			for (int j = 0; j < b[i].length; j++) {
				b[i][j] = n;
				n++;
			}
		}
		int[][] c = { { 1, -1, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };
		System.out.println(arrayToString(b));
		System.out.println(ticTacToe(c));// returns true if tic tac toe
		int[][] d = { { 1, 2, 3 }, { 10, 20, 30 }, { 100, 200, 300 } };
		System.out.println(sum(d));
		System.out.println(sumMajor(d)); // 321
		System.out.println(sumMinor(d)); // 123
		int[] e = { 5, 4, 6, 9, 2, 3 };
		System.out.println(min(e));
		int[][] f = { { 6, 4, 30 }, { 5, 200, 300 }, { 30, 40, 1 } };
		System.out.println(min(f));
		System.out.println(min2(f));
		//System.out.println(arrayToString(rotate(d)));
		int[][] g = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println(arrayToString(rotate(g)));
		System.out.println(arrayToString(doubleArray(g)));
		pattern1();
		System.out.println();
		pattern2();
		System.out.println();
		pattern3();
		System.out.println(arrayToString(pascalsTriangle(7)));
	}

	public static String arrayToString(int[] a) {
		String array = "{";
		for (int i = 0; i < a.length - 1; i++) {
			array += a[i] + ",";
		}
		array += a[a.length - 1] + "}";
		return array;
	}

	public static String arrayToString(int[][] a) {
		String array = "{";
		for (int i = 0; i < a.length - 1; i++) {
			array += arrayToString(a[i]);
			array += ",\n ";
		}
		array += arrayToString(a[a.length - 1]) + "}";
		return array;
	}

	public static boolean ticTacToe(int[][] a) {
		for (int i = 0; i < a.length; i++)
			if ((a[i][0] == a[i][1]) && (a[i][1] == a[i][2]))
				return true;
		for (int i = 0; i < a.length; i++)
			if ((a[0][i] == a[1][i]) && (a[1][i] == a[2][i]))
				return true;
		if ((a[0][0] == a[1][1]) && (a[1][1] == a[2][2]))
			return true;
		if ((a[2][0] == a[1][1]) && (a[1][1] == a[0][2]))
			return true;
		return false;
	}

	public static int sum(int[][] a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				sum += a[i][j];
			}
		}
		return sum;
	}

	public static int sumMajor(int[][] a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i][i];
		}
		return sum;
	}

	public static int sumMinor(int[][] a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[a.length - i - 1][i];
		}
		return sum;
	}

	public static int min(int[] a) {
		int minValue = a[0];
		for (int i = 1; i < a.length; i++)
			if (a[i] < minValue) {
				minValue = a[i];
			}
		return minValue;
	}

	public static int min(int[][] a) {
		int minValue = min(a[0]);
		for (int i = 1; i < a.length; i++) {
			int minValueRow = min(a[i]);
			if (minValueRow < minValue)
				minValue = minValueRow;
		}
		return minValue;
	}

	public static int min2(int[][] a) {
		int minValue = a[0][0];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (a[i][j] < minValue) {
					minValue = a[i][j];
				}
			}
		}
		return minValue;
	}
	
	//the following rotates for a 3 by 3 array without creating any new arrays
	
	public static int[][] rotate(int[][] a){//take 7 4 1 in 3 by 3 then 8 5 2
		int storage1 = a[0][1];
		int storage2 = a[0][2];
		int storage3 = a[1][2];
		int storage4 = a[0][0];
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[i].length; j++) {
				a[i][j] = a[2-j][i];
			}
		}
		
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[i].length; j++) {
				if(i == 0 && j == 2)
					a[i][j] = storage4;
				else if(i == 1 && j == 2)
					a[i][j] = storage1;
				else if(i == 2 && j == 1)
					a[i][j] = storage3;
				else if(i == 2 && j == 2)
					a[i][j] = storage2;
			}
		}
		return a;
	}
	
	// the following rotate function CAN ROTATE RECTANGULAR ARRAYS and square arrays
	// but it creates a new array
	// instead of modifying original

	public static int[][] rotate2(int[][] a) {
		int n = a.length - 1;
		int m = 0;
		int[][] array = new int[a[0].length][a.length];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = a[n][m];
				if (n > 0) {
					n--;
				} else {
					m++;
					n = a.length - 1;
				}
			}
		}

		return array;
	}


	/*
	 * for (int r = 0; r < a.length; r++) { for (int s = 0; s < a[r].length; s++) {
	 * for (int i = a.length - 1; i >= 0; i--) { for (int j = 0; j < a[i].length;
	 * j++) { a[r][s] = a[i][j]; } } } }
	 */

	public static int[][] doubleArray(int[][] a) {
		int[][] array = new int[a.length * 2][a[0].length * 2];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (j % 2 == 0 && i % 2 == 0) {
					array[i][j] = a[i / 2][j / 2];
				} else if (j % 2 != 0 && i % 2 == 0) {
					array[i][j] = a[i / 2][(j - 1) / 2];
				} else if (j % 2 == 0 && i % 2 != 0) {
					array[i][j] = a[(i - 1) / 2][j / 2];
				} else {// j%2 != 0 && i%2 != 0
					array[i][j] = a[(i - 1) / 2][(j - 1) / 2];
				}
			}
		}
		return array;
	}

	public static void pattern1() {
		int[][] array = new int[5][];
		for (int i = 0; i < array.length; i++) {
			int count = 1;
			array[i] = new int[i+1];
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = count;
				count++;
			}
		}

		String rv = "";
		for (int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				rv += array[i][j] + " ";
			}
			if(i != array.length-1)
				rv += "\n";
		}
		System.out.println(rv);
	}

	public static void pattern2() {
		int[][] array = new int[5][];
		for (int i = 0; i < array.length; i++) {
			int count = 5 - i;
			array[i] = new int[count];
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = count;
				count--;
			}
		}

		String rv = "";
		for (int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				rv += array[i][j] + " ";
			}
			if(i != array.length-1)
				rv += "\n";
		}
		System.out.println(rv);
	}

	public static void pattern3() {
		int[][] array = new int[5][];
		for (int i = 0; i < array.length; i++) {
			int num = 5 - i;
			array[i] = new int[i+1];
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = num;
			}
		}

		String rv = "";
		for (int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				rv += array[i][j] + " ";
			}
			if(i != array.length-1)
				rv += "\n";
		}
		System.out.println(rv);
	}

	public static int[][] pascalsTriangle(int n) {
		int[][] triangle = new int[n][];
		for (int i = 0; i < n; i++) {
			triangle[i] = new int[i + 1];
			if (i == 0) {
				triangle[0][0] = 1;
			} else if (i == 1) {
				triangle[1][0] = 1;
				triangle[1][1] = 1;
			} else {
				triangle[i][0] = 1;
				for (int j = 1; j < triangle[i].length - 1; j++) {
					triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
				}
				triangle[i][triangle[i].length - 1] = 1;
			}
		}
		return triangle;
	}

}
