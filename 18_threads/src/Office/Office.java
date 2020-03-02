package Office;

public class Office {
    public static void main(String[] args) {
        Bathroom bathroom = new Bathroom();

        Person p1 = new Person("小明");
        Person p2 = new Person("小红");

        p1.setBathroom(bathroom);
        p2.setBathroom(bathroom);

        new Thread(p1).start();
        new Thread(p2).start();

    }
}