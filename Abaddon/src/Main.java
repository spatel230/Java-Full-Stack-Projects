import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
    ArrayList
            int temp;
            for (int i = 0; i < list.size()/2; i++) {
                temp=list.indexOf(i);
                list.add(i,list.get(list.size()-i-1));
                list.add(list.size()-i-1,temp);

            }
}
