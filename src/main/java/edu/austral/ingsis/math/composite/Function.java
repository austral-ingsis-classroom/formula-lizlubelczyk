package edu.austral.ingsis.math.composite;

import java.util.List;
import java.util.Map;
import java.util.Set;

interface Function {
    double evaluate(Map<String, Function> variables);
    String print();
    Set<String> getVariables();
}