package com.example;

public class Counter implements AutoCloseable {
    boolean run = false;
    int counter = 0;

    public Counter() {
        run = true;
    }

    public Counter(int count) {
        run = true;
        this.counter = count;
    }

    public void increment() {
        this.counter++;
    }

    public void close() {
        run = false;
    }
}
