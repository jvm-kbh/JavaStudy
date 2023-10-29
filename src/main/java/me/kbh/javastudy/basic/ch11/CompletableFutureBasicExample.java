package me.kbh.javastudy.basic.ch11;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureBasicExample {
  public static void main(String[] args) {
    CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 5);
    CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 10);

    // thenApply: 결과를 변환하고 다음 작업에 전달
    CompletableFuture<Integer> result1 = future1.thenApply(value -> value * 2);

    // thenCompose: 결과를 다른 비동기 작업에 전달
    CompletableFuture<Integer> result2 =
        future1.thenCompose(value -> CompletableFuture.supplyAsync(() -> value * 3));

    // thenCombine: 두 작업의 결과를 결합
    CompletableFuture<Integer> result3 =
        future1.thenCombine(future2, (value1, value2) -> value1 + value2);

    // thenAccept: 결과를 처리하고 반환값이 없음
    future1.thenAccept(value -> System.out.println("Result of future1: " + value));

    // 예외 처리
    CompletableFuture<Integer> exceptionExample =
        CompletableFuture.supplyAsync(
            () -> {
              throw new RuntimeException("An exception occurred");
            });

    exceptionExample.exceptionally(
        ex -> {
          System.out.println("Exception occurred: " + ex.getMessage());
          return 0; // 예외 처리 후 대체 값 반환
        });

    // 기다렸다가 결과 출력
    try {
      System.out.println("Result of thenApply: " + result1.get());
      System.out.println("Result of thenCompose: " + result2.get());
      System.out.println("Result of thenCombine: " + result3.get());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
