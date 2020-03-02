package Net;

import srrp.Request;
import srrp.Response;
import srrp.SRRPClient;

public class Client {
    public static void main(String[] args) {
        long time1 = System.currentTimeMillis();
        Response response = new SRRPClient().send(new Request("wait", ""));
        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);
    }
}
