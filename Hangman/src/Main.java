import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        String[] words = new String[]{"ball", "bate", "fall"};
        boolean pa = true, correct = false;
        int i;
        String word;
        String guess;
        char cguess;
        char[] test = new char[4];
        while (pa) {
            for( char c: test) c=' ';
            word = words[rd.nextInt(3)];
            i = 0;
            pa=false;
            System.out.println("HANGMAN");
            while (i <= 7) {
                man(i);
                for (char c : test) {
                    if (c == ' ') {
                        System.out.print("_");
                    } else {
                        System.out.print(c);
                    }
                }
                System.out.println();
                System.out.println("What is your guess?");
                guess = sc.next().toLowerCase(Locale.ROOT);
                cguess = guess.charAt(0);
                for (int j = 0; j < word.length(); j++) {
                    if (guess.equals(word.substring(j, j + 1))) {
                        System.out.println(cguess + " is in the word.");
                        test[j] = cguess;
                        correct = true;
                    }
                }
                if (correct) {
                    correct = false;
                } else {
                    correct = false;
                    i++;
                }
                if(isdone(test, word)) {
                    System.out.println("this");
                    pa=Playagain();
                    i=9;
                }
                if(i==7){ pa=Playagain(); i=9; man(7);}
            }
        }
    }
    public static void man(int i){
        if (i == 0) man0();
        if (i == 1) man1();
        if (i == 2) man2();
        if (i == 3) man3();
        if (i == 4) man4();
        if (i == 5) man5();
        if (i == 6) man6();
        if (i == 7) man7();
    }

    public static boolean isdone(char[] t, String word){
        for(int i=0;i<word.length();i++){
            if(t[i]!=word.charAt(i)){
                return false;
            }
        }
        return true;
    }

    public static boolean Playagain() {
        Scanner sc = new Scanner(System.in);
        String pa;
        while (true) {
            System.out.println("Would you like to play again?(Y or N)");
            pa = sc.next();
            if (pa.equals("y") || pa.equals("Y")) return true;
            if (pa.equals("n") || pa.equals("N")) return false;
            System.out.println("You have selected a void option. Please try again.");
        }
    }

    public static void man0() {
        System.out.println("+---+");
        System.out.println("    |");
        System.out.println("    |");
        System.out.println("    |");
        System.out.println("    |");
        System.out.println("=====");
    }

    public static void man1() {
        System.out.println("+---+");
        System.out.println(" o  |");
        System.out.println("    |");
        System.out.println("    |");
        System.out.println("    |");
        System.out.println("=====");
    }

    public static void man2() {
        System.out.println("+---+");
        System.out.println(" o  |");
        System.out.println(" |  |");
        System.out.println("    |");
        System.out.println("    |");
        System.out.println("=====");
    }

    public static void man3() {
        System.out.println("+---+");
        System.out.println(" o  |");
        System.out.println(" |  |");
        System.out.println(" |  |");
        System.out.println("    |");
        System.out.println("=====");
    }

    public static void man4() {
        System.out.println("+---+");
        System.out.println(" o  |");
        System.out.println("-|  |");
        System.out.println(" |  |");
        System.out.println("    |");
        System.out.println("=====");
    }

    public static void man5() {
        System.out.println("+---+");
        System.out.println(" o  |");
        System.out.println("-|- |");
        System.out.println(" |  |");
        System.out.println("    |");
        System.out.println("=====");
    }

    public static void man6() {
        System.out.println("+---+");
        System.out.println(" o  |");
        System.out.println("-|- |");
        System.out.println(" |  |");
        System.out.println("/   |");
        System.out.println("=====");
    }

    public static void man7() {
        System.out.println("+---+");
        System.out.println(" o  |");
        System.out.println("-|- |");
        System.out.println(" |  |");
        System.out.println("/ \\ |");
        System.out.println("=====");
    }
}
