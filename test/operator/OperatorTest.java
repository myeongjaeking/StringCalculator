package operator;

import io.InputHandler;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static exception.ErrorMessage.INPUT_EMPTY_OPERATOR;
import static exception.ErrorMessage.SEPARATOR_NOT_FOUND;

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
    @DisplayName("PlusOperation 반환")
    void testPlusOperation() {
        String testInput = "1,2:3 +\n";
        setInput(testInput);
        InputHandler inputHandler = new InputHandler();
        String input = inputHandler.getInput();
        Operator expectOperator = new PlusOperation();
        Operator actualOperator = new OperatorHandler(input).getOperator();

        String expectString = expectOperator.replaceSeparatorToOperator(input);
        String actualString = actualOperator.replaceSeparatorToOperator(input);

        Assertions.assertEquals(expectString, actualString);
    }

    @Test
    @DisplayName("MinusOperation 반환")
    void testMinusOperation() {
        String testInput = "1,2:3 -\n";
        setInput(testInput);
        InputHandler inputHandler = new InputHandler();
        String input = inputHandler.getInput();
        Operator expectOperator = new MinusOperation();
        Operator actualOperator = new OperatorHandler(input).getOperator();

        String expectString = expectOperator.replaceSeparatorToOperator(input);
        String actualString = actualOperator.replaceSeparatorToOperator(input);

        Assertions.assertEquals(expectString, actualString);
    }

    @Test
    @DisplayName("DivideOperation 반환")
    void testDivideOperation() {
        String testInput = "1,2:3 /\n";
        setInput(testInput);
        InputHandler inputHandler = new InputHandler();
        String input = inputHandler.getInput();

        Operator expectOperator = new DivideOperation();
        String expectString = expectOperator.replaceSeparatorToOperator(input);

        Operator actualOperator = new OperatorHandler(input).getOperator();
        String actualString = actualOperator.replaceSeparatorToOperator(input);

        Assertions.assertEquals(expectString, actualString);
    }

    @Test
    @DisplayName("MultiplyOperation 반환")
    void testMultiplyOperation() {
        String testInput = "1,2:3 *\n";
        setInput(testInput);
        InputHandler inputHandler = new InputHandler();
        String input = inputHandler.getInput();

        Operator expectOperator = new MultiplyOperation();
        String expectString = expectOperator.replaceSeparatorToOperator(input);

        Operator actualOperator = new OperatorHandler(input).getOperator();
        String actualString = actualOperator.replaceSeparatorToOperator(input);

        Assertions.assertEquals(expectString, actualString);
    }

    @Test
    @DisplayName("사칙연산에 없는 operator 예외발생")
    void testValidExistOperation() {
        String testInput = "1,2:3 ?\n";
        setInput(testInput);
        InputHandler inputHandler = new InputHandler();
        String input = inputHandler.getInput();

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                new OperatorHandler(input));

        Assertions.assertEquals(exception.getMessage(), INPUT_EMPTY_OPERATOR.getMessage());
    }

    @Test
    @DisplayName("유효하지 않은 구분자가 존재하면 예외발생")
    void testValidNotFoundSeparator() {
        String testInput = "1+2:3 +\n";
        setInput(testInput);
        InputHandler inputHandler = new InputHandler();
        String input = inputHandler.getInput();

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                new OperatorHandler(input));

        Assertions.assertEquals(exception.getMessage(), SEPARATOR_NOT_FOUND.getMessage());
    }

    @Test
    @DisplayName("MultiplyOperation 의 extractStringToDouble 메서드 List<Double> 반환")
    void testExtractMultiplyOperation() {
        String testInput = "1,2:3 *\n";
        setInput(testInput);
        InputHandler inputHandler = new InputHandler();
        String input = inputHandler.getInput();
        Operator actualOperator = new OperatorHandler(input).getOperator();

        List<Double> expectNumbers = List.of(1.0, 2.0, 3.0);
        List<Double> actualNumbers = actualOperator.extractNumbers(input);

        Assertions.assertEquals(expectNumbers, actualNumbers);
    }

    @Test
    @DisplayName("DivideOperation 의 extractStringToDouble 메서드 List<Double> 반환")
    void testExtractDivideOperation() {
        String testInput = "1,2:3 /\n";
        setInput(testInput);
        InputHandler inputHandler = new InputHandler();
        String input = inputHandler.getInput();
        Operator actualOperator = new OperatorHandler(input).getOperator();

        List<Double> expectNumbers = List.of(1.0, 2.0, 3.0);
        List<Double> actualNumbers = actualOperator.extractNumbers(input);

        Assertions.assertEquals(expectNumbers, actualNumbers);
    }

    @Test
    @DisplayName("MinusOperation 반환")
    void testExtractMinusOperation() {
        String testInput = "1,2:3 -\n";
        setInput(testInput);
        InputHandler inputHandler = new InputHandler();
        String input = inputHandler.getInput();
        Operator actualOperator = new OperatorHandler(input).getOperator();

        List<Double> expectNumbers = List.of(1.0, 2.0, 3.0);
        List<Double> actualNumbers = actualOperator.extractNumbers(input);

        Assertions.assertEquals(expectNumbers, actualNumbers);
    }

    @Test
    @DisplayName("PlusOperation 반환")
    void testExtractPlusOperation() {
        String testInput = "1,2:3 +\n";
        setInput(testInput);
        InputHandler inputHandler = new InputHandler();
        String input = inputHandler.getInput();
        Operator actualOperator = new OperatorHandler(input).getOperator();

        List<Double> expectNumbers = List.of(1.0, 2.0, 3.0);
        List<Double> actualNumbers = actualOperator.extractNumbers(input);

        Assertions.assertEquals(expectNumbers, actualNumbers);
    }

}
