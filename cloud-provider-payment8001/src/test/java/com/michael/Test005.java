package com.michael;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ClassName: Test005
 * @Package com.michael
 * @Description: TODO
 * @Author Mr.Z
 * @Date 2020/5/31 21:17
 * @Version 1.0
 */
public class Test005 {
    public static void main(String[] args) {
        Cache cache = new Cache();
        for (int i = 1; i <= 5; i++) {
            final int tem = i;
            new Thread(()->{
                cache.put("" + tem, "" + tem);
            }, "" + i).start();
        }

        for (int i = 1; i <= 5; i++) {
            final int tem = i;
            new Thread(()->{
                cache.get("" + tem);
            }, "" + i).start();
        }
    }
}

class Cache{
    private volatile Map<String,Object> map = new HashMap<>();
//    private ConcurrentHashMap<String,Object> map = new ConcurrentHashMap();
    ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    public void put(String key, Object val) {
//        rwLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 写入开始 " + key);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key, val);
            System.out.println(Thread.currentThread().getName() + "\t 写入结束 " + key);
        } finally {
//            rwLock.writeLock().unlock();
        }
    }

    public Object get(String key) {
        rwLock.readLock().lock();
        Object o;
        try {
            System.out.println(Thread.currentThread().getName() + "\t 读出开始 " + key);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            o = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t 读出结束 " + key + "\t 结果： " + o);
        } finally {
            rwLock.readLock().unlock();
        }
        return o;
    }
}
