package after.client;

import srrp.Request;
import srrp.Response;
import srrp.SRRPClient;

public class client {
    public static void main(String[] args) {
        String action = "add";

        double value1 = 4;
        double value2 = 6;

        String data = value1 + "," + value2;

        Request request = new Request(action,data);
        Response response = new SRRPClient().send(request);

        if (response.ok()){
            System.out.println(response.getData());
        }else{
            System.out.println(response.getStatus());
        }
    }
}
