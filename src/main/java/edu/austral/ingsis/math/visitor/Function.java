package edu.austral.ingsis.math.visitor;

public interface Function {
  <T> T accept(Visitor<T> visitor);
}
