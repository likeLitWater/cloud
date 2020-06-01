package com.michael;

/**
 * @ClassName: Test006
 * @Package com.michael
 * @Description: TODO
 * @Author Mr.Z
 * @Date 2020/5/31 22:02
 * @Version 1.0
 */
public class Test006 {
    public static void main(String[] args) {
        String str = "Hello";
        System.out.println(System.identityHashCode(str));
        str  = str + "Java";
        System.out.println(System.identityHashCode(str));
        str = str + ", crazyit.com";
        System.out.println(System.identityHashCode(str));
    }
}
