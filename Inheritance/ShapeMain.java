package Inheritance;

import java.util.Scanner;
import java.lang.Class;

abstract class Shape {
	private final int NUMBER_OF_SIDES;

	public Shape() {
		NUMBER_OF_SIDES = 0;
	}

	public Shape(int x) {
		NUMBER_OF_SIDES = x;
	}

	public int getNumOfSides() {
		return NUMBER_OF_SIDES;
	}

	public abstract double area() {
		//return 0;
	}

	public abstract double perimeter() {
		//return 0;
	}
}

class Circle extends Shape {
	private double radius;
	private Point center;

	public Circle() {
		super(1);
	}

	public Circle(double r, double x, double y) {
		// this.setNumOfSides(1);
		super(1);
		radius = r;
		center = new Point(x, y);
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double r) {
		radius = r;
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public String toStr() {
		return "Circle with 1 side, radius = " + radius + " and center = " + center.toString();
	}

	// override
	public double area() {
		return 3.14 * radius * radius;
	}

	public double perimeter() {
		return 2 * 3.14 * radius;
	}
}

class Triangle extends Shape {
	private double a;
	private double b;
	private double c;
	private double base;
	private double height;

	public Triangle() {
		super(3);
	}

	public Triangle(double a, double b, double c, double base, double height) {
		super(3);
		this.a = a;
		this.b = b;
		this.c = c;
		this.base = base;
		this.height = height;
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public String toStr() {
		return "Triangle with 3 sides, side lengths = " + a + ", " + b + ", " + c + ", base = " + a + ", height = "
				+ height;
	}

	public double area() {
		return 0.5 * base * height;
	}

	public double perimeter() {
		return a + b + c;
	}
}

class Rectangle extends Shape {
	private double length;
	private double width;

	public Rectangle() {
		super(4);
	}

	public Rectangle(double l, double w) {
		super(4);
		length = l;
		width = w;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public String toStr() {
		return "Rectangle with 4 sides, length = " + length + " and width = " + width;
	}

	public double area() {
		return length * width;
	}

	public double perimeter() {
		return 2 * length + 2 * width;
	}
}

public class ShapeMain {
	public static void main(String[] args) {
		System.out.println("You are creating 3 shapes: \nLet's create each shape!");
		Shape[] shapes = new Shape[3];
		try {
		int counter = -1;
		while(counter < 2) {
			Scanner sides = new Scanner(System.in);
			System.out.println("Enter the number of sides of the shape: \n Choose 1(Circle), 3, or 4");
			int s = sides.nextInt();
			if (s == 1) {
				Scanner cParts = new Scanner(System.in);
				System.out.println("Enter center x value, center y value, and radius: ");
				System.out.println("Ex. for center(1, 2) and radius 5:\n1\n2\n5");
				double cX = cParts.nextDouble();
				double cY = cParts.nextDouble();
				double radius = cParts.nextDouble();
				Circle c = new Circle(radius, cX, cY);
				counter++;
				shapes[counter] = c;
			} else if (s == 3) {
				Scanner tParts = new Scanner(System.in);
				System.out.println("Enter side lengths a, b, and c and then the base and the height");
				System.out.println("Ex. for a = 3; b = 4, c = 5, base = 3; height = 4:");
				System.out.println("3\n4\n5\n3\n4");
				double a = tParts.nextDouble();
				double b = tParts.nextDouble();
				double c = tParts.nextDouble();
				double base = tParts.nextDouble();
				double height = tParts.nextDouble();
				Triangle t = new Triangle(a, b, c, base, height);
				counter++;
				shapes[counter] = t;
			} else {
				Scanner rParts = new Scanner(System.in);
				System.out.println("Enter length and width: ");
				System.out.println("Ex. for length = 10 and width = 8:\n10\n8");
				double length = rParts.nextDouble();
				double width = rParts.nextDouble();
				Rectangle r = new Rectangle(length, width);
				counter++;
				shapes[counter] = r;
			}
		}
		
		}catch(Exception e) {
			System.out.println("You entered invalid data...");
			System.out.println("Starting program again...");
		}
		
		/*the conflict: s[0] and other items in the array cannot access toStr() by doing s[0].toStr()
		 since it is not a function in Shape(even though they are Circle, Triangle, or Rectangle objects 
		 in a Shape array).
		 
		 the resolution: cast the s[0] to a Circle, Triangle, or Rectangle and then call toStr() on that
		 
		 This concept is applied on the code below:
		 */
		for(int i = 0; i < 3; i++) {
			if(shapes[i] instanceof Circle) {
				System.out.println("toStr(): " + ((Circle)shapes[i]).toStr());
			}else if(shapes[i] instanceof Triangle) {
				System.out.println("toStr(): " + ((Triangle)shapes[i]).toStr());
			}else {
				System.out.println("toStr(): " + ((Rectangle)shapes[i]).toStr());
			}
			System.out.println("area: " + shapes[i].area());
			System.out.println("perimeter: " + shapes[i].perimeter());
		}
		
	}
}
