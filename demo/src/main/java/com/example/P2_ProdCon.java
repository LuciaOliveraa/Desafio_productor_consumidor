package com.example;

public class P2_ProdCon extends Thread {
    //Buffer buffer;

    public P2_ProdCon(){//(Buffer buffer) {
       // this.buffer = buffer;
    }

    public void run() {
        while(true) {
            try {
                int item = Buffer.getInstance().consumeItem();
                System.out.println("Consumed P2: " + item);
                item = item^2;
                Buffer.getInstance().produceItem(item);
                System.out.println("Produced P2: " + item);
                Thread.sleep(100); // Simula la producción
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
