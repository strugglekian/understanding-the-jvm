package com.learning.understandingjvm.seven;

/**
 * @author kian
 * @date 2019/7/23
 */
public class ConstClass {
    static{
        System.out.println("ConstClass init!");
    }
    public static final String HELLOWORD = "hello word!";
}


class NotInitialization{
    public static void main(String[] args) {
        System.out.println(ConstClass.HELLOWORD);
    }
}
