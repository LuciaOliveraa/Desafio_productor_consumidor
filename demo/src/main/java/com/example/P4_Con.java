package com.example;

public class P4_Con extends Thread {

    public P4_Con(){}

    public void run() {
        while(true) {
            try {
                int item = Buffer2.getInstance().consumeItem();
                System.out.println("Consumed P4: " + item);
                Thread.sleep(1000); // Simula la producción
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
