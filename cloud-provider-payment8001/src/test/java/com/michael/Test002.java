package com.michael;

/**
 * @ClassName: Test002
 * @Package com.michael
 * @Description: TODO
 * @Author Mr.Z
 * @Date 2020/5/29 19:01
 * @Version 1.0
 */
public class Test002 {
    public static void main(String[] args) {
        Base002 b = new Base002();
        System.out.println(b.i);
        b.display();
        Derived002 d = new Derived002();
        System.out.println(d.i);
        d.display();
        Base002 ba = new Derived002();
        System.out.println(ba.i);
        ba.display();
        Base002 b2d = d;
        System.out.println(b2d.i);
    }
}
class Base002 {
    int i = 2;
    public void display() {
        System.out.println(this.i);
    }
}

class Derived002 extends Base002 {
    int i = 22;

    @Override
    public void display() {
        System.out.println(this.i);
    }
}