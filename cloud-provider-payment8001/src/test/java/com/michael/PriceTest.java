package com.michael;

/**
 * @ClassName: PriceTest
 * @Package com.michael
 * @Description: TODO
 * @Author Mr.Z
 * @Date 2020/5/29 19:52
 * @Version 1.0
 */
public class PriceTest {
    public static void main(String[] args) {
        System.out.println(Price.INSTANCE.currentPrice);
        Price p = new Price(2.8);
        System.out.println(p.currentPrice);
    }
}
class Price {
    final static Price INSTANCE = new Price(2.8);
    final static double initPrice = 20;
    double currentPrice;
    public Price(double discount) {
        currentPrice = initPrice - discount;
    }
}
