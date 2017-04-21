package com.ct.Thread;

import sun.applet.Main;

import java.io.*;

/**
 * Created by chentao on 2017/4/14.
 */
public class ThreadStudy {
    public static void main(String[] args) {
        for (int i = 0;i < 100;i++){
            System.out.println("当前运行线程："+Thread.currentThread().getName()+" " +i);
            if(i == 10){
                Thread mythread1 = new MyThread(); //创建一个线程 mythread1，此时这个线程进入新建状态
                Runnable  myOtherThread = new MyOtherThread();
                Thread mythread2 = new Thread(myOtherThread); // 创建一个线程 mythread2 ，此时这个线程进入新建状态

                mythread1.start(); //调用start()方法使得线程进入就绪状态
                try {
                    mythread1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mythread2.start(); //调用start()方法使得线程进入就绪状态
            }
        }
    }

}
class MyThread extends Thread{
    @Override
    public void run() {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream("C:\\Users\\chentao\\Desktop\\噼啪金融\\开户行号.txt");
            os = new FileOutputStream("C:\\Users\\chentao\\Desktop\\噼啪金融\\开户行号COPY.txt");
            byte[] b = new byte[1024];
            int c = 0;
            while ((c = is.read(b)) != -1){
                System.out.println("当前运行线程："+Thread.currentThread().getName());

                System.out.write(b,0,c);
                os.write(b,0,c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null != is){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != os){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
class MyOtherThread implements Runnable{

    @Override
    public void run() {
        for (int i=0;i<30;i++){
            System.out.println("当前运行线程："+Thread.currentThread().getName()+": "+i);
        }
    }
}