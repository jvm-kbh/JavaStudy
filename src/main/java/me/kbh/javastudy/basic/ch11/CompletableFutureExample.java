package me.kbh.javastudy.basic.ch11;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class CompletableFutureExample {
  /*public static void main(String[] args) {
      // 가정: entityList는 1000개의 JPA 엔티티 리스트
      List<Entity> entityList = fetchEntities();

      CompletableFuture<Double> averageA = CompletableFuture.supplyAsync(() -> {
          List<A> aList = entityList.stream()
                  .limit(200)
                  .map(Entity::toA)
                  .collect(Collectors.toList());
          return aList.stream().mapToDouble(A::getValue).average().orElse(0);
      });

      CompletableFuture<Double> averageB = CompletableFuture.supplyAsync(() -> {
          List<B> bList = entityList.stream()
                  .skip(200)
                  .limit(300)
                  .map(Entity::toB)
                  .collect(Collectors.toList());
          return bList.stream().mapToDouble(B::getValue).average().orElse(0);
      });

      CompletableFuture<List<C>> cFuture = CompletableFuture.supplyAsync(() -> {
          List<C> cList = entityList.stream()
                  .skip(500)
                  .map(Entity::toC)
                  .collect(Collectors.toList());
          return cList;
      });

      CompletableFuture<BigDecimal> finalResult = averageA.thenCombine(averageB, (avgA, avgB) -> {
          BigDecimal avgAasBigDecimal = BigDecimal.valueOf(avgA);
          BigDecimal avgBasBigDecimal = BigDecimal.valueOf(avgB);
          return avgAasBigDecimal.add(avgBasBigDecimal);
      }).thenCombine(cFuture, (avgAB, cList) -> {
          BigDecimal avgC = cList.stream()
                  .map(C::getValue)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
          return avgAB.add(avgC);
      });

      try {
          BigDecimal result = finalResult.get();
          System.out.println("Final Result: " + result);
      } catch (Exception e) {
          e.printStackTrace();
      }
  }

  // 가상의 Entity 클래스와 A, B, C DTO 클래스 정의
  static class Entity {
      public A toA() { */
  /* A로 변환 로직 */
  /* }
  public B toB() { */
  /* B로 변환 로직 */
  /* }
  public C toC() { */
  /* C로 변환 로직 */
  /* }
  }

  static class A {
      public double getValue() { */
  /* 값을 얻는 로직 */
  /* }
  }

  static class B {
      public double getValue() { */
  /* 값을 얻는 로직 */
  /* }
  }

  static class C {
      public BigDecimal getValue() { */
  /* 값을 얻는 로직 */
  /* }
  }

  static List<Entity> fetchEntities() {
      // JPA 또는 데이터베이스에서 엔티티를 가져오는 로직
      return null;
  }*/
}
