package after.server;

import srrp.Handler;
import srrp.Request;
import srrp.Response;

public class AddHandler implements Handler {
    @Override
    public void handle(Request request, Response response) {
        String[] parts = request.getData().split(",");
        double value1 = Double.parseDouble(parts[0]);
        double value2 = Double.parseDouble(parts[1]);

        double resultValue = value1 + value2;

        response.setStatus(Response.ok);
        response.setData(resultValue + "");
    }
}
