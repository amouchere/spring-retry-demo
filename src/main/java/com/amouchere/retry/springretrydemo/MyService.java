package com.amouchere.retry.springretrydemo;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    private int i = 0;

    @Retryable(maxAttempts = 9, value = Exception.class, backoff = @Backoff(delay = 2000, multiplier = 2))
    public void test() throws Exception {
        i++;
        System.out.println("try " + i);
        if (i != 5) {
            throw new Exception("it not a 5. it is a " + i);
        }
    }
}
