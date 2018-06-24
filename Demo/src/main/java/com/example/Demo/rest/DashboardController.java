package com.example.Demo.rest;

import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

class MyThread implements Runnable{
    public int sum = 0;

    public CountDownLatch countDownLatch = new CountDownLatch(100);

    @Override
    public void run() {
        while (true) {
            if (sum < 100) {
                System.out.println(sum++);
            }else{
                break;
            }
        }
    }
}

public class DashboardController extends Thread {
    public static void main(String args[])
    {
        StringBuffer sb1 = new StringBuffer();
//        System.out.println(sb1.capacity());
        sb1.append("1234567890");
        sb1.append("1234567890");
//        System.out.println(sb1.capacity());
        sb1.append("1234567890");
        sb1.append("1234567890");
        sb1.append("1234567890");
        sb1.append("1234567890");
        sb1.append("1234567890");
        sb1.append("1234567890");
        System.out.println(sb1.capacity());
        System.out.println(sb1.length());



        System.out.println((70  << 1) + 2);
        //


//        MyThread mt = new MyThread();
//
//        new Thread(mt).start();
//        new Thread(mt).start();
//        new Thread(mt).start();
//        try {
//            mt.countDownLatch.await();
//        }catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//            System.out.println("-------sum: " + mt.sum);
//        }


    }

}
