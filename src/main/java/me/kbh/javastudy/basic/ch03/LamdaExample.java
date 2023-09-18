package me.kbh.javastudy.basic.ch03;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class LamdaExample {

    public static void main(String[] args) {
        //리스트를 이용한 간단한 람다 표현식 예제
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // 리스트의 각 요소를 출력
        names.forEach(name -> System.out.println(name));

        // 리스트에서 길이가 5 이상인 이름만 출력
        names.stream()
                .filter(name -> name.length() >= 5)
                .forEach(name -> System.out.println(name));


        // 람다 표현식을 사용하여 스레드 생성 및 실행
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("스레드 동작 중: " + i);
            }
        });
        thread.start();

        // 람다 표현식을 사용하여 함수형 인터페이스를 구현
        Function<Integer, Integer> square = x -> x * x;
        int result = square.apply(5);
        System.out.println("제곱 결과: " + result);
    }
}
