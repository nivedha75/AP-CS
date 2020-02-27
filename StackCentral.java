class Stack{
    private int[] storage;
    private int numberOfElements;
    
    public Stack(){
        storage = new int[100];
        numberOfElements = 0;
    }
    
    public int[] getStorage(){
        return copyArray(storage);
    }
    
    public int getNumberOfElements(){
        return numberOfElements;
    }
    
    public void push(int num){
        numberOfElements++;//101
        
        if(numberOfElements > storage.length){//101>100
            int[] newStorage = new int[100+storage.length];
            for(int i = 0; i < 100; i++){
                newStorage[i] = storage[i];
            }
            storage = newStorage;
        }
        
        storage[numberOfElements-1] = num;//101
        
        
    }
    
    public int pop(){
        int x = storage[numberOfElements-1];
        numberOfElements--;
        return x;
    }
    
    public String toString(){
        String storageStr = "[";
        for(int i = 0; i < numberOfElements; i++){
            if(i != numberOfElements -1){
                storageStr += storage[i]+ ", ";
            }else{
                storageStr += storage[i];
            }
        }
        return storageStr+"]";
    }
    
    public static int[] copyArray(int[] a){
        int[] copy = new int[a.length];
        for(int i = 0; i < a.length; i++){
            copy[i] = a[i];
        }
        return copy;
    }
    
    public static int[] append(int[] a, int[] b){
        int[] combined = new int[a.length+b.length];
        for(int i = 0; i < a.length; i++){
            combined[i] = a[i];
        }
        for(int i = a.length; i<combined.length; i++){
            combined[i] = b[i-a.length];
        }
        return combined;
    }
    
}

public class StackCentral {
	public static void main(String[] args) {
    	Stack s = new Stack();
    	s.push(5);
    	s.push(6);
    	System.out.println(s.toString());
    	System.out.println(s.pop());
    	System.out.println(s.toString());
    	System.out.println(s.pop());
    	System.out.println(s.toString());
    	for(int i = 0; i < 101; i++) {
    		s.push(5);
    		System.out.println("# indices total: " + s.getStorage().length);
    	}
    	System.out.println(s.toString());
    	int[] b = {1, 2, 3};
    	int[] x = Stack.append(s.getStorage(), b);
    	for(int i = 0; i < x.length; i++) {
    		System.out.print(x[i]+ " ");
    	}
    }
}
