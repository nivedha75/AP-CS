
public class StringExercises {
	public static void main(String[] args) {
		System.out.println(spaceCount("This is working"));// 15
		System.out.println(vowelCount("aeou"));// 15
		System.out.println(letterCount("This is working", "i"));// 15
		System.out.println(duplicate("java", "j"));
		System.out.println(duplicate("minnie", "n"));
		System.out.println(beforeString("Hello World", "Wo"));
		System.out.println(beforeString("meme", "me"));
		System.out.println(beforeString("art for one person is different than art for another person", "art"));
		System.out.println(afterString("Hello World", "Wo"));
		System.out.println(capVowel("hello"));
		System.out.println(capFirstWord("hello. my name is dave. goodbye."));
	}

	public static int spaceCount2(String s) {
		int rv = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.substring(i, i + 1).equalsIgnoreCase(" "))
				rv++;
		}
		return rv;
	}
	
	public static int spaceCount(String s) {
		int rv = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.substring(i, i + 1).compareTo(" ") == 0)
				rv++;
		}
		return rv;
	}

	public static int vowelCount(String s) {
		int rv = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.substring(i, i + 1).compareTo("a") == 0 || s.substring(i, i + 1).compareTo("e") == 0
					|| s.substring(i, i + 1).equalsIgnoreCase("i") || s.substring(i, i + 1).equalsIgnoreCase("o")
					|| s.substring(i, i + 1).equalsIgnoreCase("u"))
				rv++;
		}
		return rv;
	}
	
	public static int letterCount(String s, String letter) {
		int rv = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.substring(i, i + 1).equalsIgnoreCase(letter))
				rv++;
		}
		return rv;
	}
	
	public static String duplicate(String s, String letter){
        String let = "";
        String rv = "";
        for(int i = 0; i < s.length(); i++){
            let = s.substring(i, i + 1);
            if (let.compareTo(letter) == 0)
                //count++ here before
                rv += let + let;
            else
                rv += let;
        }
        return rv;
    }
	
	public static String beforeString(String s, String substr) {
        if(!(s.indexOf(substr) == -1))
        	return s.substring(0, s.indexOf(substr));
        return s;
    }
	
	public static String afterString(String s, String substr) {
        if(!(s.indexOf(substr) == -1))
        	return s.substring(s.indexOf(substr) + substr.length());
        return s;
    }
	
	public static String capVowel(String s) {
		String rv = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.substring(i, i + 1).equalsIgnoreCase("a") || s.substring(i, i + 1).equalsIgnoreCase("e")
					|| s.substring(i, i + 1).equalsIgnoreCase("i") || s.substring(i, i + 1).equalsIgnoreCase("o")
					|| s.substring(i, i + 1).equalsIgnoreCase("u"))
				rv += s.substring(i, i +1).toUpperCase();
			else 
				rv += s.substring(i, i + 1);
		}
		return rv;
		
	}
    
    public static String capFirstWord(String s){
        String rv = "";
        String letter = "";
        boolean lightSwitch = true;//true so that first letter is upper case
        //s = s.substring(0, 1).toUpperCase() + s.substring(1); //
        for(int i = 0; i <s.length(); i++){
            letter = s.substring(i, i + 1);
            if(lightSwitch && letter.compareTo(" ") != 0){
                rv = rv + letter.toUpperCase();
                lightSwitch = false;
            }else{
                rv = rv + letter;
            }
            if(letter.compareTo(".") == 0 || letter.compareTo("?") == 0 || letter.compareTo("!") == 0)
                lightSwitch = true;
        }
        return rv;
        
    }

	
	

}
