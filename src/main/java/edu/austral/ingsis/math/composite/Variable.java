package edu.austral.ingsis.math.composite;

import java.util.Map;
import java.util.Set;

public class Variable implements Function {
  private final String name;

  public Variable(String name) {
    this.name = name;
  }

  @Override
  public double evaluate(Map<String, Function> variables) {
    return variables.get(name).evaluate(variables);
  }

  @Override
  public String print() {
    return name;
  }

  @Override
  public Set<String> getVariables() {
    return Set.of(name);
  }
}
