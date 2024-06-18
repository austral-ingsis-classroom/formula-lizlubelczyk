package edu.austral.ingsis.math.composite;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Potentiation implements Function{
    private final Function base;
    private final Function exponent;

    public Potentiation(Function base, Function exponent) {
        this.base = base;
        this.exponent = exponent;
    }

    @Override
    public double evaluate(Map<String, Function> variables) {
        return Math.pow(base.evaluate(variables), exponent.evaluate(variables));
    }

    @Override
    public String print() {
        return "(" + base.print() + " ^ " + exponent.print() + ")";
    }

    @Override
    public Set<String> getVariables() {
        Set<String> leftVariables = base.getVariables();
        Set<String> rightVariables = exponent.getVariables();
        return new HashSet<>(leftVariables) {{
            addAll(rightVariables);
        }};
    }
}
