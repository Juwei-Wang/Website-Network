import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Sort {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<Integer>();
        list.add(6);
        list.add(5);
        Collections.sort(list);
        // 有可能会排序成功，基础类型， + STring
        System.out.println(list);

        List<Integer> lists = new LinkedList<Integer>();
        lists.add(76);
        lists.add(57);
        lists.add(63);
        lists.add(38);
        lists.add(64);
        Collections.sort(lists,new SpecialComparator());
//      lists.sort(new SpecialComparator());
        System.out.println(lists);

        // 有可能会排序成功，基础类型， + STring
        //ComparingResult.Ascending
        List<Point> listz = new LinkedList<Point>();
        listz.add(new Point(5,6));
        listz.add(new Point(8,6));
        listz.add(new Point(9,6));
        listz.add(new Point(4,6));
        listz.add(new Point(5,6));
        Collections.sort(listz,new PointComparator());
//      lists.sort(new SpecialComparator());
        System.out.println(listz);
//        PointComparator c = new PointComparator();
//        Comparator<Point> reseverd =


    }
}
