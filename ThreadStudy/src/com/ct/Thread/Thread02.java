package com.ct.Thread;

/**
 * Created by chentao on 2017/4/14.
 */
public class Thread02 {

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        for (int i = 0;i < 100; i++){
            System.out.println(Thread.currentThread().getName()+" "+i);
            if(i == 10){
                thread.start();
                try {
                   // thread.join(); // main线程需要等待thread线程执行完后才能继续执行
                    Thread.sleep(1);  // 让当前的正在执行的线程(main 线程)暂停指定的时间，并进入阻塞状态,使得thread必然能够马上得以执行
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
class MyRunnable implements  Runnable{

    @Override
    public void run() {
        for (int i = 0;i < 100;i++){
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }
}
