package com.example;

import java.util.concurrent.Semaphore;

public class BufferPrueba {
    private int[] buffer;
    private int size;
    private int in;
    private int out;
    private Semaphore mutex;
    private Semaphore empty;
    private Semaphore full;

    public BufferPrueba(int bufferSize) {
        this.size = bufferSize;
        this.buffer = new int[size];
        this.in = 0;
        this.out = 0;
        this.mutex = new Semaphore(1); // Mutex para exclusión mutua
        this.empty = new Semaphore(size); // Semáforo para espacios vacíos
        this.full = new Semaphore(0); // Semáforo para elementos llenos
    }

    public void produce(int item) throws InterruptedException {
        empty.acquire(); // Espera si no hay espacio vacío
        mutex.acquire(); // Bloquea el acceso al buffer
        buffer[in] = item;
        in = (in + 1) % size;
        mutex.release(); // Libera el acceso al buffer
        full.release(); // Aumenta el contador de elementos llenos
    }

    public int consume() throws InterruptedException {
        full.acquire(); // Espera si no hay elementos llenos
        mutex.acquire(); // Bloquea el acceso al buffer
        int item = buffer[out];
        out = (out + 1) % size;
        mutex.release(); // Libera el acceso al buffer
        empty.release(); // Aumenta el contador de espacios vacíos
        return item;
    }
}
