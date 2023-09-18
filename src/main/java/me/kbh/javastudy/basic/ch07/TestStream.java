package me.kbh.javastudy.basic.ch07;

import java.util.stream.Stream;

public class TestStream {
    public static long sequentialSum(long testNumber){
        return Stream.iterate(1L, i -> i+1)
                .limit(testNumber)
                .reduce(0L, Long::sum);
    }

    public static long iterativeSum(long testNumber){
        long result = 0L;

        for (int i = 0; i < testNumber; i++) {
            result += 1;
        }

        return result;
    }

    public static long parallelSum(long testNumber){
        return Stream.iterate(1L, i -> i+1)
                .limit(testNumber)
                .parallel()
                .reduce(0L, Long::sum);
    }
}
