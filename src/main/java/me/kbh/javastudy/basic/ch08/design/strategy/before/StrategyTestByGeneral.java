package me.kbh.javastudy.basic.ch08.design.strategy.before;

public class StrategyTestByGeneral {
    public static void main(String[] args) {
        Validator numericValidator = new Validator(new IsNumeric());
        Validator lowerCaseValidator = new Validator(new IsAllLowerCase());

        boolean b1 = numericValidator.validate("aaa");
        boolean b2 = lowerCaseValidator.validate("bbb");
    }
}
