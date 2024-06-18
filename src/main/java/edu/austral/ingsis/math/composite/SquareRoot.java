package edu.austral.ingsis.math.composite;

import java.util.Map;
import java.util.Set;

public class SquareRoot implements Function{
    private final Function value;

    public SquareRoot(Function value) {
        this.value = value;
    }

    @Override
    public double evaluate(Map<String, Function> variables) {
        return Math.sqrt(value.evaluate(variables));
    }

    @Override
    public String print() {
        return "sqrt(" + value.print() + ")";
    }

    @Override
    public Set<String> getVariables() {
        return value.getVariables();
    }
}
