package com.ct.Thread;

/**
 * provide - consumer
 * Created by chentao on 2017/4/19.
 */
 class Thread03 {
    //定义商品编号
    private int No;
    //定义商品名称
    private String name;
    private boolean flag = true;

    public Thread03(String name, int no) {
        this.No = no;
        this.name = name;
    }

    // 定义商品中的消费方法和生产方法。用synchronized 修饰符修
    public synchronized void provider() {
        //导致当前线程等待，知道其他线程调用notify()或notifyAll()方法来唤醒
        while (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "生产" + name + ";编号为：" + No);
            // 唤醒在此同步监视器上等待的所有线程。
            this.notifyAll();
            flag = false;
        }
    }

    public synchronized void Comsumption() {
        while (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "消费商品" + name + ";商品编号为：" + No);
            this.notifyAll();
            flag = true;
        }
    }
}
    class ProducerThread implements Runnable
    {
        Thread03 phone  ;
        private boolean flag = true ;
        //    同步监视器的对象
        public ProducerThread (Thread03 phone)
        {
            this.phone = phone ;
        }
        public void run()
        {
            try
            {
                while (flag)
                    phone.provider();
            }
            catch(Exception e) { flag = false ;}
        }
    }
    class ConsumptionThread implements Runnable
    {
        Thread03 phone  ;
        private boolean flag = true ;
        //    同步监视器的对象
        public ConsumptionThread (Thread03 phone)
        {
            this.phone = phone ;
        }
        public void run()
        {
            try
            {
                while (flag)
                    phone.Comsumption();
            }
            catch(Exception e) { flag = false ;}
        }
    }


public class ProducerConsumerText {
    public static void main(String args[])
    {
        Thread03 phone = new Thread03("iPhone 5",0) ;
        new Thread(new ProducerThread(phone),"生成者000").start() ;
        new Thread(new ProducerThread(phone),"生成者111").start() ;
        new Thread(new ConsumptionThread(phone),"消费者000").start() ;
        new Thread(new ConsumptionThread(phone),"消费者111").start() ;
    }
}
