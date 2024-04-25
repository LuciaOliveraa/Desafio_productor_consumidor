package com.example;

import java.util.concurrent.Semaphore;

public interface IBuffer {
   
  
   void getItem();
 
   void putItem(int item);
}
 