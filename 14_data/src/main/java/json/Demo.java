package json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class Demo {
    public static void main(String[] args) {
        {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("x", 3);
            jsonObject.addProperty("y", 4);

            System.out.println(new Gson().toJson(jsonObject));


            JsonObject circle = new JsonObject();
            circle.addProperty("radius", 2);
            circle.add("origin", jsonObject);

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println(gson.toJson(circle));
        }
        {
            String json = "{'x': 3, 'y': 4}";
            JsonObject jsonObject = new Gson().fromJson(json, JsonObject.class);
            System.out.println(jsonObject);
            System.out.println(jsonObject.get("x"));
        }


    }
}
