package com.michael;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @ClassName: Test004
 * @Package com.michael
 * @Description: TODO
 * @Author Mr.Z
 * @Date 2020/5/31 20:08
 * @Version 1.0
 */
public class Test004 {
    private AtomicReference<Thread> reference = new AtomicReference<>();

    public void lock() {
        Thread t = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "\t O(∩_∩)O哈哈~");
        while (!reference.compareAndSet(null, t)) {

        }
    }

    public void unlock() {
        Thread t = Thread.currentThread();
        reference.compareAndSet(t, null);
        System.out.println(Thread.currentThread().getName() + "\t o(*￣︶￣*)o 解锁");
    }

    public static void main(String[] args) {
        Test004 test004 = new Test004();
        new Thread(()->{
            test004.lock();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                test004.unlock();
            }
        }, "t1").start();

        new Thread(()->{
            test004.lock();
            test004.unlock();
        }, "t2").start();
    }
}
