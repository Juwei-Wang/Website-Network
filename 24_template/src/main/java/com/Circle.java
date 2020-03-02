package com;

public class Circle {
    private Point origin;
    private int radius;

    public Circle() {
    }

    public Circle(Point origin, int radius) {
        this.origin = origin;
        this.radius = radius;
    }

    public Point getOrigin() {
        return origin;
    }

    public void setOrigin(Point origin) {
        this.origin = origin;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
