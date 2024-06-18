package edu.austral.ingsis.math.visitor;

public class Variable implements Function{
    private final String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    public String getName() {
        return name;
    }
}
