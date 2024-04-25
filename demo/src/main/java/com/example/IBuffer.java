package com.example;

import java.util.concurrent.Semaphore;

public interface IBuffer {
   
   public void produceItem(int item) throws InterruptedException;

  public void consumeItem() throws InterruptedException;
}
 