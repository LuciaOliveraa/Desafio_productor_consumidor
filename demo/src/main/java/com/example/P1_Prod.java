package com.example;

import java.util.Random;

class P1_Prod extends Thread {

    public P1_Prod(){}
  
    public void run()
    {
        while (true) {
            try {
                Random randomGenerator = new Random();
                int random = randomGenerator.nextInt(11);
                Buffer.getInstance().produceItem(random);

                System.out.println("Produced random P1: " + random);
                Thread.sleep(1000); // Simula la producción
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}