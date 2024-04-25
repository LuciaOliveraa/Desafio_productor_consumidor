package com.example;

class ProducerPrueba extends Thread {
    private BufferPrueba buffer;
    
    public ProducerPrueba(BufferPrueba buffer) {
    this.buffer = buffer;
    }
    
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                buffer.produce(i);
                System.out.println("Produced: " + i);
                Thread.sleep(100); // Simula la producción
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
    