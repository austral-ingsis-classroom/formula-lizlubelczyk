package edu.austral.ingsis.math.visitor;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrintTest {

    PrinterVisitor printerVisitor = new PrinterVisitor();

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldPrintFunction1() {
        final String expected = "(1 + 6)";
        final Function function = new Addition(new Value(1), new Value(6));

        final String result = printerVisitor.print(function);

        assertThat(result, equalTo(expected));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldPrintFunction2() {
        final String expected = "(12 / 2)";
        Function function = new Division(new Value(12), new Value(2));

        final String result = printerVisitor.print(function);

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldPrintFunction3() {
        final String expected = "((9 / 2) * 3)";
        Function function = new Multiplication(new Division(new Value(9), new Value(2)), new Value(3));

        final String result = printerVisitor.print(function);

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldPrintFunction4() {
        final String expected = "((27 / 6) ^ 2)";
        Function function = new Potentiation(new Division(new Value(27), new Value(6)), new Value(2));

        final String result = printerVisitor.print(function);

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |-8| - 8
     */
    @Test
    public void shouldPrintFunction6() {
        final String expected = "(|-8| - 8)";
        Function function = new Substraction(new AbsoluteValue(new Negation(new Value(8))), new Value(8));

        final String result = printerVisitor.print(function);

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction7() {
        final String expected = "(|value| - 8)";
        Function function = new Substraction(new AbsoluteValue(new Variable("value")), new Value(8));

        final String result = printerVisitor.print(function);

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldPrintFunction8() {
        final String expected = "((5 - i) * 8)";
        Function function = new Multiplication(new Substraction(new Value(5), new Variable("i")), new Value(8));
        final String result = printerVisitor.print(function);

        assertThat(result, equalTo(expected));
    }
}