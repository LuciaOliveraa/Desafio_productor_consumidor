package com.example;

class Productor implements Runnable {
    Buffer buffer;

    Productor(Buffer buffer)
    {
        this.buffer = buffer;
        new Thread(this, "Producer").start();
    }
  
    public void run()
    {
        for (int i = 0; i < 5; i++)
            // producer put items
            buffer.put(i);
    }
}