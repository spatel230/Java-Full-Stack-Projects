import java.util.Random;

public class player {
    String name;
    int[] inventory;
    int health;
    int x, y;
    public player(String name, int health, int[] inventory, int x, int y){
        this.name=name;
        this.health=health;
        this.inventory=inventory;
        this.x=x;
        this.y=y;
    }
    public String toString(){
        return "Player Name: "+name+"\tPlayer Health: "+health+"\tInventory: ("+inventory[0]+", "+inventory[1]+", "+inventory[2]+")\tLocation:("+x+", "+y+")";
    }

    public void healup(int i) {
        health+=inventory[i]*10;
        inventory[i]=0;
    }
    public void attacked(){
        Random rd=new Random();
        health-=rd.nextInt(20);
    }
}
