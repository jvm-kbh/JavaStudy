package me.kbh.javastudy.basic.ch08.design.strategy.before;

public class Validator {
    private final ValidationStrategy strategy;

    public Validator(ValidationStrategy validationStrategy){
        this.strategy = validationStrategy;
    }

    public boolean validate(String s){
        return strategy.execute(s);
    }
}
