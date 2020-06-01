package com.michael;

/**
 * @ClassName: Test003
 * @Package com.michael
 * @Description: TODO
 * @Author Mr.Z
 * @Date 2020/5/31 14:54
 * @Version 1.0
 */
public class Test003 {
    public static void main(String[] args) {
       new Thread(()->{
           try {
               Thread.sleep(10000);
               System.out.println(Thread.currentThread().getName() + " \t is over");
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }).start();

        System.out.println("main thread is over .....");
    }
}
