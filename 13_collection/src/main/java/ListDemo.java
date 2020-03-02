import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);

        int[] arr = {6,7,8,9,0};
        List<Integer> integers = Arrays.asList(ArrayUtils.toObject(arr));
        System.out.println(integers);

        String[] term = {"6","7"};
        List<String> termList = Arrays.asList(term);
        System.out.println(termList);

        termList.toArray();



    }
}
