import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Random rd=new Random();
        char[] poss = new char[9];
        boolean pa=true, winner, cpugo=true, usgo=true;
        char us, cpu;
        String usin;
        int cputurn, usturn;
        System.out.println("Welcome to Tic-Tac-Toe!");
        while(pa) {
            Arrays.fill(poss, ' ');
            winner=false;
            System.out.println("Do you want to be X or O?");
            usin=sc.next().toUpperCase();
            us=usin.charAt(0);
            if(us=='X'){
                cpu='O';
            }else cpu='X';
            System.out.println("The computer will go first.");
            while(!winner){
                while(cpugo){
                    cputurn=rd.nextInt(9);
                    if(isempty(poss,cputurn)){
                        cpugo=false;
                        poss[cputurn]=cpu;
                    }
                    if(checkifwon(poss)){
                        System.out.println("Computer has won");
                        print(poss);
                        winner=true;
                        pa=Playagain();
                    }
                }
                print(poss);
                System.out.println("What is your next move?(1-9)");
                while(usgo) {
                    usturn = sc.nextInt()-1;
                    if(isempty(poss,usturn)){
                        usgo=false;
                        poss[usturn]=us;
                    }
                    if(checkifwon(poss)){
                        System.out.println("you won");
                        print(poss);
                        winner=true;
                        pa=Playagain();
                    }
                }
                cpugo=true;
                usgo=true;
            }
        }

    }
    public static void print(char[] poss){
        System.out.println(poss[0]+" | "+poss[1]+" | "+poss[2]);
        System.out.println("----------");
        System.out.println(poss[3]+" | "+poss[4]+" | "+poss[5]);
        System.out.println("----------");
        System.out.println(poss[6]+" | "+poss[7]+" | "+poss[8]);
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
    public static boolean checkifwon(char[] poss){
        if(poss[0]==poss[1]&&poss[1]==poss[2]&&poss[0]!=' ') return true;
        if(poss[3]==poss[4]&&poss[4]==poss[5]&&poss[3]!=' ') return true;
        if(poss[6]==poss[7]&&poss[7]==poss[8]&&poss[6]!=' ') return true;
        if(poss[0]==poss[3]&&poss[3]==poss[6]&&poss[0]!=' ') return true;
        if(poss[1]==poss[4]&&poss[4]==poss[7]&&poss[1]!=' ') return true;
        if(poss[2]==poss[5]&&poss[5]==poss[8]&&poss[2]!=' ') return true;
        if(poss[0]==poss[4]&&poss[4]==poss[8]&&poss[0]!=' ') return true;
        if(poss[6]==poss[4]&&poss[4]==poss[2]&&poss[6]!=' ') return true;
        return false;
    }
    public static boolean isempty(char[] poss, int n){
        if(poss[n]==' ') return true;
        return false;
    }

}
