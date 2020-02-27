public class FractionClass{
    // Constants (Final Static Variables)
    // Static/Class Variables
    private static int objectCount = 0;
    private static int methodCount = 0;
    // Nonstatic/Instance Variables
    private int numerator;
    private int denominator;
    // Constructors
    public FractionClass(){
        numerator = 0;
        denominator = 0;
    }
    public FractionClass(int n, int d){
        numerator = n;
        denominator = d;
    }
    public FractionClass(FractionClass f){
        numerator = f.numerator;
        denominator = f.denominator;
    }
    // Getters/Setters
    public int getObjectCount(){
        return objectCount;
    }
    public int getMethodCount(){
        return methodCount;
    }
    public int getNumerator(){
        return numerator;
    }
    public int getDenominator(){
        return denominator;
    }
    public void setNumerator(int n){
        numerator = n;
    }
    public void setDenominator(int d){
        denominator = d;
    }
    // Static Methods
    public static int integerPart(FractionClass f){
        methodCount++;
        return f.numerator/f.denominator;
    }
    public static int abs(int a){
        methodCount++;
        if(a >= 0)
            return a;
        else
            return -a;
    }
    public static FractionClass min(FractionClass a, FractionClass b){
        methodCount++;
        if(1.0*a.numerator/a.denominator <= 1.0*b.numerator/b.denominator){
            return new FractionClass(a);
        }
        return new FractionClass(b);
    }
    public static FractionClass max(FractionClass a, FractionClass b){
        methodCount++;
        if(1.0*a.numerator/a.denominator >= 1.0*b.numerator/b.denominator){
            return new FractionClass(a);
        }
        return new FractionClass(b);
    }
    public static FractionClass sum(FractionClass[] a){
    	methodCount++;
        FractionClass f = new FractionClass(1, 1);
        for(int i = 0; i < a.length; i++){
            if(i == 0){
                f = f.sum(a[i]);
                f.numerator--;
            }
            else{
                f = f.sum(a[i]);
            }
        }
        return f;
    }
    

    public static FractionClass[] quadraticFormula(FractionClass a, FractionClass b, FractionClass c){
    	methodCount++;
        FractionClass temp = a.product(c);
        temp.setNumerator(4*temp.getNumerator());
        FractionClass f = (b.product(b)).difference(temp); //square root of discriminant
        //f.simplify();
        if(f.getNumerator() < 0 || f.getDenominator() < 0){
            return null;
        }else if(f.getNumerator() == 0){
        	FractionClass[] fArray = new FractionClass[1];
        	fArray[0] = qFHelper(a, b); //-b/2a
        	fArray[0].simplify();
        	return fArray;
        }else {
        	//System.out.println(b);
        	FractionClass[] fArray = new FractionClass[2];
        	FractionClass helperF = qFHelper2(a, b, f);
        	helperF.simplify();
        	fArray[0] = helperF; //(-b+f)/2a
        	//fArray[0].simplify();
        	b.setNumerator(-1*b.getNumerator());
        	FractionClass helperF2 = qFHelper3(a, b, f);
        	fArray[1] = new FractionClass(helperF2);
        	fArray[1].simplify();
        	return fArray;
        }
        
    }
    public static FractionClass qFHelper(FractionClass a, FractionClass b) {
    	methodCount++;
    	FractionClass solution = new FractionClass(b);
    	solution.setNumerator(-1*b.getNumerator());
    	int x = solution.getDenominator()*2;
    	solution.setDenominator(x*b.getDenominator());
    	FractionClass reciprocalOfA = new FractionClass(a.getDenominator(), a.getNumerator());
    	FractionClass solutionFraction = solution.product(reciprocalOfA);
    	return solutionFraction;
    }
    public static FractionClass qFHelper2(FractionClass a, FractionClass b, FractionClass f) {
    	methodCount++;
    	b.setNumerator(-1*b.getNumerator());
    	FractionClass solution = new FractionClass(b.sum(f.sqrt()));//sum //f.sqrt
    	int x = solution.getDenominator()*2;
    	solution.setDenominator(x*b.getDenominator());
    	FractionClass reciprocalOfA = new FractionClass(a.getDenominator(), a.getNumerator());
    	FractionClass solutionFraction = solution.product(reciprocalOfA);
    	return solutionFraction;
    }
    public static FractionClass qFHelper3(FractionClass a, FractionClass b, FractionClass f) {
    	methodCount++;
    	b.setNumerator(-1*b.getNumerator());
    	FractionClass solution = new FractionClass(b.difference(f.sqrt()));//difference //f.sqrt
    	int x = solution.getDenominator()*2;
    	solution.setDenominator(x*b.getDenominator());
    	FractionClass reciprocalOfA = new FractionClass(a.getDenominator(), a.getNumerator());
    	FractionClass solutionFraction = solution.product(reciprocalOfA);
    	return solutionFraction;
    }
    
    public static int[] factors(int n) {
    	methodCount++;
    	int[] f = new int[n];
    	int counter = 0;
    	for(int i =2;i<=n;i++){
            if(n%i==0){
                f[counter] = i;
                counter++;
            }
        }
    	int[] rv = new int[counter];
        for(int i = 0;i<counter;i++){
            rv[i] = f[i];
        }
        return rv;
    }

    public FractionClass[] partialPartialFractionDecomposition(){
        methodCount++;
        int [] n = factors(denominator);
        int [] m = new int[n.length];
        int [] s = new int[m.length];
        
        for(int i = 0;i<m.length;i++)
            m[i] = denominator/n[i];
            int sum = 0;
            
            while(sum < numerator){
            for(int i = m.length - 1; i >=0 ; i--)
                if(sum + m[i] <= numerator){
                    s[i] += m[i];
                    
                }
            }
        FractionClass[] f = new FractionClass[m.length];
        for(int i =0; i < m.length;i++){
            f[i] = new FractionClass(s[i], n[i]);
            f[i].simplify();
        }
        return f;
    }


    
    // Nonstatic Methods
    public String toString(){
        methodCount++;
        return numerator + "/" + denominator;
    }
    public String toMixedNumber(){
        methodCount++;
        if(!isError()){
            if(numerator < denominator){
                return toString();//this.?
            }else{
                String s = (numerator/denominator) + "";
                if(numerator % denominator > 0){
                    s += " " + (numerator%denominator) + "/" + denominator;
                }
                return s;
            }
        }else
            return "Cannot covert to mixed number! Division by 0!";
    }
    public int integerPart(){
        methodCount++;
        return numerator/denominator;
    }
    public int remainder(){
        methodCount++;
        return numerator%denominator;
    }
    public boolean isError(){
        methodCount++;
        if(denominator == 0)
            return true;
        return false;
    }
    public boolean isPositive(){
        methodCount++;
        if(numerator/denominator > 0)
            return true;
        else
            return false;
    }
    public boolean isSimplified(){
        methodCount++;
        for(int i = 2; i <= numerator+denominator; i++){
            if(abs(numerator)%i == 0 && abs(denominator)%i == 0){
                return false;
            }
        }
        return true;
    }
    public void simplify(){
        methodCount++;
        if(!isSimplified()){
            int x = numerator;
            if(abs(numerator) > abs(denominator))
                x = denominator;
            for(int i = 2; i <= x; i++){
                if(numerator%i == 0 && denominator%i == 0){
                    numerator /= i;
                    denominator /= i;
                    i--;
                }
            }
        }
    }
    public FractionClass simplified(){
        methodCount++;
        FractionClass f = new FractionClass(numerator,denominator);
        for(int i =1;i<f.denominator+1;i++){
            if(f.numerator%i == 0&&f.denominator%i==0){
                f.numerator/=i;
                f.denominator/=i;
                
            }   
            
        }
        return f;
    }
    public boolean equals(FractionClass f){
        if(f.numerator>numerator)
            if(f.numerator % numerator==0 && f.denominator % denominator== 0)
                return true;
        else if(f.numerator<numerator)
            if(numerator % f.numerator==0 && denominator % f.denominator== 0)
                return true;
        return false;         
        
    }
    public FractionClass sum(FractionClass a){
    	methodCount++;
        int d = denominator*a.denominator;
        int n = denominator*a.numerator + a.denominator*numerator;
        FractionClass f = new FractionClass(n, d);
        f.simplify();
        return f;
    }
    public FractionClass difference(FractionClass a){
    	methodCount++;
        int d = denominator*a.denominator;
        int n = a.denominator*numerator - denominator*a.numerator;
        FractionClass f = new FractionClass(n, d);
        f.simplify();
        return f;
    }
    public FractionClass product(FractionClass a){
    	methodCount++;
        int d = denominator*a.denominator;
        int n = numerator*a.numerator;
        FractionClass f = new FractionClass(n, d);
        f.simplify();
        return f;
    }
    public FractionClass quotient(FractionClass a){
    	methodCount++;
        int d = denominator*a.numerator;
        int n = numerator*a.denominator;
        FractionClass f = new FractionClass(n, d);
        f.simplify();
        return f;
    }
    
    public FractionClass sqrt() {
    	methodCount++;
    	return new FractionClass(sqrt(numerator), sqrt(denominator));
	}
    
    public int sqrt(int value) {
    	methodCount++;
    	int i =0;
        while((i*i)<=value){
            i++;
        }
        i--;
        return i;
		/*for (int i = 0; i < value; i++) {
			if (i * i >= value)
				//System.out.println(i-1);
				return i - 1;
		}
		return 0;
		*/
	}

}


