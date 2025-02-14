package calculator;

import operator.Operator;
import operator.OperatorHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static exception.ErrorMessage.CANNOT_DIVIDE_BY_ZERO;

class CalculateTest {

    @Test
    @DisplayName("덧셈 연산")
    void getPlusResult() {
        String input = "1,2,3 +";
        Operator operator = new OperatorHandler(input).getOperator();
        List<Double> numbers = operator.extractNumbers(input);

        double expectResult = 6.0;
        double actualResult = Calculate.getResult(numbers, operator);

        Assertions.assertEquals(actualResult, expectResult);
    }

    @Test
    @DisplayName("빼기 연산")
    void getMinusResult() {
        String input = "1,2,3 -";
        Operator operator = new OperatorHandler(input).getOperator();
        List<Double> numbers = operator.extractNumbers(input);

        double expectResult = -4.0;
        double actualResult = Calculate.getResult(numbers, operator);

        Assertions.assertEquals(actualResult, expectResult);
    }

    @Test
    @DisplayName("곱하기 연산")
    void getMultiplyResult() {
        String input = "1,2,3 *";
        Operator operator = new OperatorHandler(input).getOperator();
        List<Double> numbers = operator.extractNumbers(input);

        double expectResult = 6.0;
        double actualResult = Calculate.getResult(numbers, operator);

        Assertions.assertEquals(actualResult, expectResult);
    }

    @Test
    @DisplayName("나누기 연산")
    void getDivideResult() {
        String input = "1,2,3 /";
        Operator operator = new OperatorHandler(input).getOperator();
        List<Double> numbers = operator.extractNumbers(input);

        double expectResult = 0.16666666666666666;
        double actualResult = Calculate.getResult(numbers, operator);

        Assertions.assertEquals(actualResult, expectResult);
    }

    @Test
    @DisplayName("나누기 연산의 분모가 0일 때 예외발생")
    void getValidDivideResult() {
        String input = "1,0,3 /";
        Operator operator = new OperatorHandler(input).getOperator();
        List<Double> numbers = operator.extractNumbers(input);

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                Calculate.getResult(numbers, operator));

        Assertions.assertEquals(exception.getMessage(), CANNOT_DIVIDE_BY_ZERO.getMessage());
    }

}