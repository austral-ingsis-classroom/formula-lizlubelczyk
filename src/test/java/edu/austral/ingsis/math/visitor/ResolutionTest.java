package edu.austral.ingsis.math.visitor;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionTest {

    EvaluatorVisitor evaluatorVisitor = new EvaluatorVisitor();

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldResolveSimpleFunction1() {
        Function function = new Addition(new Value(1), new Value(6));
        final Double result = evaluatorVisitor.evaluate(function);

        assertThat(result, equalTo(7d));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldResolveSimpleFunction2() {
        Function function = new Division(new Value(12), new Value(2));
        final Double result = evaluatorVisitor.evaluate(function);

        assertThat(result, equalTo(6d));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldResolveSimpleFunction3() {
        Function function = new Multiplication(new Division(new Value(9), new Value(2)), new Value(3));
        final Double result = evaluatorVisitor.evaluate(function);

        assertThat(result, equalTo(13.5d));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldResolveSimpleFunction4() {
        Function function = new Potentiation(new Division(new Value(27), new Value(6)), new Value(2));
        final Double result = evaluatorVisitor.evaluate(function);

        assertThat(result, equalTo(20.25d));
    }

    /**
     * Case 36 ^ (1/2)
     */
    @Test
    public void shouldResolveSimpleFunction5() {
        Function function = new Potentiation(new Value(36), new Division(new Value(1), new Value(2)));
        final Double result = evaluatorVisitor.evaluate(function);

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |136|
     */
    @Test
    public void shouldResolveSimpleFunction6() {
        Function function = new AbsoluteValue(new Value(136));
        final Double result = evaluatorVisitor.evaluate(function);

        assertThat(result, equalTo(136d));
    }

    /**
     * Case |-136|
     */
    @Test
    public void shouldResolveSimpleFunction7() {
        Function function = new AbsoluteValue(new Negation(new Value(136)));
        final Double result = evaluatorVisitor.evaluate(function);

        assertThat(result, equalTo(136d));
    }

    /**
     * Case (5 - 5) * 8
     */
    @Test
    public void shouldResolveSimpleFunction8() {
        Function function = new Multiplication(new Substraction(new Value(5), new Value(5)), new Value(8));
        final Double result = evaluatorVisitor.evaluate(function);

        assertThat(result, equalTo(0d));
    }
}