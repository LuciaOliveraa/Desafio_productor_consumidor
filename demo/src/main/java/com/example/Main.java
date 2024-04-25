package com.example;

public class Main {
    public static void main(String[] args) {
        // creating buffer queue
       // Buffer buffer = new Buffer();
  
        // starting consumer thread
       // new Consumidor(buffer);
  
        // starting producer thread
        //new Productor(buffer);

            BufferPrueba buffer = new BufferPrueba(5);
            ProducerPrueba producer = new ProducerPrueba(buffer);
            ConsumerPrueba consumer = new ConsumerPrueba(buffer);
            
            producer.start();
            consumer.start();

    }
}