package com.learning.understandingjvm.eight;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author kian
 * @date 2019/10/11
 */
public class DynamicProxyTest {
    interface IHello {
        void sayHello();
    }

    static class Hello implements IHello {

        @Override
        public void sayHello() {
            System.out.println("hello word");
        }
    }

    static class DynamicProxy implements InvocationHandler {

        Object originObj;

        public static void main(String[] args) {
            IHello hello = (IHello) new DynamicProxy().bind(new Hello());
            hello.sayHello();
        }

        Object bind(Object originObj) {
            this.originObj = originObj;
            return Proxy.newProxyInstance(originObj.getClass().getClassLoader(), originObj.getClass().getInterfaces(), this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("welcome");
            return method.invoke(originObj, args);
        }
    }
}
