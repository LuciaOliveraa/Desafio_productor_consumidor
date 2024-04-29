package com.example;

public class P2_ProdCon extends Thread {
    Buffer buffer;

    public P2_ProdCon(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        try {
            int item = buffer.consumeItem();
            System.out.println("Consumed P2: " + item);
            item = item^2;
            buffer.produceItem(item);
            System.out.println("Produced P2: " + item);
            Thread.sleep(100); // Simula la producción
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
