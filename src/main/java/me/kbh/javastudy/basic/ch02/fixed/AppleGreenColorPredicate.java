package me.kbh.javastudy.basic.ch02.fixed;

/**
 * 필터조건 2 : 초록 사과만 선택
 */
public class AppleGreenColorPredicate implements ApplePredicate {
  @Override
  public boolean test(Apple apple) {
    return "green".equals(apple.getColor());
  }
}