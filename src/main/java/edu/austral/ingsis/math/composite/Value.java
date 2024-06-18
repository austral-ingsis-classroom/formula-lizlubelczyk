package edu.austral.ingsis.math.composite;

import java.util.Map;
import java.util.Set;

public class Value implements Function{
    private final double value;

    public Value(double value) {
        this.value = value;
    }
    @Override
    public double evaluate(Map<String, Function> variables) {
        return value;
    }

    @Override
    public String print() {
        return this.formatValue();
    }

    @Override
    public Set<String> getVariables() {
        return Set.of();
    }

    private String formatValue(){
        if(value % 1 == 0){
            return String.valueOf((int) value);
        }
        return String.valueOf(value);
    }
}
