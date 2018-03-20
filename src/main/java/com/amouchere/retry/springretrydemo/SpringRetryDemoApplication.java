package com.amouchere.retry.springretrydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@SpringBootApplication
public class SpringRetryDemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringRetryDemoApplication.class, args);

        MyService service = run.getBean(MyService.class);

        try {
            service.test();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
