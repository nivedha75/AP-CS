/*How the compareTo method of Strings works:
 * The compareTo method of Strings compares two Strings. If the first letter of the first String entered is later in the alphabet
 * than the first letter of the second String entered then the method returns a positive int. If the first letter of the 
 * first String is before the first letter of the second String in the alphabet then the method returns a negative int. If
 * they are the same letter, then the method returns 0. It is also important to note that the method is case-sensitive.
 * This method can be very helpful in comparing Strings like names and are generally very helpful as part of conditionals.*/

package Inheritance;

import java.util.ArrayList;
import java.util.Scanner;

class AStack {
	private ArrayList<String> data;

	public AStack() {
		data = new ArrayList<String>();
	}

	public ArrayList<String> getData() {
		return data;
	}
	
	public int size() {
		return data.size();
	}

	public void push(String s) {
		data.add(s);
	}

	public String pop() {
		String s = data.get(data.size() - 1);
		data.remove(data.size() - 1);
		return s;
	}

	public String toString() {
		String s = "";
		for (String str : data) {
			s += str + " ";
		}
		return s;
	}
}

class AQueue {
	private ArrayList<String> data;

	public AQueue() {
		data = new ArrayList<String>();
	}

	public ArrayList<String> getData() {
		return data;
	}
	
	public int size() {
		return data.size();
	}

	public void enqueue(String s) {
		data.add(s);
	}

	public String dequeue() {
		String s = data.get(0);
		data.remove(0);
		return s;
	}

	public String toString() {
		String s = "";
		for (String str : data) {
			s += str + " ";
		}
		return s;
	}

	public void bubbleSort() {
		for (int i = 0; i < data.size() - 1; i++) {
			for (int j = 0; j < data.size() - i - 1; j++) {
				if (data.get(j).compareTo(data.get(j + 1)) > 0) {
					String storage = data.get(j);
					data.set(j, data.get(j + 1));
					data.set(j + 1, storage);
				}
			}
		}
	}
}

public class StacksQueuesArrayListMain {
	public static void main(String[] args) {
		AStack stack = new AStack();
		AQueue queue = new AQueue();
		stack.push("Chelsea");
		stack.push("Mahek");
		stack.push("Sahithya");
		stack.push("Ishya");
		stack.push("Nivedha");
		stack.push("Shivani");
		int lengthOfData = stack.size();
		for (int i = 0; i < lengthOfData; i++) {
			if(i == 0)
				System.out.println(stack);
			stack.pop();
			System.out.println(stack);
		}
		System.out.println(stack);
		// menu
		boolean loopback = true;
		while (loopback) {
			Scanner s = new Scanner(System.in);
			System.out.println("1. Add person to queue");
			System.out.println("2. Remove person from queue");
			System.out.println("3. Print queue");
			System.out.println("4. Bubble sort");
			System.out.println("9. Exit");
			int choice = s.nextInt();
			if (choice == 1) {
				Scanner p = new Scanner(System.in);
				System.out.println("What is the name of the person you want to add?");
				String person = p.nextLine();
				queue.enqueue(person);
				System.out.println(queue);
			} else if (choice == 2) {
				queue.dequeue();
				System.out.println(queue);
			} else if (choice == 3) {
				System.out.println(queue);
			} else if (choice == 4) {
				queue.bubbleSort();
				System.out.println(queue);
			} else {
				System.out.println("You have exited the program");
				loopback = false;
			}
		}
	}
}
