package edu.austral.ingsis.math.visitor;

public class PrinterVisitor implements Visitor<String> {
  @Override
  public String visit(Addition addition) {
    return "(" + addition.getLeft().accept(this) + " + " + addition.getRight().accept(this) + ")";
  }

  @Override
  public String visit(Division division) {
    return "(" + division.getLeft().accept(this) + " / " + division.getRight().accept(this) + ")";
  }

  @Override
  public String visit(Multiplication multiplication) {
    return "("
        + multiplication.getLeft().accept(this)
        + " * "
        + multiplication.getRight().accept(this)
        + ")";
  }

  @Override
  public String visit(AbsoluteValue absoluteValue) {
    return "|" + absoluteValue.getValue().accept(this) + "|";
  }

  @Override
  public String visit(Negation negation) {
    return "-" + negation.getValue().accept(this);
  }

  @Override
  public String visit(Potentiation potentiation) {
    return "("
        + potentiation.getBase().accept(this)
        + " ^ "
        + potentiation.getExponent().accept(this)
        + ")";
  }

  @Override
  public String visit(SquareRoot squareRoot) {
    return "sqrt(" + squareRoot.getValue().accept(this) + ")";
  }

  @Override
  public String visit(Substraction substraction) {
    return "("
        + substraction.getLeft().accept(this)
        + " - "
        + substraction.getRight().accept(this)
        + ")";
  }

  @Override
  public String visit(Value value) {
    if (value.getValue() == Math.floor(value.getValue())) {
      return String.valueOf((int) value.getValue());
    } else {
      return String.valueOf(value.getValue());
    }
  }

  @Override
  public String visit(Variable variable) {
    return variable.getName();
  }

  public String print(Function function) {
    return function.accept(this);
  }
}
