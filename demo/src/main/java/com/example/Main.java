package com.example;

public class Main {
    public static void main(String[] args) {
        
        Buffer buffer1 = new Buffer(30);
        Buffer buffer2 = new Buffer(30);

        P1_Prod P1 = new P1_Prod(buffer1);
        P2_ProdCon P2 = new P2_ProdCon(buffer1);
        P3_ProdCon P3 = new P3_ProdCon(buffer1, buffer2);
        P4_Con P4 = new P4_Con(buffer2);
        
        P1.start();
        P2.start();
        P3.start();
        P4.start();

    }
}