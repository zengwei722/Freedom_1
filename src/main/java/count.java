import java.util.ArrayList;

public class count {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList();
        for (int i = 1; i <= 10; i++) {
            al.add(i);
        }
        for (int i = 0; i < 8; i++) {
            if (al.size() > 2) {
                al.remove(2);
            }
            if (al.size() == 2){
                al.remove(0);
            }
        }
        //System.out.println(al);

    }
}
