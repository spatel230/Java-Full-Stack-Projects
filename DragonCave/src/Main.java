import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Random rd=new Random();
        int in_guess=0;
        int friendly=rd.nextInt(2)+1;
        //System.out.println(x);
        System.out.println("You are in a land full of dragons. In front of you, \nyou see two caves. In one cave, the dragon is friendly\nand will share his treasure with you. The other dragon\nis greedy and hungry and will eat you on sight.");
        while(in_guess!=1&&in_guess!=2){
            System.out.println("Which cave will you go into? (1 or 2)");
            in_guess=sc.nextInt();
            if(in_guess!=1&&in_guess!=2) System.out.println(in_guess+" is not a cave fit for humans");
        }
        System.out.println("you approach the cave...");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("It is dark and spooky...");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("A large dragon jumps out in front of you! He opens his jaws and...");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(in_guess==friendly){
            System.out.println("Yells,\"welcome best friend, what would you like?");
        }
        if(in_guess!=friendly){
            System.out.println("Gobbles you down in one bite!");
        }



    }
}
