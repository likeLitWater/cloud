package com.michael;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @ClassName: Test007
 * @Package com.michael
 * @Description: TODO
 * @Author Mr.Z
 * @Date 2020/6/1 8:20
 * @Version 1.0
 */
public class Test007 {
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(7, ()-> System.out.println("over"));
        for (int i = 0; i < 7; i++) {
            final int temp = i;
            new Thread(()->{
                System.out.println(temp);
                try {
                    cb.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
