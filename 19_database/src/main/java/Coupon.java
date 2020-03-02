public class Coupon {
    private String name;
    private String code;
    private int percentage;

    public Coupon() {
    }

    public Coupon(String name, String code, int percentage) {
        this.name = name;
        this.code = code;
        this.percentage = percentage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", percentage=" + percentage +
                '}';
    }
}
