package edu.austral.ingsis.math.composite;

import java.util.Map;
import java.util.Set;

public class Negation implements Function {
  private final Function value;

  public Negation(Function value) {
    this.value = value;
  }

  @Override
  public double evaluate(Map<String, Function> variables) {
    return -value.evaluate(variables);
  }

  @Override
  public String print() {
    return "-" + value.print();
  }

  @Override
  public Set<String> getVariables() {
    return value.getVariables();
  }
}
