package Inheritance;
import java.lang.Math;
import java.util.Scanner;

public class Scrabble {
    public static void main(String[] args) {
        LetterBag l = new LetterBag();
        Board b = new Board();
        System.out.println("Let's play Scrabble!!!\n");
        System.out.println("Remember to place letters that are given to you and not to replace words already placed on the board! \n");
        b.displayBoard();
        System.out.println();
        for (int i = 0; i < 7; i++) {                                                                                               
            l.player1Letters[i] = l.letters[(int)(26*Math.random())];
            l.player2Letters[i] = l.letters[(int)(26*Math.random())];
        }
        int loop=1;
        while(loop<100){
            Scanner player1 = new Scanner(System.in);
            Player playerOne = new Player();
            Player playerTwo = new Player();
            System.out.println("Player1's letters:");
            String letters=l.displayLetters(l.player1Letters);
            System.out.println(letters);
            System.out.println("Place a word on the board by entering the letters and the Row#Column# in the following format:");
            System.out.println("Ex:\n To place the word \"Java\" vertically:\nJ 1 1\nA 2 1\nV 3 1\nA 4 1\nstop");

            loop++;
            boolean placing = true;
            while(placing) {
                String LetterAndLoc = player1.nextLine();
                if(LetterAndLoc.toLowerCase().compareTo("stop") == 0){
                    placing = false;
                    break;
                }
                else{
                    String letter = LetterAndLoc.substring(0, 1);
                    String locX = LetterAndLoc.substring(2, LetterAndLoc.substring(2).indexOf(" ") + 2);
                    String locY = LetterAndLoc.substring(LetterAndLoc.substring(2).indexOf(" ")+3);
                    //do i need to pass b below?
                    b.placeLetter(l, 1, b, playerOne, letter, locX, locY);
                }
                //Player.displayPoints(playerOne, playerTwo);
            }
            if(Player.times2 && Player.times3)
                playerOne.points += 6*Player.totalPoints;
            else if(Player.times2)
                playerOne.points += 2*Player.totalPoints;
            else if (Player.times3)
                playerOne.points += 3*Player.totalPoints;
            else 
            	playerOne.points += Player.totalPoints;
            
            Player.displayPoints(playerOne, playerTwo);
            System.out.println();
            b.displayBoard();
            System.out.println();
            Player.totalPoints = 0;
            Player.times2 = false;
            Player.times3 = false;
            //now player2
            Scanner player2 = new Scanner(System.in);
            System.out.println("Player2's letters:");
            String letters2=l.displayLetters(l.player2Letters);
            System.out.println(letters2);
            System.out.println("Place a word on the board by entering the letters and the Row#Column# in the following format:");
            System.out.println("Ex:\n To place the word \"Java\" vertically:\nJ 1 1\nA 2 1\nV 3 1\nA 4 1\nstop");
            boolean placing2 = true;
            while(placing2) {
                String LetterAndLoc = player2.nextLine();
                if(LetterAndLoc.toLowerCase().compareTo("stop") == 0){
                    placing = false;
                    break;
                }
                else{
                	String letter = LetterAndLoc.substring(0, 1);
                    String locX = LetterAndLoc.substring(2, LetterAndLoc.substring(2).indexOf(" ") + 2);
                    String locY = LetterAndLoc.substring(LetterAndLoc.substring(2).indexOf(" ")+3);
                    //do i need to pass b below?
                    b.placeLetter(l, 2, b, playerTwo, letter, locX, locY);
                }
                //Player.displayPoints(playerOne, playerTwo);
            }
            //could hit multiple times2s so I need to address that have not done it yet
            if(Player.times2 && Player.times3)
                playerTwo.points += 6*Player.totalPoints;
            else if(Player.times2)
                playerTwo.points += 2*Player.totalPoints;
            else if (Player.times3)
                playerTwo.points += 3*Player.totalPoints;
            else {
                playerTwo.points += Player.totalPoints;
            }
            Player.displayPoints(playerOne, playerTwo);
            System.out.println();
            b.displayBoard();
            System.out.println();
        }
    }

}

class Player{
    int points;
    static boolean times3 = false;
    static boolean times2 = false;
    //variable totalPoints is used when needing to multiply the word's total points by 3 or 2
    static int totalPoints = 0;

    public void addPoints(int pointsEarned){
        points += pointsEarned;
    }

    public static void displayPoints(Player p1, Player p2){
        System.out.print("Player 1: " + p1.points + "\t Player 2: " + p2.points);
    }
}

