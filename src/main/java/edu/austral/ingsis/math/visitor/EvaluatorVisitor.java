package edu.austral.ingsis.math.visitor;

import java.util.Map;

public class EvaluatorVisitor implements Visitor<Double>{

    private final Map<String, Function> variables;

    public EvaluatorVisitor(Map<String, Function> variables) {
        this.variables = variables;
    }

    public EvaluatorVisitor() {
        this.variables = Map.of();
    }

    public EvaluatorVisitor setVariables(Map<String, Function> variables) {
        return new EvaluatorVisitor(variables);
    }

    public Double evaluate (Function function) {
        return function.accept(this);
    }
    @Override
    public Double visit(AbsoluteValue absoluteValue) {
        return Math.abs(absoluteValue.getValue().accept(this));
    }

    @Override
    public Double visit(Addition addition) {
        return addition.getLeft().accept(this) + addition.getRight().accept(this);
    }

    @Override
    public Double visit(Division division) {
        return division.getLeft().accept(this) / division.getRight().accept(this);
    }

    @Override
    public Double visit(Multiplication multiplication) {
        return multiplication.getLeft().accept(this) * multiplication.getRight().accept(this);
    }

    @Override
    public Double visit(Negation negation) {
        return -negation.getValue().accept(this);
    }

    @Override
    public Double visit(Potentiation potentiation) {
        return Math.pow(potentiation.getBase().accept(this), potentiation.getExponent().accept(this));
    }

    @Override
    public Double visit(SquareRoot squareRoot) {
        return Math.sqrt(squareRoot.getValue().accept(this));
    }

    @Override
    public Double visit(Substraction subtraction) {
        return subtraction.getLeft().accept(this) - subtraction.getRight().accept(this);
    }

    @Override
    public Double visit(Value value) {
        return value.getValue();
    }

    @Override
    public Double visit(Variable variable) {
        return variables.get(variable.getName()).accept(this);
    }
}
