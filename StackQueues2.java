
public class StackQueues2 {
	public static void main(String[] args) {
		int[] myS = createStack();
		System.out.println(prettyPrintStack(myS));
		// System.out.println(dumpStack(myS));
		push(myS, 5);
		System.out.println(prettyPrintStack(myS));
		push(myS, 6);
		System.out.println(prettyPrintStack(myS));
		int popValue = pop(myS);
		System.out.println(popValue);
		popValue = pop(myS);
		System.out.println(popValue);
		popValue = pop(myS);
		// System.out.println(dumpStack(myS));
		
		System.out.println("\nTask 2 stack:");
		int[] myS2 = createStack();
		for (int i = 9; i > 2; i--) {
			push(myS2, i);
		}
		System.out.println(dumpStack(myS2));
		for (int i = 0; i < 3; i++) {
			pop(myS2);
		}
		System.out.println(dumpStack(myS2));
		for (int i = 1; i < 5; i++) {
			push(myS2, i);
		}
		System.out.println(dumpStack(myS2));
		for (int i = 0; i < 5; i++) {
			pop(myS2);
		}
		System.out.println("Print stack: " + prettyPrintStack(myS2));
		
		// task 3
		System.out.println("\nTask 3:");
		int[] shares = createStack();
		int[] prices = createStack();
		buyFILO(shares, prices, 100, 200);
		buyFILO(shares, prices, 50, 210);

		printReportFILO(shares, prices);
		System.out.println(runReportFILO(shares, prices));

		System.out.println("averageFILO/avg price per share in cents: " + averageFILO(shares, prices));
		System.out.println("sellFILO/profit in cents: " + sellFILO(shares, prices, 100, 220));

		printReportFILO(shares, prices);
		System.out.println(runReportFILO(shares, prices));

		//task5(tests task4)
		System.out.println("\nTask 5 queue:");
		int[] myQ = createQueue();
		for (int i = 9; i > 2; i--) {
			enqueue(myQ, i);
		}
		System.out.println(dumpQueue(myQ));
		for (int i = 0; i < 3; i++) {
			dequeue(myQ);
		}
		System.out.println(dumpQueue(myQ));
		for (int i = 1; i < 5; i++) {
			enqueue(myQ, i);
		}
		System.out.println(dumpQueue(myQ));
		for (int i = 0; i < 5; i++) {
			dequeue(myQ);
		}
		System.out.print("Print queue: " + prettyPrintQueue(myQ));
		
		//task 6
		int[] e = { 1, 2, 3, 4 };
		int[] f = { 2, 5, 6, 7 };
		int[] g = merge(e, f);
		for(int i = 0; i < g.length; i++) {
			System.out.print(g[i] + " ");
		}
	}

	public static int[] createStack() {
		int[] myS = new int[101];
		myS[0] = 0;

		for (int i = 1; i < 101; i++) {
			myS[i] = 0;
		}
		return myS;
	}

	public static void push(int[] stack, int data) {
		if (stack == null)
			System.out.println(stack);
		else {
			// System.out.println(stack[0]);
			if (stack[0] < 100) {
				stack[0]++;
				stack[stack[0]] = data;
			} else
				System.out.println("No more space available");
		}
	}

	public static int pop(int[] stack) {
		int rv = 0;
		if (stack == null) {
			System.out.println(stack);
		} else {
			if (stack[0] != 0) {
				rv = stack[stack[0]];
				System.out.println(rv);
				stack[0]--;
			} else
				System.out.println("No value to pop.");
		}
		return rv;
	}

	public static String prettyPrintStack(int[] stack) {
		String rv = "";
		if (stack[0] != 0) {
			rv += "[";

			for (int i = 1; i <= stack[0] - 1; i++) {
				rv += stack[i] + ",";
			}

			rv += stack[stack[0]] + "]";
			return rv;
		}
		else {
			rv = "[]";
			return rv;
		}
	}

	public static String dumpStack(int[] stack) {
		String rv = "{";
		for (int i = 0; i < stack.length - 1; i++) {
			rv += stack[i] + ", ";
		}
		rv += stack[100] + "}";
		return rv;
	}

