import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String Name;
        int[] d1 = {1, 3, 5};
        int[] d2 = {2, 3, 4};
        int[] d3 = {1, 2, 3};
        int[] d4 = {6, 9, 2};
        Land next = new Land();
        Chest find = new Chest();
        goblins g1 = new goblins("Yellow Goblin", 100, d1, 0, 0);
        goblins g2 = new goblins("Blue Goblin", 100, d2, 0, 19);
        goblins g3 = new goblins("Green Goblin", 100, d3, 19, 19);
        goblins g4 = new goblins("Brown Goblin", 100, d4, 19, 0);
        goblins[] enemy = {g1, g2, g3, g4};
        int turn, temp;
        System.out.println("What is your players name?");
        Name = sc.next();
        player p1 = new player(Name, 100, d4, 10, 10);
        while (p1.health > 0) {
            next.toString(p1, enemy);
            next = next.rdmoveChest();
            find.x = next.x;
            find.y = next.y;
            System.out.println("What would you like to do?(1 to Move, 2 to Check Health, 3 to Check Inventory 4 to Use Inventory)");
            turn = sc.nextInt();
            if (turn == 2 || turn == 3) doCheck(turn, p1);
            else if (turn == 4) p1 = useInventory(p1);
            else {
                for (int i = 0; i <= enemy.length - 1; i++) {
                    if (enemy[i].health > 0) {
                        turn = next.rdmoveGoblin();
                        turn = next.moveGoblin(p1, enemy[i]);
                        if (turn == 1) {
                            next.x = enemy[i].x;
                            next.y = enemy[i].y - 1;
                        }
                        if (turn == 2) {
                            next.x = enemy[i].x;
                            next.y = enemy[i].y + 1;
                        }
                        if (turn == 3) {
                            next.x = enemy[i].x + 1;
                            next.y = enemy[i].y;
                        }
                        if (turn == 4) {
                            next.x = enemy[i].x - 1;
                            next.y = enemy[i].y;
                        }
                        if (next.isempty(p1, enemy, next) && next.isinbounds()) {
                            enemy[i].x = next.x;
                            enemy[i].y = next.y;
                        }
                    }
                }
                System.out.println("What direction would you like to move?(1 for North, 2 for South, 3 for East, 4 for West)");
                turn = sc.nextInt();
                if (turn == 1) {
                    next.x = p1.x;
                    next.y = p1.y - 1;
                }
                if (turn == 2) {
                    next.x = p1.x;
                    next.y = p1.y + 1;
                }
                if (turn == 3) {
                    next.x = p1.x + 1;
                    next.y = p1.y;
                }
                if (turn == 4) {
                    next.x = p1.x - 1;
                    next.y = p1.y;
                }
                if (next.isempty(p1, enemy, next) && next.isinbounds()) {
                    p1.x = next.x;
                    p1.y = next.y;
                }
                turn = 0;
                for (int i = 0; i <= enemy.length - 1; i++) {
                    if (enemy[i].x + 1 == p1.x || enemy[i].x - 1 == p1.x || enemy[i].x == p1.x) {
                        if (enemy[i].y + 1 == p1.y || enemy[i].y - 1 == p1.y || enemy[i].y == p1.y) {
                            turn = i;
                            break;
                        }
                    }
                    if (enemy[i].y + 1 == p1.y || enemy[i].y - 1 == p1.y || enemy[i].y == p1.y) {
                        if (enemy[i].x + 1 == p1.x || enemy[i].x - 1 == p1.x || enemy[i].x == p1.x) {
                            turn = i;
                            break;
                        }
                    }
                }
                PrintAllStats(enemy, p1, find);
                if (ifneighbors(enemy[turn], p1) && enemy[turn].health > 0) {
                    p1.attacked();
                    enemy[turn].attacked();
                }
                if (ifneighbors(enemy[turn], p1) && enemy[turn].health <= 0) {
                    System.out.println("What do you want from the dead body?(Item 1: " + enemy[turn].drops[0] + ", Item 2: " + enemy[turn].drops[1] + ", Item 3: " + enemy[turn].drops[2]+")");
                    temp = sc.nextInt() - 1;
                    p1.inventory[smallest(p1)] = enemy[turn].drops[temp];
                    enemy[turn].drops[temp] = 0;
                }
                if (ifneighbors(find, p1)) {
                    System.out.println("What do you want from the chest?(Item 1: " + find.drops[0] + ", Item 2: " + find.drops[1] + ", Item 3: " + find.drops[2]+")");
                    turn = sc.nextInt() - 1;
                    temp=p1.inventory[smallest(p1)];
                    p1.inventory[smallest(p1)] = find.drops[turn];
                    find.drops[turn] = temp;
                }
            }
        }
    }

    public static int smallest(player p) {
        int min = p.inventory[0];
        int send = 0;
        for (int i = 0; i < 3; i++) {
            if (p.inventory[i] < min) {
                min = p.inventory[i];
                send = i;
            }
        }
        return send;
    }

    public static void doCheck(int turn, player p) {
        if (turn == 2) {
            System.out.println(p.name + "'s health is " + p.health);
        }
        if (turn == 3) {
            System.out.println(p.name + "'s inventory has " + p.inventory[0] + ", " + p.inventory[1] + ", " + p.inventory[2]);
        }
    }

    public static boolean ifneighbors(goblins enemy, player p1) {
        if (enemy.x + 1 == p1.x || enemy.x - 1 == p1.x || enemy.x == p1.x) {
            if (enemy.y + 1 == p1.y || enemy.y - 1 == p1.y || enemy.y == p1.y) {
                return true;
            }
        }
        if (enemy.y + 1 == p1.y || enemy.y - 1 == p1.y || enemy.y == p1.y) {
            if (enemy.x + 1 == p1.x || enemy.x - 1 == p1.x || enemy.x == p1.x) {
                return true;
            }
        }
        return false;
    }

    public static boolean ifneighbors(Chest find, player p1) {
        if (find.x + 1 == p1.x || find.x - 1 == p1.x || find.x == p1.x) {
            if (find.y + 1 == p1.y || find.y - 1 == p1.y || find.y == p1.y) {
                return true;
            }
        }
        if (find.y + 1 == p1.y || find.y - 1 == p1.y || find.y == p1.y) {
            if (find.x + 1 == p1.x || find.x - 1 == p1.x || find.x == p1.x) {
                return true;
            }
        }
        return false;
    }

    public static void PrintAllStats(goblins[] enemy, player p, Chest find) {
        for (int i = 0; i < enemy.length; i++) {
            System.out.println(enemy[i].toString());
        }
        System.out.println(p.toString());
        System.out.println(find.toString());
    }

    public static player useInventory(player p) {
        Scanner sc = new Scanner(System.in);
        int turn = 0;
        System.out.println(p.name + "'s inventory has " + p.inventory[0] + ", " + p.inventory[1] + ", " + p.inventory[2]);
        System.out.println("What item would you like to use?(1 for Item 1, 2 for Item 2, 3 for Item 3)");
        turn = sc.nextInt() - 1;
        p.healup(turn);
        p.inventory[turn] = 0;
        return p;
    }
}