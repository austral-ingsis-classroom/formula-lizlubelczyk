package edu.austral.ingsis.math.visitor;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Map;
import org.junit.jupiter.api.Test;

public class ResolutionWithVariablesTest {

  EvaluatorVisitor evaluatorVisitor = new EvaluatorVisitor();

  /** Case 1 + x where x = 3 */
  @Test
  public void shouldResolveFunction1() {
    EvaluatorVisitor testEvaluatorVisitor =
        evaluatorVisitor.setVariables(Map.of("x", new Value(3)));
    Function function = new Addition(new Value(1), new Variable("x"));
    final Double result = testEvaluatorVisitor.evaluate(function);

    assertThat(result, equalTo(4d));
  }

  /** Case 12 / div where div = 4 */
  @Test
  public void shouldResolveFunction2() {
    EvaluatorVisitor testEvaluatorVisitor =
        evaluatorVisitor.setVariables(Map.of("div", new Value(4)));
    Function function = new Division(new Value(12), new Variable("div"));
    final Double result = testEvaluatorVisitor.evaluate(function);

    assertThat(result, equalTo(3d));
  }

  /** Case (9 / x) * y where x = 3 and y = 4 */
  @Test
  public void shouldResolveFunction3() {
    EvaluatorVisitor testEvaluatorVisitor =
        evaluatorVisitor.setVariables(Map.of("x", new Value(3), "y", new Value(4)));
    Function function =
        new Multiplication(new Division(new Value(9), new Variable("x")), new Variable("y"));
    final Double result = testEvaluatorVisitor.evaluate(function);

    assertThat(result, equalTo(12d));
  }

  /** Case (27 / a) ^ b where a = 9 and b = 3 */
  @Test
  public void shouldResolveFunction4() {
    EvaluatorVisitor testEvaluatorVisitor =
        evaluatorVisitor.setVariables(Map.of("a", new Value(9), "b", new Value(3)));
    Function function =
        new Potentiation(new Division(new Value(27), new Variable("a")), new Variable("b"));
    final Double result = testEvaluatorVisitor.evaluate(function);

    assertThat(result, equalTo(27d));
  }

  /** Case z ^ (1/2) where z = 36 */
  @Test
  public void shouldResolveFunction5() {
    EvaluatorVisitor testEvaluatorVisitor =
        evaluatorVisitor.setVariables(Map.of("z", new Value(36)));
    Function function =
        new Potentiation(new Variable("z"), new Division(new Value(1), new Value(2)));
    final Double result = testEvaluatorVisitor.evaluate(function);

    assertThat(result, equalTo(6d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction6() {
    EvaluatorVisitor testEvaluatorVisitor =
        evaluatorVisitor.setVariables(Map.of("value", new Value(8)));
    Function function = new Substraction(new AbsoluteValue(new Variable("value")), new Value(8));
    final Double result = testEvaluatorVisitor.evaluate(function);

    assertThat(result, equalTo(0d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction7() {
    EvaluatorVisitor testEvaluatorVisitor =
        evaluatorVisitor.setVariables(Map.of("value", new Value(8)));
    Function function = new Substraction(new AbsoluteValue(new Variable("value")), new Value(8));
    final Double result = testEvaluatorVisitor.evaluate(function);

    assertThat(result, equalTo(0d));
  }

  /** Case (5 - i) * 8 where i = 2 */
  @Test
  public void shouldResolveFunction8() {
    EvaluatorVisitor testEvaluatorVisitor =
        evaluatorVisitor.setVariables(Map.of("i", new Value(2)));
    Function function =
        new Multiplication(new Substraction(new Value(5), new Variable("i")), new Value(8));
    final Double result = testEvaluatorVisitor.evaluate(function);

    assertThat(result, equalTo(24d));
  }
}
