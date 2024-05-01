
package com.example;

public class P3_ProdCon extends Thread {
    //Buffer buffer1;
    //Buffer2 buffer2;

    public P3_ProdCon() {//(Buffer buffer1, Buffer2 buffer2) {
        //this.buffer1 = buffer1;
        //this.buffer2 = buffer2;
    }

    public void run() {
        while(true) {
            try {
                int item1B1 = Buffer.getInstance().consumeItem();
                int item2B1 = Buffer.getInstance().consumeItem();
                System.out.println("Consumed P3: " + item1B1 + ", " + item2B1);

                int item = item1B1 + item2B1;
                Buffer2.getInstance().produceItem(item);
                
                System.out.println("Produced P3: " + item);
                Thread.sleep(1000); // Simula la producción
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
