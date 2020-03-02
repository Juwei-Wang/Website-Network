import java.util.HashSet;
import java.util.Set;

public class setDemo {
    public static void main(String[] args) {
        // 顺序不重要
        //也不可以重复
        //env环境变量

        Set<String> terms = new HashSet<String>();
        terms.add("A");
        terms.add("A");
        terms.add("B");
        System.out.println(terms.contains("A"));
        System.out.println(terms.size());
        terms.remove("A");
        for (String term : terms) {
            System.out.println(term);

        }



    }
}
