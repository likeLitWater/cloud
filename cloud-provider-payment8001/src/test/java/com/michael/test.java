package com.michael;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName: test
 * @Package com.michael
 * @Description: TODO
 * @Author Mr.Z
 * @Date 2020/5/29 11:45
 * @Version 1.0
 */
class Demo {
    volatile int a = 0;

    public void addA() {
        this.a = 30;
    }

    public void increment() {
        this.a ++;
    }

}

public class test {
    public static void main(String[] args) {
//        seeTest();
        Demo t = new Demo();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    t.increment();
                }
            }).start();
        }
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(t.a);
    }

    private static void seeTest() {
        Demo t = new Demo();
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t.addA();
            System.out.println(Thread.currentThread().getName() + "-------  " + t.a);
        }).start();

        while (t.a == 0) {

        }
        System.out.println(t.a);
    }
}
