package Net;

import srrp.Handler;
import srrp.Request;
import srrp.Response;

public class BlockingHandler implements Handler {
    @Override
    public void handle(Request request, Response response) {
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        response.setStatus(Response.ok);
        response.setData("long");
    }
}
