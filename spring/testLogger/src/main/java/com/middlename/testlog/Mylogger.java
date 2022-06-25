package com.middlename.testlog;

import com.middlename.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericApplicationContext;

public class Mylogger {
    private static final Logger log = LoggerFactory.getLogger(Mylogger.class);

    public static void main(String[] args) {
        log.info("Test log4j2 info");
        log.warn("Test log4j2 warn");
        log.error("Test log4j2 error");

        GenericApplicationContext context = new GenericApplicationContext();
        context.refresh();
        context.registerBean("user1", User.class,()->new User());

        User user = (User)context.getBean("user1");
        System.out.println(user);
    }
}

