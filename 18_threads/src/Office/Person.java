package Office;

import java.util.Random;

public class Person implements Runnable{

    // Mark - Context

    private Bathroom bathroom;

    public Bathroom getBathroom() {
        return bathroom;
    }

    public void setBathroom(Bathroom bathroom) {
        this.bathroom = bathroom;
    }

    // Mark - Basic

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Mark - Drink

    private final static int capacity = 10;
    private int cups = 0;

    private void drink(int cups) {
        this.cups += cups;
        String message = String.format("%s 喝了 %d 杯水，当前状态 %d / %d", name, cups, this.cups, capacity);
        System.out.println(message);
        if (this.cups >= capacity) {
            bathroom.serve(this);
        }
    }

    public void release() {
        cups = 0;
    }

    // Mark - Life

    public void run() {
        for (int i = 0; i < 100; i++) {
            int cups = new Random().nextInt(3) + 1;
            drink(cups);
        }
    }
}
