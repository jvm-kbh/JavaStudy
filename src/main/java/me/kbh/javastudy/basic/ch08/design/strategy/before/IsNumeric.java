package me.kbh.javastudy.basic.ch08.design.strategy.before;

public class IsNumeric implements ValidationStrategy {
  @Override
  public boolean execute(String s) {
    return s.matches("\\d+");
  }
}
