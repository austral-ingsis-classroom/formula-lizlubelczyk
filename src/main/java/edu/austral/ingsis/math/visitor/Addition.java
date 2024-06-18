package edu.austral.ingsis.math.visitor;

class Addition implements Function {
  private final Function left;
  private final Function right;

  public Addition(Function left, Function right) {
    this.left = left;
    this.right = right;
  }

  public Function getLeft() {
    return left;
  }

  public Function getRight() {
    return right;
  }

  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visit(this);
  }
}
