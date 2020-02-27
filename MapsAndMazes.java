public class MapsAndMazes{
    public static void main(String[] args){
    	System.out.println(arrayToString(createMap(2, 5)) + "\n");
    	System.out.println(arrayToString(createMap()) + "\n");
    	int[][] map1 = createMap(20);
    	System.out.println(arrayToString(map1) + "\n");
    	printMap(map1);
    	System.out.println();
    	System.out.println(mapToString(map1) + "\n");
    	System.out.println("Can go North: " + canGoN(map1));
    	System.out.println("Can go South: " + canGoS(map1));
    	System.out.println("Can go East: " + canGoE(map1));
    	System.out.println("Can go West: " + canGoW(map1));
    	System.out.println(getSymbol(3));
    	System.out.println(arrayToString(find(map1, 4)));
    	System.out.println(arrayToString(find(map1, 1)));
    	int[][] findCoordinates = {{1, 1, 1},
    							   {1, 1, 3},
    							   {3, 2, 2}};
    	int[] findCResult = find(findCoordinates, 2);
    	for(int i = 0; i < findCResult.length; i++) {
    		System.out.println(findCResult[i]);
    	}
    	
    }
    
    //to print 1D arrays when testing
    public static String arrayToString(int[] a) {
    	if(a == null)
    		return null;
		String array = "{";
		for (int i = 0; i < a.length - 1; i++) {
			array += a[i] + ",";
		}
		array += a[a.length - 1] + "}";
		return array;
	}

    //to print 2D arrays when testing
	public static String arrayToString(int[][] a) {
		String array = "{";
		for (int i = 0; i < a.length - 1; i++) {
			if (i == 0)
				array += arrayToString(a[i]);
			else
				array += arrayToString(a[i]);
			array += ",\n ";
		}
		array += arrayToString(a[a.length - 1]) + "}";
		return array;
	}
    
    public static int[][] createMap(int r, int c){
        int[][] map = new int[r][c];
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                map[i][j] = 0;
            }
        }    
        return map;
    }
    
    public static int[][] createMap(){
        int[][] map = {{1, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                       {0, 3, 0, 3, 0, 3, 0, 3, 3, 0},
                       {0, 0, 0, 3, 0, 0, 0, 3, 0, 0},
                       {3, 0, 3, 0, 3, 3, 3, 0, 0, 3},
                       {0, 0, 0, 0, 0, 0, 3, 0, 3, 0},
                       {0, 3, 3, 3, 0, 0, 0, 3, 0, 0},
                       {0, 0, 0, 0, 3, 3, 0, 0, 0, 3}, 
                       {0, 3, 0, 0, 3, 0, 3, 0, 3, 0},
                       {0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                       {0, 3, 0, 0, 3, 0, 0, 3, 0, 2}};               
        return map;            
    }
    
    public static int[][] createMap(int n){
        int[][] map = createMap(10, 10);
        int r = (int)(Math.random()*10);
        int c = (int)(Math.random()*10);
        map[r][c] = 1;
        while(map[r][c] != 0) {
        	r = (int)(Math.random()*10);
        	c = (int)(Math.random()*10);
        }
        map[r][c] = 2;
        for(int i = 0; i < n; i++){ //can use a while loop
        	r = (int)(Math.random()*10);
        	c = (int)(Math.random()*10);
        	if(map[r][c] == 0)
        		map[r][c] = 3;
        	else
        		i--;
        }
        return map;
    }
    
    public static String getSymbol(int value){
        String rv = "";
        if(value == 0)
            rv = "_";
        else if(value == 1)
            rv = "Y";
        else if(value == 2)
            rv = "F";
        else if(value == 3)
            rv = "*";
        return rv;
    }
    
    public static void printMap(int[][] m){
    	if(m == null) {
    		System.out.println("Need to enter a map.");
    	}
    	else {
    		System.out.print("  ");
    		//could have built onto a string and printed that
    		for(int i = 0; i < m.length; i++){
    			for(int j = 0; j < m[i].length; j++){
    				System.out.print(getSymbol(m[i][j]));
    				if(j != m[i].length - 1)
    					System.out.print(" "); 	
    			}
    			if(i != m.length - 1){
    				System.out.println();
    				System.out.print("  ");
    			}
    		}
    		System.out.println();//the last thing printed was using print not println so the cursor
    		//remains at the end of the maze so the cursor should be moved to the next line
    	}
    }
    
    public static String mapToString(int[][] m){
    	if(m == null) {
    		return null;
    	}
        String rv = "  ";
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m[i].length; j++){
                rv += getSymbol(m[i][j]);
                if(j != m[i].length - 1)
                	rv += " ";
            }
            if(i != m.length -1){
                rv += "\n";
                rv += "  ";
            }
        }
        return rv;
    }
    
    public static int[] find(int[][] m, int value){
    	if(m == null) {
    		return null;
    	}
        int[] coordinates = new int[2];
        int counter = 0;
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m[i].length; j++){
                if(value == m[i][j]){
                	coordinates[0] = i;
                	coordinates[1] = j;
                	counter++;
                	break;
                }
            }
            if(counter == 1) {
            	break;
            }
        }
        if(counter == 0) {
        	return null;
        }
        return coordinates;
    }
    
    public static boolean canGoN(int[][] m) {
    	if(m == null) {
    		return false;
    	}
    	int[] personCoordinates = find(m, 1);
    	if(personCoordinates == null) {
    		return false;
    	}
    	if(personCoordinates[0] != 0) {
    		if(m[personCoordinates[0]-1][personCoordinates[1]] == 0 || m[personCoordinates[0]-1][personCoordinates[1]] == 2) {
    			return true;
    		}
    	}
    	return false;
    }
    
    public static boolean canGoS(int[][] m) {
    	if(m == null) {
    		return false;
    	}
    	int[] personCoordinates = find(m, 1);
    	if(personCoordinates == null) {
    		return false;
    	}
    	if(personCoordinates[0] != m.length - 1) {
    		if(m[personCoordinates[0]+1][personCoordinates[1]] == 0 || m[personCoordinates[0]+1][personCoordinates[1]] == 2) {
    			return true;
    		}
    	}
    	return false;
    }
    
    public static boolean canGoE(int[][] m) {
    	if(m == null) {
    		return false;
    	}
    	int[] personCoordinates = find(m, 1);
    	if(personCoordinates == null) {
    		return false;
    	}
    	if(personCoordinates[1] != m[0].length - 1) {
    		if(m[personCoordinates[0]][personCoordinates[1] + 1] == 0 || m[personCoordinates[0]][personCoordinates[1] + 1] == 2) {
    			return true;
    		}
    	}
    	return false;
    }
    
    public static boolean canGoW(int[][] m) {
    	if(m == null) {
    		return false;
    	}
    	int[] personCoordinates = find(m, 1);
    	if(personCoordinates == null) {
    		return false;
    	}
    	if(personCoordinates[1] != 0) {
    		if(m[personCoordinates[0]][personCoordinates[1] - 1] == 0 || m[personCoordinates[0]][personCoordinates[1] - 1] == 2) {
    			return true;
    		}
    	}
    	return false;
    }
    
}





