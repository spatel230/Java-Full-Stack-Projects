import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random rd = new Random();
        Scanner sc = new Scanner(System.in);
        boolean pa = true;
        int guess, count;
        int number;
        String name;
        System.out.println("Hello! What is your name?");
        name = sc.next();
        System.out.println("Well, " + name + ", I am thinking of a number between 1 and 20.");
        while (pa) {
            count=0;
            number = rd.nextInt(20) + 1;
            while (count <= 6) {
                System.out.println("Take a guess.");
                if (count == 6) System.out.println("Last try.");
                guess = sc.nextInt();
                if (guess > number) System.out.println("Your guess is to high.");
                if (guess < number) System.out.println("Your guess is to low.");
                if (guess == number) {
                    System.out.println("Good job, " + name + "! You guessed my number in " + count + " guesses!");
                    pa = Playagain();
                    count=7;
                }
                count++;
                if(count==6){
                    System.out.println("You are out of tries.");
                    pa= Playagain();
                }
            }
        }
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
}