package edu.austral.ingsis.math.visitor;

public class Potentiation implements Function {
  private final Function base;
  private final Function exponent;

  public Potentiation(Function base, Function exponent) {
    this.base = base;
    this.exponent = exponent;
  }

  public Function getBase() {
    return base;
  }

  public Function getExponent() {
    return exponent;
  }

  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visit(this);
  }
}
