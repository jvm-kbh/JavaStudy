package me.kbh.javastudy.basic.ch08;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ConditionalDeferredExecution {

    private static final Logger logger = Logger.getLogger(ConditionalDeferredExecution.class.getName());

    public static String getProblem() {
        return "study difficult";
    }
    public static void main(String[] args) {
        /*
            if문을 제거하고, 더 적합한 메서드를 체크해본다.
            로그의 상태가 isLoggable()에 의해 노출되며 로깅마다 if문을 통해 상태를 체크한다.
        */
        if(logger.isLoggable(Level.FINER)) {
            logger.finer("Problem: " + getProblem());
        }

        /*
            if문을 제거하고 좀 더 적절한 메서드를 활용한다.
            그러나 이 로그는 logger가 활성화 되지 않더라도 항상 로깅 메세지를 평가한다.
        */
        logger.log(Level.FINER, "Problem: " + getProblem());

        /*
            비슷해 보이지만 람다로 문제를 해결한 케이스이다.
            람다를 통해 메서드의 생성 과정을 연기한다.
            클라이언트 코드에서 객체 상태를 자주 체크하는경우
            람다,메서드 레퍼런스를 통해서 내부적으로 확인해서 호출하도록 구성해야한다.
        */
        logger.log(Level.FINER, () -> "Problem: " + getProblem());
    }
}
