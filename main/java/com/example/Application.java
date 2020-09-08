package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int result = calculator.sum(3, 4);
        log.info("Result = {}", result);
    }
}