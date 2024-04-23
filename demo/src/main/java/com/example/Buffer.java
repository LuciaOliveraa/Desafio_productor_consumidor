package com.example;

import java.lang.System.Logger.Level;
import java.util.logging.Logger;


public class Buffer {
    private int[] buffer; 
    private int siguiente; 
    private boolean estaVacia; 
    private boolean estaLlena; 

    public Buffer(int capacidad){
        this.buffer = new int[capacidad];
        this.siguiente = 0;
        this.estaVacia = true; 
        this.estaLlena = false; 
    }

    public synchronized int consumir(){
        while (this.estaVacia){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    public synchronized void producir(int c){
        while (this.estaLlena){
            try {
                wait();
            //está registrando un mensaje de nivel grave junto con la 
            //información de una excepción asociada, utilizando el
            //sistema de registro de Java.
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null,ex);
            } 
        }

        buffer[siguiente] = c; 
        siguiente++;

        this.estaVacia = false;
        if(siguiente == this.buffer.length){
            this.estaLlena= true; 
        }

        /*
         * notifica a todos los hilos que están en espera sobre 
         * un cambio en el recurso compartido. 
         */
        notifyAll();
    }
}
