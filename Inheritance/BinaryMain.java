package Inheritance;

import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Integer;
import java.lang.Math;
class Binary{
    private static int objectCount = 0;
    private ArrayList<Binary> allBinaryObjects = new ArrayList<Binary>();
    private int[] digits;
    public int[] getDigits() {
    	return digits;
    }
    //for one of the constructors I can covert int to String or String to int
    //and then do this(that data);
    public Binary(int binaryNumber){
        objectCount++;
        digits = new int[8];
        int count = Integer.toString(binaryNumber).length();
        while(binaryNumber>0){
            count--;
            if(!(binaryNumber%10 == 1 || binaryNumber%10 == 0)){
                digits = null;
                break;
            }else{
                digits[count] = binaryNumber%10;
                binaryNumber/=10;
            }
        }
        allBinaryObjects.add(this);
    }
    public Binary(String binaryNumber){
        objectCount++;
        digits = new int[8];
        for(int i = 0; i < binaryNumber.length(); i++){
            if(!(binaryNumber.substring(i, i+1).compareTo("1") == 0
            ||binaryNumber.substring(i, i+1).compareTo("0") == 0))
                digits = null;
            else
                digits[i] = Integer.parseInt(binaryNumber.substring(i, i+1));
        }
        allBinaryObjects.add(this);//is it possible to place as first line?
    }
    public int intValue(){
        int sum = 0;
        for(int i = 0; i < digits.length; i++){
            sum+=digits[digits.length-1-i]*Math.pow(2, i);
        }
        return sum;
    }
    public Binary intToBinary(int a){
        int count = 0;
        for(int i = 7; i >= 0; i--){
            if(a >= Math.pow(2, i)){
                digits[count] = 1;
                a-=Math.pow(2, i);
            }else
                digits[count] = 0;
            count++;
        }
        return this;
    }
}


public class BinaryMain {
	public static void main(String[] args) {
		//can only use binary starting with 1 for constructor with argument as int binary number
		Binary b = new Binary(10001110);
		System.out.println(b.intValue());//142
		Binary a = new Binary("10001110");
		System.out.println(a.intValue());//142
		Binary c = new Binary("00000111");
		System.out.println(c.intValue());//7
		Binary d = new Binary("00000001");
		System.out.println(Arrays.toString(d.intToBinary(142).getDigits()));
		System.out.println(d.intToBinary(142).intValue());//142
	}
}
