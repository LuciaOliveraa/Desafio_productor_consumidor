package com.example;

public class P4_Con extends Thread {
    //Buffer2 buffer2;

    public P4_Con(){//(Buffer2 buffer) {
        //this.buffer2 = buffer;
    }

    public void run() {
        while(true) {
            try {
                int item = Buffer2.getInstance().consumeItem();
                System.out.println("Consumed P4: " + item);
                Thread.sleep(100); // Simula la producción
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
