package com.michael;

/**
 * @ClassName: Test001
 * @Package com.michael
 * @Description: TODO
 * @Author Mr.Z
 * @Date 2020/5/29 18:14
 * @Version 1.0
 */
public class Test001 {
    public static void main(String[] args) {
        new Derived();
    }
}

class Base {
    private int i = 2;

    public Base() {
        System.out.println(this.i);
        this.display();
        System.out.println(this.getClass());
    }
    public void display() {
        System.out.println(i);
    }
}

class Derived extends Base {
    private int i = 22;
    public Derived() {
        i = 222;
    }
    public void display() {
        System.out.println(i);
    }
}