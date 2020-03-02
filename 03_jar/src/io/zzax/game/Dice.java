package io.zzax.game;

public class Dice {
    public static int roll(int max) {
        return (int)(Math.random() * max) + 1;
    }
}
