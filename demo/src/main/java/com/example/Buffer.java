package com.example;

import java.util.concurrent.Semaphore;

public class Buffer implements IBuffer {

    private int[] buffer;
    private static int size;
    private int inItem;
    private int outItem;

    public Buffer(int bufferSize) {
        this.size = bufferSize;
        this.buffer = new int[size];

        this.inItem = 0;
        this.outItem = 0;
    }
  
    // Inicializamos semConsumer en 0 para asegurarnos de que se produzca un elemento antes de que se intente consumir.
    static Semaphore semConsumer = new Semaphore(0);
    static Semaphore semProducer = new Semaphore(size);
    static Semaphore semMutex = new Semaphore(1);
 
    public void produceItem(int item) throws InterruptedException {
        semProducer.acquire();
        semMutex.acquire();
        buffer[inItem] = item;
        inItem = (item + 1) % size;

        semMutex.release();
        semConsumer.release();
    }

    public void consumeItem() throws InterruptedException {
        semConsumer.acquire();
        semMutex.acquire();
        int item = buffer[outItem];
        outItem = (outItem + 1) % size;

        semMutex.release();
        semProducer.release();
    }

    /*
    public void getItem()
    {
        try {
            semConsumer.acquire();
        }
        catch (InterruptedException e) {
            System.out.println("InterruptedException caught");
        }

        System.out.println("Consumer consumed item : " + item);
 
        semProducer.release();
    }
 

    public void putItem(int item)
    {
        try {
            semProducer.acquire();
        }
        catch (InterruptedException e) {
            System.out.println("InterruptedException caught");
        }

        this.item = item;
 
        System.out.println("Producer produced item : " + item);
 
        semConsumer.release();
    }*/
}
 