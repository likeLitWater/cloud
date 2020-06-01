package com.michael;

import java.util.concurrent.Semaphore;

/**
 * @ClassName: Test008
 * @Package com.michael
 * @Description: TODO
 * @Author Mr.Z
 * @Date 2020/6/1 8:33
 * @Version 1.0
 */
public class Test008 {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 8; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "\t 进来");
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName() + "\t 离开");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }, " " + i).start();
        }
    }
}
