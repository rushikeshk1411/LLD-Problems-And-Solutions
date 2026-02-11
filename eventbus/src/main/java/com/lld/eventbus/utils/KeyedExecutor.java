package com.lld.eventbus.utils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class KeyedExecutor {
    Executor executors[];

    public KeyedExecutor(final int thread){
        this.executors = new Executor[thread];
        for(int i=0; i<thread; i++){
            executors[i] = Executors.newSingleThreadExecutor();
        }
    }

    public CompletionStage<Void> submit(final String id, final Runnable task){
        return CompletableFuture.runAsync(task, executors[id.hashCode() % executors.length]);
    }

    public <T> CompletionStage<T> get(final String id, Supplier<T> supplier){
        return CompletableFuture.supplyAsync(supplier, executors[id.hashCode() % executors.length]);
    }

}