class Board {
    //String[] scrabbleColNum = { "1 ", "2 ", "3 ", "4 ", "5 ", "6 ", "7 ", "8 ", "9 ", "10", "11", "12", "13", "14", "15" };
    String[] scrabbleRow1 = { "3W", "  ", "  ", "2L", "  ", "  ", "  ", "3W", "  ", "  ", "  ", "2L", "  ", "  ", "3W" };
    String[] scrabbleRow2 = { "  ", "2W", "  ", "  ", "  ", "3L", "  ", "  ", "  ", "3L", "  ", "  ", "  ", "2W", "  " };
    String[] scrabbleRow3 = { "  ", "  ", "2W", "  ", "  ", "  ", "2L", "  ", "2L", "  ", "  ", "  ", "2W", "  ", "  " };
    String[] scrabbleRow4 = { "2L", "  ", "  ", "2W", "  ", "  ", "  ", "2L", "  ", "  ", "  ", "2W", "  ", "  ", "2L" };
    String[] scrabbleRow5 = { "  ", "  ", "  ", "  ", "2W", "  ", "  ", "  ", "  ", "  ", "2W", "  ", "  ", "  ", "  " };
    String[] scrabbleRow6 = { "  ", "3L", "  ", "  ", "  ", "3L", "  ", "  ", "  ", "3L", "  ", "  ", "  ", "3L", "  " };
    String[] scrabbleRow7 = { "  ", "  ", "2L", "  ", "  ", "  ", "2L", "  ", "2L", "  ", "  ", "  ", "2L", "  ", "  " };
    String[] scrabbleRow8 = { "3W", "  ", "  ", "2L", "  ", "  ", "  ", "**", "  ", "  ", "  ", "2L", "  ", "  ", "3W" };
    String[] scrabbleRow9 = { "  ", "  ", "2L", "  ", "  ", "  ", "2L", "  ", "2L", "  ", "  ", "  ", "2L", "  ", "  " };
    String[] scrabbleRow10= { "  ", "3L", "  ", "  ", "  ", "3L", "  ", "  ", "  ", "3L", "  ", "  ", "  ", "3L", "  " };
    String[] scrabbleRow11= { "  ", "  ", "  ", "  ", "2W", "  ", "  ", "  ", "  ", "  ", "2W", "  ", "  ", "  ", "  " };
    String[] scrabbleRow12= { "2L", "  ", "  ", "2W", "  ", "  ", "  ", "2L", "  ", "  ", "  ", "2W", "  ", "  ", "2L" };
    String[] scrabbleRow13= { "  ", "  ", "2W", "  ", "  ", "  ", "2L", "  ", "2L", "  ", "  ", "  ", "2W", "  ", "  " };
    String[] scrabbleRow14= { "  ", "2W", "  ", "  ", "  ", "3L", "  ", "  ", "  ", "3L", "  ", "  ", "  ", "2W", "  " };
    String[] scrabbleRow15= { "3W", "  ", "  ", "2L", "  ", "  ", "  ", "3W", "  ", "  ", "  ", "2L", "  ", "  ", "3W" };
    String[][] scrabbleBoard = { scrabbleRow1, scrabbleRow2, scrabbleRow3, scrabbleRow4, scrabbleRow5,scrabbleRow6,scrabbleRow7, scrabbleRow8,
            scrabbleRow9, scrabbleRow10, scrabbleRow11, scrabbleRow12, scrabbleRow13,scrabbleRow14, scrabbleRow15};
    public void displayBoard() {
        String sB = "";
        System.out.format("%-4s%-4s%-4s%-4s%-4s%-4s%-4s%-4s%-4s%-4s%-4s%-4s%-4s%-4s%-4s%-4s%-4s%-4s%-4s%-4s%-4s%-4s%-4s%-4s%-4s%-4s%-4s%-4s%-4s%-4s%-4s", "\t|", "1", "|", "2", "|", "3", "|", "4", "|", "5", 
            "|", "6", "|", "7", "|", "8", "|", "9", "|", "10", "|", "11", "|", "12", "|", "13", "|", "14", "|", "15", "|" );
        System.out.println("\n_________________________________________________________________________________________________________________________________");
        String row = "";
        for(int i = 0; i < 15; i++) { //9
            System.out.format("%-7s", i+1);
            for(int j = 0; j < 15; j++) {
                System.out.format("%-4s%-4s", "|", scrabbleBoard[i][j]);
                if(j == 14) {
                    System.out.print("|");
                }
            }
            System.out.println("\n_________________________________________________________________________________________________________________________________");
        }
        System.out.println(sB);
    }

