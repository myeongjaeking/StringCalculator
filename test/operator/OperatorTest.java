package operator;

import io.Input;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validation.InputValidation;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static exception.ErrorMessage.INPUT_EMPTY_OPERATOR;
import static exception.ErrorMessage.SEPARATOR_NOT_FOUND;
import static validation.InputValidation.SYMBOL;

public class OperatorTest {

    private final InputStream systemIn = System.in;
    private InputValidation inputValidation;

    @BeforeEach
    public void setUp() {
        inputValidation = new InputValidation();
    }

    private Input prepareInput(String data) {
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        return new Input(inputValidation);
    }

    private List<Double> prepareOperatorParser(String data) {
        Input input = prepareInput(data);
        String userInput = input.getInput();
        Operation actualOperator = Operation.fromSymbol(SYMBOL);
        OperatorParser operatorParser = new OperatorParser(userInput, actualOperator.getSymbol());
        return operatorParser.extractNumbers();
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
    }

    @Test
    @DisplayName("사칙연산에 없는 operator 예외발생")
    void testValidExistOperation() {
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> prepareInput("1,2:3 ?\n"));

        Assertions.assertEquals(INPUT_EMPTY_OPERATOR.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("유효하지 않은 구분자가 존재하면 예외발생")
    void testValidNotFoundSeparator() {
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> prepareInput("1+2:3 +\n"));

        Assertions.assertEquals(SEPARATOR_NOT_FOUND.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("MultiplyOperation 의 extractStringToDouble 메서드 List<Double> 반환")
    void testExtractMultiplyOperation() {
        Assertions.assertEquals(List.of(1.0, 2.0, 3.0), prepareOperatorParser("1,2:3 *\n"));
    }

    @Test
    @DisplayName("DivideOperation 의 extractStringToDouble 메서드 List<Double> 반환")
    void testExtractDivideOperation() {
        Assertions.assertEquals(List.of(1.0, 2.0, 3.0), prepareOperatorParser("1,2:3 /\n"));
    }

    @Test
    @DisplayName("MinusOperation Operands 리스트 형식으로 정상적으로 반환")
    void testExtractMinusOperation() {
        Assertions.assertEquals(List.of(1.0, 2.0, 3.0), prepareOperatorParser("1,2:3 -\n"));
    }

    @Test
    @DisplayName("PlusOperation Operands 리스트 형식으로 정상적으로 반환")
    void testExtractPlusOperation() {
        Assertions.assertEquals(List.of(1.0, 2.0, 3.0), prepareOperatorParser("1,2:3 +\n"));
    }

}