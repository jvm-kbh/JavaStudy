package me.kbh.javastudy.basic.ch14;

import java.util.function.Function;

public class CurryingExample {

  public static void main(String[] args) {
    // 커링을 적용한 함수 정의
    Function<Integer, Function<Integer, Integer>> curriedAdd = x -> y -> x + y;

    // 커링된 함수 사용
    Function<Integer, Integer> add5 = curriedAdd.apply(5);
    System.out.println(add5.apply(3)); // 8
  }
}
