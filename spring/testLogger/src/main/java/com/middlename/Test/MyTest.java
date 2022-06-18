package com.middlename.Test;

import com.middlename.config.TxConfig;
import com.middlename.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        // 配置类
        ApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);
        AccountService accountService = context.getBean("accountService", AccountService.class);
        accountService.transfer(1,2,100);
    }

    public void passedTest(){
        // xml
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        AccountService accountService = context.getBean("accountService", AccountService.class);

    }
}
