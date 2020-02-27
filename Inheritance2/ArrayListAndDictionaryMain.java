package Inheritance2;

import java.util.Scanner;

class ArrayList {
	private Object[] objList;

	public ArrayList() {
		objList = new Object[0];
	}

	public int size() {
		return objList.length;
		//testing git 
	}

	public void add(Object obj) {
		Object[] newArray = new Object[objList.length + 1];
		for (int i = 0; i < objList.length; i++) {
			newArray[i] = objList[i];
		}
		newArray[objList.length] = obj;// or newArray.length-1
		objList = newArray;
	}

	public void add(int index, Object obj) {
		assert (index==0) && (objList==null) || objList != null && index<=objList.length && index>=0: "Error: add()";
		Object[] newArray = new Object[objList.length + 1];
		for (int i = 0; i < index; i++) {
			newArray[i] = objList[i];
		}
		newArray[index] = obj;
		for (int j = index + 1; j < newArray.length; j++) {
			newArray[j] = objList[j - 1];
		}
		objList = newArray;
	}

	public Object get(int index) {
		return objList[index];
	}
	public void set(int index, Object obj) {
		objList[index] = obj;
	}

	public Object remove(int index) {
		Object object = objList[index];
		Object[] newArray = new Object[objList.length - 1];
		for (int i = 0; i < index; i++) {
			newArray[i] = objList[i];
		}
		for (int j = index; j < newArray.length; j++) {
			newArray[j] = objList[j + 1];
		}
		objList = newArray;
		return object;
	}

	public String toString() {
		String s = "[";
		for (int i = 0; i < objList.length; i++) {
			if (i == objList.length - 1)
				s += objList[i] + "]";
			else
				s += objList[i] + ", ";
		}
		return s;
	}
}

class Dictionary {
	private ArrayList words;
	private ArrayList defs;

	public ArrayList getWords() {
		return words;
	}

	public void setWords(ArrayList words) {
		this.words = words;
	}

	public ArrayList getDefs() {
		return defs;
	}

	public void setDefs(ArrayList defs) {
		this.defs = defs;
	}

	public void add(String word, String def) {
		words.add(word);
		defs.add(def);
	}

	public int size() {
		return words.size();
	}

	public void randomFlashCard() {
		int[] indices = new int[4];
		int index = (int) (Math.random() * size());// index of answer in words ex.9
		String wordSelected = (String) (words.get(index));
		// String defSelected = (String)(defs.get(index));
		int indexOfAnswer = (int) (Math.random() * 4);// index of answer in indices ex.1
		String[] letters = { "A", "B", "C", "D" };
		String letterOfAnswer = letters[indexOfAnswer];
		indices[indexOfAnswer] = index;// putting index of answer in words in one of the 4 slots in indices
		// ex. {7, 9, 3, 5}
		for (int i = 0; i < indices.length; i++) {
			if (i == indexOfAnswer) // do not override answer placed in indices
				continue;
			int x = (int) (Math.random() * size());
			if (!indexAlreadyExists(indices, x))// check if that word and definition has already been placed in indices
				indices[i] = x;
			else
				i--;

		}
		Scanner a = new Scanner(System.in);
		System.out.println(wordSelected);
		System.out.println("Which of the following is the definition?");
		// a way to write w/out the 4 lines below?
		System.out.println("A. " + defs.get(indices[0]));
		System.out.println("B. " + defs.get(indices[1]));
		System.out.println("C. " + defs.get(indices[2]));
		System.out.println("D. " + defs.get(indices[3]));
		String answer = a.nextLine().toUpperCase();
		if (answer.compareTo(letterOfAnswer) == 0)
			System.out.println("You are right");
		else
			System.out.println("You are wrong");
	}

	public boolean indexAlreadyExists(int[] indices, int index) {
		for (int i = 0; i < indices.length; i++) {
			if (indices[i] == index)
				return true;
		}
		return false;
	}

	public static void fillDictionary(Dictionary d, String[] words, String[] defs) {
		// ArrayList<String> cars = new ArrayList<String>();
		ArrayList wordList = new ArrayList();
		ArrayList defList = new ArrayList();
		for (int i = 0; i < words.length; i++) {
			wordList.add(words[i]);
			defList.add(defs[i]);
		}
		d.setWords(wordList);
		d.setDefs(defList);
	}
}

public class ArrayListAndDictionaryMain {
	public static void main(String[] args) {
		Dictionary d = new Dictionary();
		String[] words = { "Le taureau", "La vache", "La tortue", "Le canard", "Le cochon", "La chèvre", "Le poulet",
				"Une poule", "Le lapin", "Le mouton", "La brebis" };
		String[] defs = { "The bull", "The cow", "The turtle", "The duck", "The pig", "The goat", "The chicken",
				"A hen", "The rabbit", "The sheep", "The ewe" };
		Dictionary.fillDictionary(d, words, defs);
		/*d.add("cat", "furry big kitten");
		d.getWords().add(3, "20_Guesses");
		d.getWords().add("hey");
		System.out.println(d.getWords().size());
		d.getWords().remove(13);
		d.getWords().set(12, "dog");
		System.out.println(d.getWords().toString());
		System.out.println(d.getDefs().toString());
		*/
		d.randomFlashCard();
	}
}
