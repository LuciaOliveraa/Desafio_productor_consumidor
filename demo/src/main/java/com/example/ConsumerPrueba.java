package com.example;

class ConsumerPrueba extends Thread {
    private BufferPrueba buffer;
    
    public ConsumerPrueba(BufferPrueba buffer) {
        this.buffer = buffer;
    }
    
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                int item = buffer.consume();
                System.out.println("Consumed: " + item);
                Thread.sleep(200); // Simula el consumo
        }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    }