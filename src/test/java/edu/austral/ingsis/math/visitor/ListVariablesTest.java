package edu.austral.ingsis.math.visitor;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;

import java.util.Collection;
import org.junit.jupiter.api.Test;

public class ListVariablesTest {

  VariableGetterVisitor variableGetterVisitor = new VariableGetterVisitor();

  /** Case 1 + 6 */
  @Test
  public void shouldListVariablesFunction1() {
    Function function = new Addition(new Value(1), new Value(6));
    final Collection<String> result = variableGetterVisitor.getVariables(function);

    assertThat(result, empty());
  }

  /** Case 12 / div */
  @Test
  public void shouldListVariablesFunction2() {
    Function function = new Division(new Value(12), new Variable("div"));
    final Collection<String> result = variableGetterVisitor.getVariables(function);

    assertThat(result, containsInAnyOrder("div"));
  }

  /** Case (9 / x) * y */
  @Test
  public void shouldListVariablesFunction3() {
    Function function =
        new Multiplication(new Division(new Value(9), new Variable("x")), new Variable("y"));
    final Collection<String> result = variableGetterVisitor.getVariables(function);

    assertThat(result, containsInAnyOrder("x", "y"));
  }

  /** Case (27 / a) ^ b */
  @Test
  public void shouldListVariablesFunction4() {
    Function function =
        new Potentiation(new Division(new Value(27), new Variable("a")), new Variable("b"));
    final Collection<String> result = variableGetterVisitor.getVariables(function);

    assertThat(result, containsInAnyOrder("a", "b"));
  }

  /** Case z ^ (1/2) */
  @Test
  public void shouldListVariablesFunction5() {
    Function function =
        new Potentiation(new Variable("z"), new Division(new Value(1), new Value(2)));
    final Collection<String> result = variableGetterVisitor.getVariables(function);

    assertThat(result, containsInAnyOrder("z"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction6() {
    Function function = new Substraction(new AbsoluteValue(new Variable("value")), new Value(8));
    final Collection<String> result = variableGetterVisitor.getVariables(function);

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction7() {
    Function function = new Substraction(new AbsoluteValue(new Variable("value")), new Value(8));
    final Collection<String> result = variableGetterVisitor.getVariables(function);

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldListVariablesFunction8() {
    Function function =
        new Multiplication(new Substraction(new Value(5), new Variable("i")), new Value(8));
    final Collection<String> result = variableGetterVisitor.getVariables(function);

    assertThat(result, containsInAnyOrder("i"));
  }
}
