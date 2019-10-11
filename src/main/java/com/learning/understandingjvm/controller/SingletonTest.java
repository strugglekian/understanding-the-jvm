package com.learning.understandingjvm.controller;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kian
 * @date 2019/7/4
 */
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@RestController
public class SingletonTest {
    int singleton = 1;
    private ThreadLocal threadLocal = new ThreadLocal();

    @GetMapping("/singleton")
    public void addSingleton() {
        singleton++;
        System.out.println(Thread.currentThread().getName() + "===" + Thread.currentThread().getId() + "====" + singleton);
        for (int i = 0; i < 1000; i++) {
            new Thread(new SynAddRunable(1, 2)).start();
        }
    }

    private static class SynAddRunable implements Runnable {
        int a, b;

        public SynAddRunable(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            synchronized (Integer.valueOf(a)) {
                synchronized (Integer.valueOf(b)) {
                    System.out.println(a + b);
                }
            }
        }
    }
}
