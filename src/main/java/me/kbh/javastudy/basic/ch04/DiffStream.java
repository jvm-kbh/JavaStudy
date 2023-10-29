package me.kbh.javastudy.basic.ch04;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DiffStream {
  public static void main(String[] args) {
    List<Integer> numbers = new ArrayList<>();
    for (int i = 0; i < 1000000; i++) {
      numbers.add(i);
    }

    // 스트림을 사용한 경우
    long startTime = System.currentTimeMillis();
    long sum1 = numbers.parallelStream().mapToLong(Integer::longValue).sum();
    long endTime = System.currentTimeMillis();
    System.out.println("스트림을 사용한 경우: " + sum1);
    System.out.println("소요 시간(ms): " + (endTime - startTime));

    // 외부 반복을 사용한 경우
    startTime = System.currentTimeMillis();
    long sum2 = 0;
    for (Integer number : numbers) {
      sum2 += number;
    }
    endTime = System.currentTimeMillis();
    System.out.println("외부 반복을 사용한 경우: " + sum2);
    System.out.println("소요 시간(ms): " + (endTime - startTime));

    // 1부터 10까지의 숫자로 이루어진 큰 데이터셋 생성
    List<Integer> numbers2 =
        IntStream.rangeClosed(1, 10_000_000).boxed().collect(Collectors.toList());

    startTime = System.nanoTime();
    long sum3 =
        numbers2.parallelStream()
            .filter(n -> n % 2 == 0)
            .mapToInt(n -> n * 2)
            .reduce(0, Integer::sum);
    endTime = System.nanoTime();

    System.out.println("스트림을 사용한 복잡한 연산 소요 시간(ns): " + (endTime - startTime));

    // 외부 반복을 사용한 경우
    startTime = System.nanoTime();
    long sum4 = 0;
    for (Integer number : numbers2) {
      if (number % 2 == 0) {
        sum4 += number * 2;
      }
    }
    endTime = System.nanoTime();

    System.out.println("복잡한 연산을 하지않고 외부 반복을 사용한 경우 소요 시간(ns): " + (endTime - startTime));
  }
}