	public static void printReportFILO(int[] shares, int[] price) {
		System.out.println("Shares\t\tPrice");
		for (int i = 1; i <= shares[0]; i++)
			System.out.println(shares[i] + "\t\t$" + price[i]/100 + ".00");
	}

	public static String runReportFILO(int[] shares, int[] price) {
		String rv = "";
		rv += "Shares\t\tPrice\n";
		for (int i = 1; i <= shares[0]; i++)
			rv += shares[i] + "\t\t$" + price[i]/100 + ".00\n";
		return rv;
	}

	public static void buyFILO(int[] shares, int[] price, int numShares, int pricePerShare) {
		push(shares, numShares);
		push(price, pricePerShare * 100);
	}

	public static int sellFILO(int[] shares, int[] price, int numShares, int pricePerShare) {
		//keep average as a decimal, do not round it
		double average = 0;
		double sum = 0;
		int averageNumShares = 0;
		for (int i = 1; i <= shares[0]; i++) {
			sum += shares[i] * price[i];
			averageNumShares += shares[i];
		}
		average = sum / averageNumShares;
		System.out.println("average: " + average);
		
		int cost = (int)(average * numShares);//2033333 instead of 2033300, more accurate
		System.out.println("Cost: " + cost);
		int sell = numShares * pricePerShare*100;
		System.out.println("Sell: " + sell);
		return sell - cost;//166667 instead of 166700, more accurate
	}

	public static int averageFILO(int[] shares, int[] price) {
		int average = 0;
		int sum = 0;
		int numShares = 0;
		int remainderBoost = 0;
		for (int i = 1; i <= shares[0]; i++) {
			sum += shares[i] * price[i];
			numShares += shares[i];
		}
		//System.out.println((sum*10 / numShares) % 3);
		if(((sum*10 / numShares) % 10) >= 5) {
			remainderBoost = 1;
		}
		average = sum / numShares + remainderBoost;
		return average;
	}

	// task 4

	public static int[] createQueue() {
		int[] myQ = new int[101];
		myQ[0] = 0;

		for (int i = 1; i < 101; i++) {
			myQ[i] = 0;
		}
		return myQ;
	}

	public static void enqueue(int[] queue, int data) {
		if (queue == null)
			System.out.println(queue);
		else {
			if (queue[0] < 100) {
				queue[0]++;
				queue[queue[0]] = data;
			} else
				System.out.println("No more space available");
		}
	}

	public static int dequeue(int[] queue) {
		int rv = 0;
		if (queue == null) {
			System.out.println(queue);
		} else {
			if (queue[0] != 0) {
				rv = queue[1];
				System.out.println(rv);
				queue[0]--;
				for (int i = 1; i <= queue[0]; i++) {// remember i=0 is the # of elements
					queue[i] = queue[i + 1];
				}
			} else
				System.out.println("No value to dequeue.");
		}
		return rv;
	}

	public static String prettyPrintQueue(int[] queue) {
		String rv = "[";

		for (int i = 1; i <= queue[0] - 1; i++) {
			rv += queue[i] + ",";
		}

		rv += queue[queue[0]] + "]";
		return rv;
	}

	public static String dumpQueue(int[] queue) {
		String rv = "{";
		for (int i = 0; i < queue.length - 1; i++) {
			rv += queue[i] + ", ";
		}
		rv += queue[100] + "}";
		return rv;
	}

	// task 6

	public static int[] merge(int[] a, int[] b) {
		int[] rv = new int[a.length + b.length];
		int[] qA = createQueue();
		int[] qB = createQueue();
		for (int i = 0; i < a.length; i++) {
			enqueue(qA, a[i]);
		}
		for (int i = 0; i < b.length; i++) {
			enqueue(qB, b[i]);
		}
		for (int i = 0; i < rv.length; i++) {
			if (qA[1] < qB[1])
				rv[i] = dequeue(qA);
			else
				rv[i] = dequeue(qB);
			if (qA[0] == 0) {
				for (int j = i + 1; j < rv.length; j++) {
					rv[j] = dequeue(qB);
				}
				break;
			} else if (qB[0] == 0) {
				for (int j = i + 1; j < rv.length; j++) {
					rv[j] = dequeue(qA);
				}
				break;
			}
		}
		return rv;
	}

}
