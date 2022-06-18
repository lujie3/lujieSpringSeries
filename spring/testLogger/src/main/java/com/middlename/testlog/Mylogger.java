package com.middlename.testlog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mylogger {
    private static final Logger log = LoggerFactory.getLogger(Mylogger.class);

    public static void main(String[] args) {
        log.info("Test log4j2 info");
        log.warn("Test log4j2 warn");
        log.error("Test log4j2 error");
    }
}

