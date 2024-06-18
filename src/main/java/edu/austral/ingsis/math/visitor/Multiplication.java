package edu.austral.ingsis.math.visitor;

public class Multiplication implements Function{

    private final Function left;
    private final Function right;

    public Multiplication(Function left, Function right) {
        this.left = left;
        this.right = right;
    }
    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    public Function getLeft() {
        return left;
    }

    public Function getRight() {
        return right;
    }
}
