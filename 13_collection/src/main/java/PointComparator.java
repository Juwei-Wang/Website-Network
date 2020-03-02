import java.util.Comparator;

public class PointComparator implements Comparator<Point> {

    public int compare(Point o1, Point o2) {
        return o1.x - o2.x;
//      return Integer.compare(value(o1),value(o2));

    }

    private int value(Point p){
        return p.x;
    }
}
