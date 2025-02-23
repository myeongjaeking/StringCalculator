package calculator;

import operator.Operation;
import operator.OperatorParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static exception.ErrorMessage.CANNOT_DIVIDE_BY_ZERO;
import static validation.InputValidation.SYMBOL;

class CalculatorTest {

    private void testCalculator(String input,double expectResult){
        Operation operation = Operation.fromSymbol(SYMBOL);
        OperatorParser operatorParser = new OperatorParser(input,operation.getSymbol());
        List<Double> numbers = operatorParser.extractNumbers();
        double actualResult = Calculator.calculate(numbers,operation);

        Assertions.assertEquals(actualResult,expectResult);
    }

    @Test
    @DisplayName("덧셈 연산이 정상적으로 작동하는지 확인한다.")
    void getPlusResult() {
        String input = "1,2,3 +";
        double expectResult = 6.0;

        testCalculator(input,expectResult);
    }

    @Test
    @DisplayName("빼기 연산이 정상적으로 작동하는지 확인한다.")
    void getMinusResult() {
        String input = "1,2,3 -";
        double expectResult = -4.0;

        testCalculator(input,expectResult);
    }

    @Test
    @DisplayName("곱하기 연산이 정상적으로 작동하는지 확인한다.")
    void getMultiplyResult() {
        String input = "1,2,3 *";
        double expectResult = 6.0;

        testCalculator(input,expectResult);
    }

    @Test
    @DisplayName("나누기 연산이 정상적으로 작동하는지 확인한다.")
    void getDivideResult() {
        String input = "1,2,3 /";
        double expectResult = 0.16666666666666666;

        testCalculator(input,expectResult);
    }

    @Test
    @DisplayName("나누기 연산의 분모가 0일 때 예외발생가 발생한다.")
    void getValidDivideResult() {
        String input = "1,0,3 /";
        Operation operator = Operation.fromSymbol('/');
        OperatorParser operatorParser = new OperatorParser(input,operator.getSymbol());
        List<Double> operands = operatorParser.extractNumbers();

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                Calculator.calculate(operands, operator));

        Assertions.assertEquals(exception.getMessage(), CANNOT_DIVIDE_BY_ZERO.getMessage());
    }

}