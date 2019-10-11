package com.learning.understandingjvm.seven;

/**
 * @author kian
 * @date 2019/8/8
 */
public class InitClass {
    static int i = 1;

    static {
        int i = 0;
        System.out.println("i:" + i);
        if (true) {
            while (true) {
            }
        }
    }


    public InitClass() {
        System.out.println("this is construct method!");
    }

    public static void main(String[] args) {
        InitClass initClass = new InitClass();
        System.out.println(i);
    }
}
