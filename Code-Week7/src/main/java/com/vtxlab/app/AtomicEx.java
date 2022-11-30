package com.vtxlab.app;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicEx implements Runnable {
  private AtomicInteger count = new AtomicInteger();
  //make the variable as AtomicInteger
  //the Operation : read, modify and write

  @Override
  public void run(){
    for(int i =0 ; i<5;i++){       //大過5就停
      try{
        Thread.sleep(1000);
        count.getAndIncrement();  // increment by 1 ; +1
        /*
         * do{
         *    count = get();   // reads the current value
         * }while(!compareAndSet(count,count +1 )) //如果成功就加1；
         *                                         //如不成功，the value 唔再對於目前個value 然後就繼續loop (read and tries again) 
         */                                        //Atomic 運作過程
            System.out.println(i + " " + count);
      }catch(InterruptedException e){
        e.printStackTrace();
      }
    }
  }

  public int getCount(){
    return count.get();
  }
  
  public static void main(String[] args) throws InterruptedException {
    AtomicEx r = new AtomicEx();

    Thread t1 = new Thread(r);
    t1.start();

    Thread t2 = new Thread(r);
    t2.start();

    t1.join();
    t2.join();

    System.out.println("Count : " + r.getCount());
  }
  //Count : 10
}
