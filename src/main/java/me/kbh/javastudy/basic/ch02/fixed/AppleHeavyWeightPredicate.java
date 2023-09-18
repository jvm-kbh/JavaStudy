package me.kbh.javastudy.basic.ch02.fixed;

/**
 *  무거운 사과만 선택
 */
public class AppleHeavyWeightPredicate implements ApplePredicate {
  @Override
  public boolean test(Apple apple) {
    return apple.getWeight() > 80;
  }
}