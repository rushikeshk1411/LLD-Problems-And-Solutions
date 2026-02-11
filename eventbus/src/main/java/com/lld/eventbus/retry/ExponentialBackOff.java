package com.lld.eventbus.retry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class ExponentialBackOff<P, R> extends RetryAlgorithm<P, R> {
    private final int maxAttempt;

    @Autowired
    public ExponentialBackOff(@Qualifier("exponential-retry-attempts") int maxAttempt ){
        super(maxAttempt, (attempts) -> (long) (Math.pow(2, attempts) * 1000));
        this.maxAttempt = maxAttempt;
    }


}
