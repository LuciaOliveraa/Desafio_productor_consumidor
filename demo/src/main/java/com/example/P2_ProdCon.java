package com.example;

public class P2_ProdCon extends Thread {

    public P2_ProdCon(){}

    public void run() {
        while(true) {
            try {
                int item = Buffer.getInstance().consumeItem();
                System.out.println("Consumed P2: " + item);
                item = item*item;
                Buffer.getInstance().produceItem(item);
                System.out.println("Produced P2: " + item);
                Thread.sleep(1000); // Simula la producción
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
