package edu.austral.ingsis.math.visitor;

public class Negation implements Function{
    private final Function value;

    public Negation(Function value) {
        this.value = value;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    public Function getValue() {
        return value;
    }
}
