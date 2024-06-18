package edu.austral.ingsis.math.visitor;

public class Value implements Function {
  private final double value;

  public Value(double value) {
    this.value = value;
  }

  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visit(this);
  }

  public double getValue() {
    return value;
  }
}
