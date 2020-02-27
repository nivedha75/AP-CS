package Inheritance;
//to calculate sqrt that returns a double
import java.lang.Math;

public class Vehicle{
    private int numOfSeats;
    private int curNumOfPas;
    Point curPos;
    Point destination;
    private int topSpeed;
  
    public Vehicle(){
        numOfSeats = 0;
        curNumOfPas = 0;
        curPos = new Point(0, 0);
        destination = new Point(0, 0);
        destination.setX(0);
        destination.setY(0);
        topSpeed = 0;
    }
    public Vehicle(int numOfSeats, int curNumOfPas, double curPosX, double curPosY, double destinationX, double destinationY, int topSpeed){
    	this.numOfSeats = numOfSeats;
        this.curNumOfPas = curNumOfPas;
        curPos = new Point(curPosX, curPosY);
        destination = new Point(destinationX, destinationY);
        this.topSpeed = topSpeed;
    }
    
    public int getNumOfSeats() {
    	return numOfSeats;
    }
    public void setNumOfSeats(int seats) {
    	numOfSeats = seats;
    }
    public int getCurNumOfPas() {
    	return curNumOfPas;
    }
    public void setCurNumOfPas(int passengers) {
    	curNumOfPas = passengers;
    }
    public int getTopSpeed() {
    	return topSpeed;
    }
    public void setTopSpeed(int speed) {
    	topSpeed = speed;
    }
    
    public String communicate(){
        return "Hey you!";
    }
    public String toString(){ //gave an error w/ static
        return "This is a vehicle";
    }
    public int speedCompareTo(Vehicle v) {
    	return topSpeed - v.topSpeed;
    }
    public int speedCompareTo(Car c) {
    	return topSpeed - c.getTopSpeed();
    }
    public int speedCompareTo(Airplane a) {
    	return topSpeed - a.getTopSpeed();
    }
    public int distanceTo(Vehicle v) {
    	return this.distanceTo(v);
    }
    
    /*Answer to questions:
     I do not need to create these methods in Car, Airplane, and Train classes because those classes inherit everything,
     including these methods from Vehicle class. We need these 4 arguments here, however, because are not just comparing always
     to Vehicle object: we can compare to Vehicle object, Car object, Airplane object, and Train object. The Car object,
     Airplane object, and Train object have more content than Vehicle object and thus even though they are considered vehicles,
     they are not vehicle objects and cannot be passed in as an argument of public int speedCompareTo(Vehicle v) This cannot work
     the other way around because parent classes do not have access to subclass data and behaviors*/
    
    public static void main(String[] args) {
    	Car c = new Car();
    	c.setTopSpeed(180);
    	System.out.println(c.getTopSpeed());
    }
}

class Point{
    private double x;
    private double y;
    
    public Point() {
    	x = 0;
    	y = 0;
    }
    public Point(double x, double y) {
    	this.x = x;
    	this.y = y;
    }
    
    public void setX(double x){
        x = 0;
    }
    public double getX(){
        return x;
    }
    public void setY(double y){
        y = 0;
    }
    public double getY(){
        return y;
    }
    
    public String toString(){
        return "(" + x + "," + y + ")";
    }
    public double distance(Point p){
        double horDistance = p.x-x;
        double verDistance = p.y-y;
        //returns the square root as a double after taking a double distance value
        return Math.sqrt(horDistance*horDistance+verDistance*verDistance);
    }
}

class Airplane extends Vehicle{
    private String flightNum;
    
    public String getFlightNum() {
		return flightNum;
	}
	public void setFlightNum(String flightNum) {
		this.flightNum = flightNum;
	}
	
	public Airplane() {
    	super();
    	flightNum = "";
    }
    public Airplane(String flightNum, int numOfSeats, int curNumOfPas, double curPosX, double curPosY, double destinationX, double destinationY, int topSpeed) {
    	super(numOfSeats, curNumOfPas, curPosX, curPosY, destinationX, destinationY, topSpeed);
    	this.flightNum = flightNum;
    }
    
    public String communicate(){
        return "Tower, this is flight " + flightNum;
    }
}

class Car extends Vehicle{
	private int numOfDoors;
	private String engineType;
	
	public Car() {
		super();
		numOfDoors = 0;
		engineType = "";
	}
	public Car(int numOfDoors, String engineType, int numOfSeats, int curNumOfPas, double curPosX, double curPosY, double destinationX, double destinationY, int topSpeed) {
		super(numOfSeats, curNumOfPas, curPosX, curPosY, destinationX, destinationY, topSpeed);
		this.numOfDoors = numOfDoors;
		this.engineType = engineType;
	}
	
	public int getNumOfDoors() {
		return numOfDoors;
	}
	public void setNumOfDoors(int numOfDoors) {
		this.numOfDoors = numOfDoors;
	}
	public String getEngineType() {
		return engineType;
	}
	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}
	
	public String communicate(double a, int b) {
		return "Honk Honk!";
	}
	public String toString() {
		return "This is a " + engineType + "car with " + numOfDoors+ " doors.";
	}
	
}
class Train extends Vehicle{
	private int numOfBoxCars;
	
	public Train() {
		super();
		numOfBoxCars = 0;
	}
	public Train(int numOfBoxCars, int numOfSeats, int curNumOfPas, double curPosX, double curPosY, double destinationX, double destinationY, int topSpeed) {
		super(numOfSeats, curNumOfPas, curPosX, curPosY, destinationX, destinationY, topSpeed);
		this.numOfBoxCars = numOfBoxCars;
	}
	
	public int getNumOfBoxCars() {
		return numOfBoxCars;
	}
	public void setNumOfBoxCars(int numOfBoxCars) {
		this.numOfBoxCars = numOfBoxCars;
	}
	
	public String communicate() {
		return  "I think I can, I think I can!";
	}
	public String toString() {
		return "This is a train, all aboard!";
	}
}


