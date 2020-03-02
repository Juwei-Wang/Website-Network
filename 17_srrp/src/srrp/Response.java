package srrp;

public class Response {
    private String status;
    private String data;
    public static final String ok = "ok";

    public Response() {
    }

    public Response(String status) {
        this.status = status;
    }

    public Response(String status, String data) {
        this.status = status;
        this.data = data;
    }

    public boolean ok() {
        return status.equals(ok);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
