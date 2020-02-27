import Inheritance.Point;

class Money{
    public int d; //dollars
    public int c; //cents
    public double value;
    
    public Money(int d, int c) {
        while(c>=100){
            c-=100;
            d++;
        }    
        this.d = d;
        this.c = c;
    }
    
    public Money() {
        this.d = 0;
        this.c = 0;
    }
}

class Point{
    public double x;
    public double y;
    
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
}


public class Main {
    
    public static void main(String[] args) {
        
    }
    
    public static String moneyToString(Money m){
        return "$" + m.d + "." + m.c;
    }
    
    public static Money add(Money m1, Money m2){
        Money newMoney = new Money(m1.d + m2.d, m1.c + m2.c);
        return newMoney;
    }
    
    public static Money payWith20(Money m){
        Money change = new Money();
        if(m.c == 0){
            change.d = 20 - m.d;
            change.c = 0;
        }else{
            change.d = 19 - m.d;
            change.c = 100 - m.c;
        }
        return change;
    }
    
    public static Money applyInterest(Money m, double interestRate){
        double value = 100*(m.d*(interestRate/100 + 1)) + m.c*(interestRate/100 + 1);
        Money newMoney = new Money((int)(value), (int)(value % 100));
        return newMoney;
    }
    
    //point functions
    
    public static String pointToString(Point p){
        return "(" + p.x + "." + p.y + ")";
    }
    
    public static Point midpoint(Point p1, Point p2){
        Point midPoint = new Point((p1.x + p2.x)/2, (p1.y + p2.y)/2);
        return midPoint;
    }
    
    public static boolean isEqual(Point p1, Point p2){
        if(p1.x == p2.x && p1.y == p2.y)
            return true;
        return false;
    }
    
    public static int quadrant(Point p){
        if(p.x >= 0){
            if(p.y >= 0)
                return 1;
            else
                return 4;
        }else{
            if(p.y >= 0)
                return 2;
            else
                return 5;
        }
    }
    
    public static void verticalStretch(Point p, double a){
        Point stretch = new Point(p.x, a*p.y);
        System.out.println(pointToString(stretch));
    }
    
    public static void horizontalStretch(Point p, double a){
        Point stretch = new Point(a*p.x, p.y);
        System.out.println(pointToString(stretch));
    }
    
    public static void verticalShift(Point p, double a){
        Point stretch = new Point(p.x, p.y+a);//check the addition out
        System.out.println(pointToString(stretch));
    }
    
    public static void horizontalShift(Point p, double a){
        Point stretch = new Point(p.x - a, p.y);//check the addition out
        System.out.println(pointToString(stretch));  
    }
    
    public static void testCodePoint(){
    	double y = 0;
        Point[] pa = new Point[5];
        for(int i = 2; i <= 10; i++){
        	y = 2*i + 3;
        	pa[i/2-1] = new Point(i, y);
        }
        
        for(int i = 0; i < 5; i++) {
        	verticalStretch(pa[i], 3);
        }
        
        for(int i = 0; i < 5; i++) {
        	horizontalStretch(pa[i], 2);
        }
        
        for(int i = 0; i < 5; i++) {
        	verticalShift(pa[i], -1);
        }
        
        for(int i = 0; i < 5; i++) {
        	horizontalShift(pa[i], 2);
        }
        
        double x = 0.0;
        Point[] sineFunction = new Point[5];
        double[] sineYValues = {0, 1, 0, -1, 0};
        int j = 0;
        for(int i = 0; i < 5; i++) {
        	x = i*3.14/2;
        	sineFunction[i] = new Point(x, sineYValues[j]);
        	j++;
        }
        
        for(int i = 0; i < 5; i++) {
        	verticalShift(sineFunction[i], 2);
        	verticalStretch(sineFunction[i], 2);
        }
        
        for(int i = 0; i < 5; i++) {
        	verticalStretch(sineFunction[i], 2);
        	verticalShift(sineFunction[i], 2);
        }
        
    }
    
    public static void testCodeMoney() {
        //a)
        Money sum = new Money();
        Money[] ma = new Money[100]; //ma = money array
        for(int i = 0; i < 100; i++) {
            ma[i] = new Money(0, i + 1);
        }
        for(int i = 0; i < ma.length; i++) {
            sum = add(sum, ma[i]);
        }
        
        System.out.println(moneyToString(sum));
        
        //b)
        
        Money deposit = new Money();
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int count = 0;
        for(int i = 0; i < 365; i++) {
            for(int j = 0; j < 12; j++){
                deposit.d += 10;
                count++;
                if(count == days[j]) {
                    deposit = applyInterest(deposit, 1);
                    count = 0;
                    j++;
                }
            }
        }
        
        //c)
        
        double taxRate = 9.5; //as a percent
        Money amount = new Money();
        Money[] shoppingCart = new Money[5];
        for(int i = 0; i < shoppingCart.length; i++) {
            amount = add(amount, shoppingCart[i]);
        }
        amount = payWith20(applyInterest(amount, taxRate));

    }


}






