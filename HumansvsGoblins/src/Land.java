import java.util.Random;

public class Land {
    int x;
    int y;
    public Land(int x, int y){
        this.x=x;
        this.y=y;
    }
    public Land(){
        this.x=x;
        this.y=y;
    }
    public Land rdmoveChest(){
        Random rd=new Random();
        this.x=rd.nextInt(20);
        this.y=rd.nextInt(20);
        return new Land(x,y);
    }
    public int rdmoveGoblin(){
        Random rd=new Random();
        return (rd.nextInt(4)+1);
    }
    public int moveGoblin(player p, goblins g){
        if(g.x>p.x) return 4;
        if(g.x<p.x) return 3;
        if(g.y<p.y) return 2;
        if(g.y>p.y) return 1;
        return rdmoveGoblin();
    }
    public boolean isempty(player p, goblins[] g, Land next){
        if(next.x==p.x&&next.y==p.y) return false;
        for(int i=0;i<=g.length-1;i++){
            if(g[i].x==next.x&&g[i].y==next.y) return false;
        }
        return true;
    }
    public boolean isinbounds(){
        if(x<0) return false;
        if(x>19) return false;
        if(y<0) return false;
        if(y>19) return false;
        return true;
    }
    public Land move(int x, int y){
        this.x=x;
        this.y=y;
        return new Land(this.x, this.y);
    }
    public void toString(player p, goblins[] g) {
        int[] spot = new int[g.length + 1];
        boolean found = false;
        spot[0] = p.y * 20 + p.x;
        for (int i = 0; i <= g.length - 1; i++) {
            spot[i + 1] = g[i].y * 20 + g[i].x;
        }
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                for (int k = 0; k < spot.length; k++) {
                    if (spot[k] == (i * 20 + j)) {
                        found = true;
                    }
                }
                if (found) {
                    if(spot[0]==(i * 20 + j)){
                        System.out.print("| P |");
                    }else {
                        System.out.print("| X |");
                        found = false;
                    }
                } else {
                    System.out.print("|   |");
                }
                found=false;
            }
            System.out.println();
        }
    }

}
