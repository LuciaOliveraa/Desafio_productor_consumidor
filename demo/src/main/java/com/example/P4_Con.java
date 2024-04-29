package com.example;

public class P4_Con extends Thread {
    Buffer buffer2;

    public P4_Con(Buffer buffer) {
        this.buffer2 = buffer;
    }

    public void run() {
        try {
            int item = buffer2.consumeItem();
            System.out.println("Consumed P4: " + item);
            Thread.sleep(100); // Simula la producción
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
