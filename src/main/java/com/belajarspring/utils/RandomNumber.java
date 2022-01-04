package com.belajarspring.utils;

public class RandomNumber {
    public static long getRandom(long min, long max){
        long number = min - (long) (Math.random() * (min-max));
        return number;
    }
}
