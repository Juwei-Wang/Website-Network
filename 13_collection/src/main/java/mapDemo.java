import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class mapDemo {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<String, Integer>();
        map.put("a",1);
        map.put("b",1);
        //key可以用STRING 但是绝对不可以重复
        System.out.println(map.get("A"));
        System.out.println(map.size());
        //map离散数组
        //list连续数组
        //map.remove("A")

        Map<String,Integer> mapz = new HashMap<String, Integer>();
        mapz.put("a",1);
        mapz.put("b",1);


        Set<String> keys = mapz.keySet();
        for (String key : keys) {
            System.out.println(key + map.get(key));
        }


        Set<Map.Entry<String,Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }


        Collection<Integer> values = map.values();
        // 没有顺序，可以重复 // Bag
        for (Integer value : values) {
            System.out.println(value);
        }

    }
}
