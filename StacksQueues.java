public class StacksQueues{
    public static void main(String[] args){
       int[] myS = createStack();
       System.out.println(prettyPrintStack(myS));
       System.out.println(dumpStack(myS));
       push(myS, 5);
       System.out.println(prettyPrintStack(myS));
       System.out.println(dumpStack(myS));
       push(myS, 6);
       System.out.println(prettyPrintStack(myS));
       System.out.println(dumpStack(myS));
       int popValue = pop(myS);
       System.out.println(popValue);
       System.out.println(dumpStack(myS));
       popValue = pop(myS);
       System.out.println(popValue);
       System.out.println(dumpStack(myS));
       popValue = pop(myS);
       System.out.println(dumpStack(myS));
       System.out.println("Task 2 stack:");
       int[] myS2 = createStack();
       for(int i = 9; i > 2; i--){
           push(myS2, i);
       }
       System.out.println(dumpStack(myS2));
       for(int i = 0; i < 3; i++){
           pop(myS2);
       }
       System.out.println(dumpStack(myS2));
       for(int i = 1; i < 5; i++){
           push(myS2, i);
       }
       System.out.println(dumpStack(myS2));
       for(int i = 0; i < 5; i++){
           pop(myS2);
       }
       System.out.print(prettyPrintStack(myS2));
       System.out.println("\nTask 5 queue:");
       int[] myQ = createQueue();
       for(int i = 9; i > 2; i--){
           enqueue(myQ, i);
       }
       System.out.println(dumpQueue(myQ));
       for(int i = 0; i < 3; i++){
           dequeue(myQ);
       }
       System.out.println(dumpQueue(myQ));
       for(int i = 1; i < 5; i++){
           enqueue(myQ, i);
       }
       System.out.println(dumpQueue(myQ));
       for(int i = 0; i < 5; i++){
           dequeue(myQ);
       }
       System.out.print(prettyPrintQueue(myQ));
    }
    
    public static int[] createStack(){
        int[] myS = new int[101];
        myS[0] = 0;
        
        for(int i = 1; i < 101; i++){
            myS[i] = 0;
        }
        return myS;
    }
    
    public static void push(int[] stack, int data){
        if(stack == null)
            System.out.println(stack);
        else{
            //System.out.println(stack[0]);
            if(stack[0] < 100) {
                stack[0]++;
                stack[stack[0]] = data;
            }else
                System.out.println("No more space available");
        }
    }
    
    public static int pop(int[] stack) {
        int rv = 0;
        if(stack == null){
            System.out.println(stack);
        }else{
            if(stack[0] != 0){
                rv = stack[stack[0]];
                stack[0]--;
            }else
                System.out.println("No value to pop.");
        }
        return rv;
    }
    
    public static String prettyPrintStack(int[] stack){
        String rv = "[";
        
        for(int i = 1; i <= stack[0] - 1; i++){
            rv += stack[i] + ",";
        }
        
        rv += stack[stack[0]] + "]";
        return rv;
    }
    
    public static String dumpStack(int[] stack){
        String rv = "{";
        for(int i = 0; i < stack.length - 1; i++){
            rv += stack[i] + ", ";
        }
        rv += stack[100] + "}";
        return rv;
    }
    
    /*public static void task2(int stack[]){
        for(int i = 0; i < 3; i ++){
            pop(stack);
        }
        
        for(int i = 1; i < 5; i++){
            push(stack, i);
        }
        
        for(int i = 0; i < 5; i ++){
            pop(stack);
        }
        
    }
    */
    
    public static void printReportFILO(int[] shares, int[] price){
        System.out.println("Shares\t\tPrice");
        for(int i = 1; i <= shares[shares[0]]; i++)
            System.out.println(shares[i] + "\t\t$" + price[i]);
    }
    
    public static String runReportFILO(int[] shares, int[] price){
        String rv = "";
        rv += "Shares\t\tPrice\n";
        for(int i = 1; i <= shares[shares[0]]; i++)
            rv += shares[i] + "\t\t$" + price[i] + "\n";
        return rv;
    }
    
    public static void buyFILO(int[] shares, int[] price, int numShares, int pricePerShare){
        push(shares, numShares);
        push(price, pricePerShare*100);
    }
    
    public static int sellFILO(int[] shares, int[] price, int numShares, int pricePerShare){
        int cost = averageFILO(shares, price)*numShares;
        int sell = numShares*pricePerShare;
        return sell - cost;
    }
    
    public static int averageFILO(int[] shares, int[] price){
        int average = 0;
        int sum = 0;
        int numShares = 0;
        for(int i = 1; i <= shares[0]; i++){
            sum += shares[i]*price[i];
            numShares += shares[i];
        }
        average = sum/numShares;
        return average;
    }
    
    //task 4
    
    public static int[] createQueue(){
        int[] myQ = new int[101];
        myQ[0] = 0;
        
        for(int i = 1; i < 101; i++){
            myQ[i] = 0;
        }
        return myQ;
    }
    
    public static void enqueue(int[] queue, int data){
        if(queue == null)
            System.out.println(queue);
        else{
            if(queue[0] < 100) {
            	queue[0]++;
                queue[queue[0]] = data;
            }else
                System.out.println("No more space available");
        }
    }
    
    public static int dequeue(int[] queue) {
        int rv = 0;
        if(queue == null){
            System.out.println(queue);
        }else{
            if(queue[0] != 0){
            	rv = queue[1];
                queue[0]--;
                for(int i = 1; i <= queue[0]; i++){//remember i=0 is the # of elements
                    queue[i] = queue[i+1];
                }
            }else
                System.out.println("No value to dequeue.");
        }
        return rv;
    }
    
    public static String prettyPrintQueue(int[] queue){
        String rv = "[";
        
        for(int i = 1; i <= queue[0] - 1; i++){
            rv += queue[i] + ",";
        }
        
        rv += queue[queue[0]] + "]";
        return rv;
    }
    
    public static String dumpQueue(int[] queue){
        String rv = "{";
        for(int i = 0; i < queue.length - 1; i++){
            rv += queue[i] + ", ";
        }
        rv += queue[100] + "}";
        return rv;
    }
    
    //task 6
    
    public static int[] merge(int[] a, int[] b){
        int[] rv = new int[a.length + b.length];
        int[] qA = createQueue();
        int[] qB = createQueue();
        for(int i = 0; i < a.length; i++){
            enqueue(qA, a[i]);
        }
        for(int i = 0; i < b.length; i++){
            enqueue(qB, b[i]);
        }
        for(int i = 0; i < rv.length; i++){
            if(a[0] < b[0])
                rv[i] = dequeue(qA);
            else
                rv[i] = dequeue(qB);
            if(a[0] == 0){
            	for(int j = i + 1; j < rv.length; j++)
                rv[i] = dequeue(qB);
            }else if(b[0] == 0) {
            	for(int j = i + 1; j < rv.length; j++)
                rv[i] = dequeue(qB);
            }
        }
        return rv;
    }
    
    
    
        
}
    
    












