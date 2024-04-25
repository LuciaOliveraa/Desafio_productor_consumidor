package com.example;

public class Main {
    public static void main(String[] args) {
        // creating buffer queue
        Buffer buffer = new Buffer();
  
        // starting consumer thread
        new Consumidor(buffer);
  
        // starting producer thread
        new Productor(buffer);
    }
}