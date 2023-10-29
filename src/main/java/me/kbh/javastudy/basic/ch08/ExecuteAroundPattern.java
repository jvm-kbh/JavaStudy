package me.kbh.javastudy.basic.ch08;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExecuteAroundPattern {

  // 함수형 디스크립터가 동일한 함수형 인터페이스의 시그니처를 지정하자
  @FunctionalInterface
  public interface BufferedReaderProcessor {
    String process(BufferedReader b) throws IOException;
  }

  // 한 줄만 불러오는 코드를 변경하려면 다양하게 변경하려면 함수 인터페이스를 아규먼트로 전달받을 수 있도록 구성해야한다
  public static String processFile(BufferedReaderProcessor p) throws IOException {
    try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
      return p.process(br);
    }
  }

  public static void main(String[] args) throws IOException {
    // 요구사항에 대응하려면 어떻게 해야하는가
    // 실행 어라운드 패턴을 유지하면서 메서드를 동작 파라미터화 해보자
    // 첫번쨰 동작을 파라미터화 해보자
    String oneLine = processFile((BufferedReader br) -> br.readLine() + br.readLine());

    // 앞선 람다를 활용하여 다양하게 수렴할수있도록 구현하면 기존 구현부에 영향을 주지 않으면서 기능적인 추가가 가능해진다.
    String twoLines = processFile((BufferedReader br) -> br.readLine() + br.readLine());
  }
}
