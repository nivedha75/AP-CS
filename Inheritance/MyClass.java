package Inheritance;

import java.util.ArrayList;

public class MyClass { 
  public static void main(String[] args) { 
    ArrayList<String> cars = new ArrayList<String>();
    cars.add("Volvo");
    cars.add("BMW");
    cars.add("Ford");
    cars.add("Mazda");
    System.out.println(cars);
    cars.add(2, "Mercedes");
    System.out.println(cars);
    System.out.println(cars.remove(1).getClass() == String);
    System.out.println(cars);
    System.out.println("here:" + cars.toString());
    ArrayList<Integer> a = new ArrayList<Integer>();
    //a.add(2.0);
  } 
}