package com.lld.eventbus;

import com.lld.eventbus.exception.RetryAbleException;
import com.lld.eventbus.exception.RetryLimitExceedException;

import java.util.function.Function;

public class ExponentialBackOff<P, R> extends RetryAlgorithm<P, R> {
    private final int maxAttempt;

//    @Inject
    public ExponentialBackOff(int maxAttempt){
        this.maxAttempt = maxAttempt;
    }


    @Override
    public void retry(Function<P, R> task, P paramter, int attempts) {
        try{
            task.apply(paramter);
        } catch (Exception e) {
            if(e.getCause() instanceof RetryAbleException){
                if(attempts == maxAttempt){
                    throw new RetryLimitExceedException(e.getMessage());
                }else{
                    long timeToSleep = (long) Math.pow(2, attempts-1) * 1000;
                    retry(task, paramter, attempts+1);
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
