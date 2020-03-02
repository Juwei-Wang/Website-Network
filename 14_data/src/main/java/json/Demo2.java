package json;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import entity.Point;

import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class Demo2 {
    public static void main(String[] args) {
        {
            //  业务对象
            Point point = new Point(3, 4);

            //  业务对象 -> JSON 对象
            JsonObject pointJson = new JsonObject();
            pointJson.addProperty("x", point.getX());
            pointJson.addProperty("y", point.getY());

            //  JSON 对象 -> JSON 字符串
            String json = new Gson().toJson(pointJson);
            // Gson -> JsonCoder
            // encode toJson
            // decode fromJson

            System.out.println(json);
        }
        {
            //  JSON String
            String json = "{'x': 3, 'y': 4}";

            //  JSON String -> JSON 对象
            JsonObject pointJson = new Gson().fromJson(json, JsonObject.class);

            //  JSON 对象 -> 业务对象
            Point point = new Point();
            point.setX(pointJson.get("x").getAsInt());
            point.setY(pointJson.get("y").getAsInt());

            System.out.println(point);
        }
        {
            Point point = new Point(3, 4);

            //  业务对象 -> JSON 字符串
            String json = new Gson().toJson(point);

            System.out.println(json);
        }
        {
            //  JSON 字符串
            String json = "{'x': 3, 'y': 4}";

            //  JSON 字符串 -> 业务对象
            Point point = new Gson().fromJson(json, Point.class);

            System.out.println(point);
        }
        {
            Method[] fields = Point.class.getMethods();
            for (Method field : fields) {
                System.out.println(field.getName());
            }
        }
    }
}
