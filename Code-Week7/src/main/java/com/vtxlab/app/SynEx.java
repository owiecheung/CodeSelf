package com.vtxlab.app;

public class SynEx implements Runnable{
  private  int count;

  @Override
  public synchronized void run(){
    for(int i = 0 ; i < 5 ; i++){
      try {
          Thread.sleep(1000);
          count++;
          } catch (InterruptedException e) {
                  e.printStackTrace();
      }
    }
  }


  public int getCount(){
    return count;
  }

  public static void main(String[] args) throws InterruptedException   {
    SynEx s = new SynEx();

    Thread t1 = new Thread(s);
    t1.start();

    Thread t2 = new Thread(s);
    t2.start();

    t1.join();
    t2.join();

    //Should be 10
    System.out.println("Counter : " + s.getCount());


    //加左synchronized 係run method 入面
    //Always Counter : 10
  }
}
