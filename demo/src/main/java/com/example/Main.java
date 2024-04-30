package com.example;

public class Main {
    public static void main(String[] args) {

        P1_Prod P1 = new P1_Prod();
        P2_ProdCon P2 = new P2_ProdCon();
        P3_ProdCon P3 = new P3_ProdCon();
        P4_Con P4 = new P4_Con();
        
        P1.start();
        P2.start();
        P3.start();
        P4.start();

    }
}