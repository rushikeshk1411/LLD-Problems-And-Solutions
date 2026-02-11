package com.lld.eventbus.retry;

import org.springframework.beans.factory.annotation.Qualifier;

import java.util.function.Function;

public class PeriodicRetry<P, R> extends RetryAlgorithm<P, R> {

    private final int maxAttempts;

    public PeriodicRetry(@Qualifier("periodic-retry-attempts") int maxAttempts){
        super(maxAttempts, (__) -> 2L);
        this.maxAttempts = maxAttempts;
    }

}
