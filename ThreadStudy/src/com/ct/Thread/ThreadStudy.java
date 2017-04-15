package com.ct.Thread;

import sun.applet.Main;

/**
 * Created by chentao on 2017/4/14.
 */
public class ThreadStudy {
    public static void main(String[] args) {
        for (int i = 0;i < 100;i++){
            System.out.println(Thread.currentThread().getName()+" " +i);
            if(i == 10){
                Thread mythread1 = new MyThread(); //创建一个线程 mythread1，此时这个线程进入新建状态
                Thread mythread2 = new MyThread(); // 创建一个线程 mythread2 ，此时这个线程进入新建状态

                mythread1.start(); //调用start()方法使得线程进入就绪状态
                mythread2.start(); //调用start()方法使得线程进入就绪状态
            }
        }
    }

}
class MyThread extends Thread{
    private int i=0;

    @Override
    public void run() {
        for (i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+" "+i);
        }

    }
}