package Inheritance;

public class Test {
	public static void main(String[] args) {
		int count = 0;
		int length;
		for(int i = 0; i < 5; i++) 
			if(i == 4) 
				count = 5;
			else
				System.out.println(5);// in for loop
		System.out.println(count);
		
		A a = new A();
		A.method1(a);
	}
}

class A{
	private int x;
	public A() {
		x = 17888888;
	}
	public static void method1(A a) {
		System.out.println(a.x);//or is getX() necessary? ANSWER: NO
	}
}
