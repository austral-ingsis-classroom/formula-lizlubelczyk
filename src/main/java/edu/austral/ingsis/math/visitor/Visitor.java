package edu.austral.ingsis.math.visitor;

interface Visitor<T> {
  T visit(AbsoluteValue absoluteValue);

  T visit(Addition addition);

  T visit(Division division);

  T visit(Multiplication multiplication);

  T visit(Negation negation);

  T visit(Potentiation potentiation);

  T visit(SquareRoot squareRoot);

  T visit(Substraction subtraction);

  T visit(Value value);

  T visit(Variable variable);
}
