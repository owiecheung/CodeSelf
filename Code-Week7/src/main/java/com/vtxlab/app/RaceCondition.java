package com.vtxlab.app;

public class RaceCondition implements Runnable{
  private int count;

  @Override
  public void run(){                   //Loop Five times for each thread
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
    RaceCondition s = new RaceCondition();


    //Create two threads
    Thread t1 = new Thread(s);  // pass this RaceCondition in it
    t1.start();

    Thread t2 = new Thread(s);  //一樣
    t2.start();

    t1.join();
    t2.join();

    //Expectation will be 10
    System.out.println("Counter : " + s.getCount());

    //Inconsistency 
    //Sometimes Count : 7, Count : 9
    //Two threads might be reading the same values and incrementing
    //兩條線性同時攞緊同一個數據去做加數
  }
}