    public void placeLetter(LetterBag l2, int pNum, Board b, Player p, String letterSquare, String locX, String locY) {
        Letter l = new Letter(letterSquare);
        if(b.scrabbleBoard[Integer.parseInt(locX) - 1][Integer.parseInt(locY) - 1].compareTo("2L") == 0) {
            //p.addPoints(2*l.points);
            Player.totalPoints += 2*l.points;
        } else if(b.scrabbleBoard[Integer.parseInt(locX) - 1][Integer.parseInt(locY) - 1].compareTo("3L") == 0) {
            //p.addPoints(3*l.points);
            Player.totalPoints += 3*l.points;
        } else if(b.scrabbleBoard[Integer.parseInt(locX) - 1][Integer.parseInt(locY) - 1].compareTo("  ") == 0) {
            //p.addPoints(l.points);
            Player.totalPoints += l.points;
        } else if(b.scrabbleBoard[Integer.parseInt(locX) - 1][Integer.parseInt(locY) - 1].compareTo("2W") == 0||
        b.scrabbleBoard[Integer.parseInt(locX) - 1][Integer.parseInt(locY) - 1].compareTo("**") == 0) {
            //p.addPoints(l.points);
            Player.totalPoints += l.points;
            Player.times2 = true;
        } else if(b.scrabbleBoard[Integer.parseInt(locX) - 1][Integer.parseInt(locY) - 1].compareTo("3W") == 0) {
            //p.addPoints(l.points);
            Player.totalPoints += l.points;
            Player.times3 = true;
        }
        b.scrabbleBoard[Integer.parseInt(locX) - 1][Integer.parseInt(locY) - 1] = letterSquare;
        for (int i = 0; i < 7; i++) {
        	if(pNum == 1) {
        		if(l2.player1Letters[i].compareTo(letterSquare) == 0) {
            		l2.player1Letters[i] = l2.letters[(int)(26*Math.random())];
        			break;
        		}
        	}else {
        		if(l2.player1Letters[i].compareTo(letterSquare) == 0) {
            		l2.player1Letters[i] = l2.letters[(int)(26*Math.random())];
            		break;
        		}
        	}
        }
    }
}

class LetterBag {
    String[] letters = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
    String[] player1Letters = new String[7];
    String[] player2Letters = new String[7];

    public String displayLetters(String[] playerLetters) {
        String letters = "";
        for (int i = 0; i < 7; i++) {
            if(i < 6)
                letters += playerLetters[i] + " ";
            else
                letters += playerLetters[i];
        }
        return letters;
    }
}

class Letter{
    int points;
    String letter;
    public Letter(String letter){
        this.letter = letter;
        points = this.pointValue();
    }

    public boolean isInBag() {
        //
        return true;
    }

    public int pointValue(){
        if(letter.compareTo("A") == 0)
            return 1;
        else if(letter.compareTo("B") == 0)
            return 3;
        else if(letter.compareTo("C") == 0)
            return 3;
        else if(letter.compareTo("D") == 0)
            return 2;
        else if(letter.compareTo("E") == 0)
            return 1;
        else if(letter.compareTo("F") == 0)
            return 4;
        else if(letter.compareTo("G") == 0)
            return 2;
        else if(letter.compareTo("H") == 0)
            return 4;
        else if(letter.compareTo("I") == 0)
            return 1;
        else if(letter.compareTo("J") == 0)
            return 8;
        else if(letter.compareTo("K") == 0)
            return 5;
        else if(letter.compareTo("L") == 0)
            return 1;
        else if(letter.compareTo("M") == 0)
            return 3;
        else if(letter.compareTo("N") == 0)
            return 1;
        else if(letter.compareTo("O") == 0)
            return 1;
        else if(letter.compareTo("P") == 0)
            return 3;
        else if(letter.compareTo("Q") == 0)
            return 10;
        else if(letter.compareTo("R") == 0)
            return 1;
        else if(letter.compareTo("S") == 0)
            return 1;
        else if(letter.compareTo("T") == 0)
            return 1;
        else if(letter.compareTo("U") == 0)
            return 1;
        else if(letter.compareTo("V") == 0)
            return 4;
        else if(letter.compareTo("W") == 0)
            return 4;
        else if(letter.compareTo("X") == 0)
            return 8;
        else if(letter.compareTo("Y") == 0)
            return 4;
        else
            return 10;
    }
}


