package com.learning.understandingjvm.controller;

import org.springframework.boot.SpringBootExceptionReporter;

/**
 * @author kian
 * @date 2019/7/25
 */
public class ExceptionAppli implements SpringBootExceptionReporter {
    @Override
    public boolean reportException(Throwable failure) {

        return false;
    }
}
