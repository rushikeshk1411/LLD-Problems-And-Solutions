package com.lld.eventbus.retry;

import com.lld.eventbus.exception.RetryAbleException;
import com.lld.eventbus.exception.RetryLimitExceedException;

import java.util.function.Function;

public abstract class RetryAlgorithm<P, R> {
    Function<Integer, Long> waitTimeCalculator;
    private final int maxAttempt;

    public RetryAlgorithm(int maxAttempt, Function<Integer, Long> waitTimeCalculator){
        this.maxAttempt = maxAttempt;
        this.waitTimeCalculator = waitTimeCalculator;
    }
    public void retry(Function<P, R> task, P parameter, Integer attempts) {
        try{
            task.apply(parameter);
        } catch (Exception e) {
            if(e.getCause() instanceof RetryAbleException){
                if(attempts == maxAttempt){
                    throw new RetryLimitExceedException(e.getMessage());
                }else{
                    long timeToSleep = waitTimeCalculator.apply(attempts);
                    retry(task, parameter, attempts+1);
                    try{
                        Thread.sleep(timeToSleep);
                    }catch(InterruptedException interruptedException){
                        throw new RuntimeException(interruptedException);
                    }
                }
            }else{
                throw new RuntimeException(e);
            }
        }
    }
}
