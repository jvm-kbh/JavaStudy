package me.kbh.javastudy.basic.ch08.design.chain.after;

import me.kbh.javastudy.basic.ch08.design.chain.before.HeaderTextProcessing;
import me.kbh.javastudy.basic.ch08.design.chain.before.ProcessingObject;
import me.kbh.javastudy.basic.ch08.design.chain.before.SpellCheckerProcessing;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ChainTestByLamda {
  public static void main(String[] args) {
    UnaryOperator<String> headerProcessing =
        (String input) -> "From Raoul, Mario and Alan: " + input;
    UnaryOperator<String> spellCheckProcessing = (String input) -> input.replace("labda", "lamda");

    Function<String, String> pipeline = headerProcessing.andThen(spellCheckProcessing);

    String result = pipeline.apply("Aren't labdas really sexy?");
    System.out.println(result);
  }
}
