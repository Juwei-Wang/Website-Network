import java.util.Comparator;

public class SpecialComparator implements Comparator<Integer> {


    public int compare(Integer o1, Integer o2) {
        int d1 = o1 % 10;
        int d2 = o2 % 10;
        if (d1 < d2) {
            return -1;
        } else if (d1 > d2) {
            return 1;
        } else {
            return 0;
        }
    }

}
