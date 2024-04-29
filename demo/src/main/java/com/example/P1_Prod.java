package com.example;

import java.util.Random;

class P1_Prod extends Thread {
    Buffer buffer;

    public P1_Prod (Buffer buffer) {
        this.buffer = buffer;
        //new Thread(this, "Producer").start();
    }
  
    public void run()
    {
        try {
            Random randomGenerator = new Random();
            int random = randomGenerator.nextInt(11);
            buffer.produceItem(random);

            System.out.println("Produced random P1: " + random);
            Thread.sleep(100); // Simula la producción
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}