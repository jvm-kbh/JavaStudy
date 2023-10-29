package me.kbh.javastudy.basic.ch01;

public class PatternMatchingExample {
  public static void main(String[] args) {
    Object value = 42;

    if (value instanceof String) {
      String str = (String) value;
      System.out.println("문자열 값: " + str);
    } else if (value instanceof Integer) {
      Integer intValue = (Integer) value;
      System.out.println("정수 값: " + intValue);
    } else if (value instanceof Double) {
      Double doubleValue = (Double) value;
      System.out.println("실수 값: " + doubleValue);
    } else {
      System.out.println("다른 타입의 값");
    }
  }
}
