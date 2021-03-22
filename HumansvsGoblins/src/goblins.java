import java.util.Random;

public class goblins {
    String name;
    int health;
    int[] drops;
    int x,y;
    public goblins(String name, int health, int[] drops, int x, int y){
        this.name=name;
        this.health=health;
        this.drops=drops;
        this.x=x;
        this.y=y;
    }

    public String toString(){
        return "Goblin Name: "+name+"\tGoblin Health: "+health+"\tDrops: ("+drops[0]+", "+drops[1]+", "+drops[2]+")\tLocation:("+x+", "+y+")";
    }
    public void attacked(){
        Random rd=new Random();
        health-=rd.nextInt(30);
    }
}
