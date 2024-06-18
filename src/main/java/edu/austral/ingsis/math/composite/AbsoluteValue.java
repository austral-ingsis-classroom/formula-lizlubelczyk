package edu.austral.ingsis.math.composite;

import java.util.Map;
import java.util.Set;

public class AbsoluteValue implements Function {
    private final Function value;

    public AbsoluteValue(Function value) {
        this.value = value;
    }

    @Override
    public double evaluate(Map<String, Function> variables) {
        return Math.abs(value.evaluate(variables));
    }

    @Override
    public String print() {
        return "|" + value.print() + "|";
    }

    @Override
    public Set<String> getVariables() {
        return value.getVariables();
    }
}
