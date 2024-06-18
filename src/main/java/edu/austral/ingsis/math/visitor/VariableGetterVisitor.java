package edu.austral.ingsis.math.visitor;
import java.util.HashSet;
import java.util.Set;

class VariableGetterVisitor implements Visitor<Set<String>>{


    @Override
    public Set<String> visit(AbsoluteValue absoluteValue) {
        return absoluteValue.getValue().accept(this);
    }

    @Override
    public Set<String> visit(Addition addition) {
        return joinSets(addition.getLeft(), addition.getRight());
    }

    @Override
    public Set<String> visit(Division division) {
        Set<String> variables = new HashSet<>();
        if (division.getLeft() instanceof Variable) {
            variables.add(((Variable) division.getLeft()).getName());
        } else {
            variables.addAll(division.getLeft().accept(this));
        }
        if (division.getRight() instanceof Variable) {
            variables.add(((Variable) division.getRight()).getName());
        } else {
            variables.addAll(division.getRight().accept(this));
        }
        return variables;
    }

    @Override
    public Set<String> visit(Multiplication multiplication) {
        return joinSets(multiplication.getLeft(), multiplication.getRight());
    }

    @Override
    public Set<String> visit(Negation negation) {
        return negation.getValue().accept(this);
    }

    @Override
    public Set<String> visit(Potentiation potentiation) {
        return joinSets(potentiation.getBase(), potentiation.getExponent());
    }

    @Override
    public Set<String> visit(SquareRoot squareRoot) {
        return squareRoot.getValue().accept(this);
    }

    @Override
    public Set<String> visit(Substraction subtraction) {
        return joinSets(subtraction.getLeft(), subtraction.getRight());
    }

    @Override
    public Set<String> visit(Value value) {
        return new HashSet<>();
    }

    @Override
    public Set<String> visit(Variable variable) {
        return Set.of(variable.getName());
    }

    private Set<String> joinSets(Function left, Function right) {
        Set<String> leftVariables = left.accept(this);
        if (leftVariables == null) {
            leftVariables = new HashSet<>();
        }

        Set<String> rightVariables = right.accept(this);
        if (rightVariables == null) {
            rightVariables = new HashSet<>();
        }

        Set<String> variables = new HashSet<>();
        variables.addAll(leftVariables);
        variables.addAll(rightVariables);
        return variables;
    }

    public Set<String> getVariables(Function function){
        return function.accept(this);
    }
}
