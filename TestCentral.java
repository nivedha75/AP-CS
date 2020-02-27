class Test {
	static int points = 10;
	static int neg = -4;
	int version;
	public static void versionChange(Test testEx) {
		testEx.version++;
	}
}

public class TestCentral{
	public static void main(String[] args) {
		System.out.println(Test.points);
		Test t = new Test();
		Test s = t;
		s.version = s.version++ + ++ s.version; //0+1?
		s.version = s.version;
		System.out.println(s.version);
		//int[] a = {0, null};
		//a[1] = null;
		Test.versionChange(t);
		System.out.println(t.version);
		System.out.println(Test.neg);
		Circle c1 = new Circle();
		System.out.println(c1.areaOfCircle(c1));
		Circle2 c2 = new Circle2(2);
		Circle2 c3 = new Circle2(6);
		Circle2.addRadius(c2, c3);
	}
}
class Circle{
	int area = 7;
	public double areaOfCircle(Circle c) {
		return c.area;
	}
	private int radius = 5;
	public int getRadius() {
		return radius;
	}
	
	public static void printFunction() {
		System.out.println(getRadius());
	}
}

class Circle2{
	int radius;
	public Circle2(int radius) {
		this.radius = radius;
	}
	public static void addRadius(Circle2 c1, Circle2 c2) {
		System.out.println(c2.radius+c2.radius);
	}
	
	
}
