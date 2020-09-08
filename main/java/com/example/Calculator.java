package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Calculator {

    private static final Logger log = LoggerFactory.getLogger(Calculator.class);

    public int sum(int a, int b) {
        return a + b;
    }

    public void runtime() {
        log.info("Java runtime: {}", System.getProperty("java.version"));
        log.info("Current dir: {}", System.getProperty("user.dir"));
    }
}
