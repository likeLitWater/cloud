package com.michael;

/**
 * @ClassName: Apple
 * @Package com.michael
 * @Description: TODO
 * @Author Mr.Z
 * @Date 2020/5/29 19:23
 * @Version 1.0
 */
public class Apple extends Fruit{
    @Override
    public void info() {
        System.out.println("Apple方法");
    }
    public void accessSuperInfo() {
        super.info();
    }
    public Fruit getSuper() {
        System.out.println(super.getClass());
        System.out.println(super.color);
        return super.getThis();
    }
    String color = "红色";

    public static void main(String[] args) {
        Apple a = new Apple();
        Fruit f = a.getSuper();
        System.out.println(a==f);
        System.out.println(a.color);
        System.out.println(f.color);
        a.info();
        f.info();
        a.accessSuperInfo();
    }
}
class Fruit {
    String color = "未确定的颜色";
    public Fruit getThis() {
        return this;
    }
    public void info() {
        System.out.println("Fruit方法");
    }
}
