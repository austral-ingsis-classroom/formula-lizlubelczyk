package edu.austral.ingsis.math.composite;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Substraction implements Function {
  private final Function left;
  private final Function right;

  public Substraction(Function left, Function right) {
    this.left = left;
    this.right = right;
  }

  @Override
  public double evaluate(Map<String, Function> variables) {
    return left.evaluate(variables) - right.evaluate(variables);
  }

  @Override
  public String print() {
    return "(" + left.print() + " - " + right.print() + ")";
  }

  @Override
  public Set<String> getVariables() {
    Set<String> leftVariables = left.getVariables();
    Set<String> rightVariables = right.getVariables();
    return new HashSet<>(leftVariables) {
      {
        addAll(rightVariables);
      }
    };
  }
}
