package com.example;

import org.apache.log4j.Logger;
import org.junit.Test;

public class LoggingTest {

    private static final Logger log = Logger.getLogger(LoggingTest.class);

    @Test
    public void test() {
        log.info("Hello World");
    }
}
