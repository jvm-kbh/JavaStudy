package me.kbh.javastudy.basic.ch08.design.chain.before;

public class SpellCheckerProcessing extends ProcessingObject<String>{

    @Override
    protected String handleWork(String input) {
        return input.replace("labda", "lamda");
    }
}
