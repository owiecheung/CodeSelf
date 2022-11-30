package com.vtxlab.app;

public class VolatileEx implements Runnable{
  public static volatile  boolean stopRequested;

  @Override
  public void run(){          //turned to true, also still running 
                              // this leads cache incoherence , not reading the value from the main memory as true
    int i = 0;        
    while(!stopRequested){ //Without Volatile  Although Main Completed showed the programme are not finished 
      i++;  //This boolean variable which runs forever until the value stopRequested becomes true  
    }
    System.out.println( "BackgroundThread(BackEnd) completed");
  }

  public static void main(String[] args) throws Exception{
    VolatileEx v = new VolatileEx();

    Thread backgrounThread = new Thread(v);
    backgrounThread.start();
    Thread.sleep(1000); //This needs throw Exception

    stopRequested = true; //正常情況 係上面一秒後應該將 stopRequested 轉做 true

    System.out.println("Main Completed" ); //For reference

  }

  //After implement volatile Main is Completed
  //Because of the visibility guarantees stopRequested睇到轉左做true
  //Then, Line 10 is not fulfilled that not get into the while loop 
  //and print "BackgroundThread(BackEnd) completed"
  //It is not the replacement of synchronized method or block
  //Volatile Only be used on read write opteration

}
