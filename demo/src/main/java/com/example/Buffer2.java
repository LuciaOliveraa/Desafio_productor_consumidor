//Singleton example: https://refactoring.guru/es/design-patterns/singleton/java/example
package com.example;

import java.util.concurrent.Semaphore;

public final class Buffer2 {

    private static Buffer2 instance;

    private int[] buffer;
    private static final int size = 30;
    private int inItem;
    private int outItem;

    private Semaphore semConsumer;
    private Semaphore semProducer;
    private Semaphore semMutex;
    
    private Buffer2() {
        // The following code emulates slow initialization.
        /*try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }*/

        this.buffer = new int[size];

        this.inItem = 0;
        this.outItem = 0;
        this.semConsumer = new Semaphore(0);
        this.semProducer = new Semaphore(size);
        this.semMutex = new Semaphore(1);
    }

    public static synchronized Buffer2 getInstance() {
        if (instance == null) {
            instance = new Buffer2();
        }
        return instance;
    }
  
    // Inicializamos semConsumer en 0 para asegurarnos de que se produzca un elemento antes de que se intente consumir.
    //static Semaphore semConsumer = new Semaphore(0);
    //static Semaphore semProducer = new Semaphore(size);
    //static Semaphore semMutex = new Semaphore(1);
 
    public void produceItem(int item) throws InterruptedException {
        semProducer.acquire();
        semMutex.acquire();
        buffer[inItem] = item;
        inItem = (item + 1) % size;

        semMutex.release();
        semConsumer.release();
    }

    public int consumeItem() throws InterruptedException {
        semConsumer.acquire();
        semMutex.acquire();
        int item = buffer[outItem];
        outItem = (outItem + 1) % size;

        semMutex.release();
        semProducer.release();
        return item;
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
 