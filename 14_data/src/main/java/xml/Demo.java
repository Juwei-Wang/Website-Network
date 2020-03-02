package xml;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import entity.Point;

public class Demo {
    public static void main(String[] args) throws Exception {
        {
            //  业务对象
            Point point = new Point(3, 4);

            //  业务对象 -> XML 字符串
            String xml = new XmlMapper().writeValueAsString(point);

            System.out.println(xml);
        }
        {
            //  XML 字符串
            String xml = "<Point><x>3</x><y>4</y></Point>";

            //  XML 字符串 -> 业务对象
            Point point = new XmlMapper().readValue(xml, Point.class);

            System.out.println(point);
        }
    }
}
