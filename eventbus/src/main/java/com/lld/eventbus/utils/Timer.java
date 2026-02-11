package com.lld.eventbus.utils;

import org.springframework.stereotype.Component;

@Component
public class Timer {

    public long getTime(){
        return System.nanoTime();
    }
}
