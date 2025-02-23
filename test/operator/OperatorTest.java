package operator;

import io.Input;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static exception.ErrorMessage.INPUT_EMPTY_OPERATOR;
import static exception.ErrorMessage.SEPARATOR_NOT_FOUND;
import static validation.InputValidation.SYMBOL;

public class OperatorTest {

    private final InputStream systemIn;
    private ByteArrayInputStream testIn;

    public OperatorTest() {
        this.systemIn = System.in;
    }

    private void setInput(String data) {
        this.testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(this.testIn);
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(this.systemIn);
    }

    @Test
    @DisplayName("사칙연산에 없는 operator 예외발생")
    void testValidExistOperation() {
        String testInput = "1,2:3 ?\n";
        setInput(testInput);

        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, Input::new);

        Assertions.assertEquals(exception.getMessage(), INPUT_EMPTY_OPERATOR.getMessage());
    }

    @Test
    @DisplayName("유효하지 않은 구분자가 존재하면 예외발생")
    void testValidNotFoundSeparator() {
        String testInput = "1+2:3 +\n";
        setInput(testInput);

        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, Input::new);

        Assertions.assertEquals(exception.getMessage(), SEPARATOR_NOT_FOUND.getMessage());
    }

    @Test
    @DisplayName("MultiplyOperation 의 extractStringToDouble 메서드 List<Double> 반환")
    void testExtractMultiplyOperation() {
        String testInput = "1,2:3 *\n";
        setInput(testInput);
        Input input = new Input();
        String userInput = input.getInput();
        Operation actualOperator = Operation.fromSymbol(SYMBOL);
        OperatorParser operatorParser = new OperatorParser(userInput,actualOperator.getSymbol());

        List<Double> actualOperands = operatorParser.extractNumbers();

        Assertions.assertEquals(List.of(1.0, 2.0, 3.0), actualOperands);
    }

    @Test
    @DisplayName("DivideOperation 의 extractStringToDouble 메서드 List<Double> 반환")
    void testExtractDivideOperation() {
        String testInput = "1,2:3 /\n";
        setInput(testInput);
        Input input = new Input();
        String userInput = input.getInput();
        Operation actualOperator = Operation.fromSymbol(SYMBOL);
        OperatorParser operatorParser = new OperatorParser(userInput,actualOperator.getSymbol());

        List<Double> actualOperands = operatorParser.extractNumbers();

        Assertions.assertEquals(List.of(1.0, 2.0, 3.0), actualOperands);
    }

    @Test
    @DisplayName("MinusOperation Operands 리스트 형식으로 정상적으로 반환")
    void testExtractMinusOperation() {
        String testInput = "1,2:3 -\n";
        setInput(testInput);
        Input input = new Input();
        String userInput = input.getInput();
        Operation actualOperator = Operation.fromSymbol(SYMBOL);
        OperatorParser operatorParser = new OperatorParser(userInput,actualOperator.getSymbol());

        List<Double> actualOperands = operatorParser.extractNumbers();

        Assertions.assertEquals(List.of(1.0, 2.0, 3.0), actualOperands);
    }

    @Test
    @DisplayName("PlusOperation Operands 리스트 형식으로 정상적으로 반환")
    void testExtractPlusOperation() {
        String testInput = "1,2:3 +\n";
        setInput(testInput);
        Input input = new Input();
        String userInput = input.getInput();
        Operation actualOperator = Operation.fromSymbol(SYMBOL);
        OperatorParser operatorParser = new OperatorParser(userInput,actualOperator.getSymbol());

        List<Double> actualOperands = operatorParser.extractNumbers();

        Assertions.assertEquals(List.of(1.0, 2.0, 3.0), actualOperands);
    }

}