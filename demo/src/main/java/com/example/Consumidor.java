package com.example;

public class Consumidor implements Runnable {
    Buffer buffer;
    Consumidor(Buffer buffer)
    {
        this.buffer = buffer;
        new Thread(this, "Consumer").start();
    }
  
    public void run()
    {
        for (int i = 0; i < 5; i++)
            // consumer get items
            buffer.getItem();
    }
}
