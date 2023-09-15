package me.kbh.javastudy.basic.ch08.design.strategy.after;

import me.kbh.javastudy.basic.ch08.design.strategy.before.IsAllLowerCase;
import me.kbh.javastudy.basic.ch08.design.strategy.before.IsNumeric;
import me.kbh.javastudy.basic.ch08.design.strategy.before.Validator;

public class StrategyTestByLamda {
    public static void main(String[] args) {
        Validator numericValidator = new Validator((String s) -> s.matches("\\d+"));
        Validator lowerCaseValidator = new Validator((String s) -> s.matches("[a-z]+"));

        boolean b1 = numericValidator.validate("aaa");
        boolean b2 = lowerCaseValidator.validate("bbb");
    }
}
