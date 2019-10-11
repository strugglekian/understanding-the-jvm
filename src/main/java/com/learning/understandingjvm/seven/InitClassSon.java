package com.learning.understandingjvm.seven;

/**
 * @author kian
 * @date 2019/8/8
 * 先执行静态代码块，然后才是静态变量赋值
 */

public class InitClassSon extends InitClass {
    public static int j = i;

    public static void main(String[] args) {
        System.out.println("j:"+j);
    }
}
