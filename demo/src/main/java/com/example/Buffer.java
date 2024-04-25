package com.example;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.Semaphore;

public class Buffer implements IBuffer {

    private ArrayList buffer1;
    // an item
    private int item;

    public Buffer(int capacidad) {
        this.buffer1 = new ArrayList<>(capacidad);
        
    }
  
    // Inicializamos semConsumer en 0 para asegurarnos de que se produzca un elemento antes de que se intente consumir.
    static Semaphore semConsumer = new Semaphore(0);
    static Semaphore semProductor = new Semaphore(1);
    static Semaphore semFullVoid = new Semaphore(0);
 

    public void getItem()
    {
        try {
            semConsumer.acquire();
        }
        catch (InterruptedException e) {
            System.out.println("InterruptedException caught");
        }

        System.out.println("Consumer consumed item : " + item);
 
        semProductor.release();
    }
 

    public void putItem(int item)
    {
        try {
            semProductor.acquire();
        }
        catch (InterruptedException e) {
            System.out.println("InterruptedException caught");
        }

        this.item = item;
 
        System.out.println("Producer produced item : " + item);
 
        semConsumer.release();
    }
}
 