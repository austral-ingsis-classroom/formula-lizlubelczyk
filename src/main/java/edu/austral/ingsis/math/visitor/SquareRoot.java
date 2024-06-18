package edu.austral.ingsis.math.visitor;

public class SquareRoot implements Function {
    private final Function value;

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    public SquareRoot(Function value) {
        this.value = value;
    }

    public Function getValue() {
        return value;
    }
}
