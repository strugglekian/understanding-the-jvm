package com.learning.understandingjvm.eight;

/**
 * @author kian
 * @date 2019/10/10
 */
public class StaticDispatch {
    static abstract class Human{

    }
    static class Man extends Human{

    }
    static class Woman extends Human{

    }
    public  void sayHelo(Human human) {
        System.out.println("hello,human!");
    }
    public  void sayHelo(Man man) {
        System.out.println("hello,man!");
    }
    public  void sayHelo(Woman woman) {
        System.out.println("hello,woman!");
    }

    public static void main(String[] args) {
        Man man = new Man();
        Woman woman = new Woman();
        StaticDispatch staticDispatch = new StaticDispatch();
        staticDispatch.sayHelo(man);
        staticDispatch.sayHelo(woman);
    }
}
