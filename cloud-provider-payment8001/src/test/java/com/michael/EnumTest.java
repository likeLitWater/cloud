package com.michael;

/**
 * @ClassName: EnumTest
 * @Package com.michael
 * @Description: TODO
 * @Author Mr.Z
 * @Date 2020/6/1 7:59
 * @Version 1.0
 */
public enum EnumTest {
    MONDAY(1,"星期一");

    private Integer num;
    private String name;

    EnumTest(Integer num, String name) {
        this.num = num;
        this.name = name;
    }
}
