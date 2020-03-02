package Office;

public class Bathroom {
    public void serve(Person person) {
        synchronized (this) {
            String message;

            message = String.format("%s 进 厕所", person.getName());
            System.out.println(message);

            for (int i = 0; i < 100; i++) {
                message = String.format("%s 正在使用厕所 %d%%", person.getName(), i + 1);
                System.out.println(message);
            }
            person.release();

            message = String.format("%s 出 厕所", person.getName());
            System.out.println(message);
        }
    }
}
