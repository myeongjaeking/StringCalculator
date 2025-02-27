package io;

import exception.ErrorMessage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validation.InputValidation;

public class InputTest {

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

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
    }

    @Test
    @DisplayName("입력 문자열 반환을 정상적으로 수행하는지 확인한다.")
    void testGetInput() {
        Input input = prepareInput("1,2:3 +\n");

        input.typeInput();

        Assertions.assertEquals("1,2:3 +", input.getInput());
    }

    @Test
    @DisplayName("입력 문자열이 개행문자만 존재할 때 예외가 발생한다.")
    void testValidNullInput() {
        Input input = prepareInput("\n");

        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, input::typeInput);

        Assertions.assertEquals(ErrorMessage.INPUT_NOT_EMPTY.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("입력 문자열에 연속된 구분자가 존재할 때 예외가 발생한다.")
    void testValidateConsecutiveSeparators() {
        Input input = prepareInput("1,2,:3 +\n");

        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, input::typeInput);

        Assertions.assertEquals(ErrorMessage.CONTINUOUS_SEPARATOR.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("입력 문자열의 사칙연산 앞의 문자가 공백이 아닐 경우 예외가 발생한다.")
    void testValidateOperatorPrecededBySpace() {
        Input input = prepareInput("1,2,3+\n");

        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, input::typeInput);

        Assertions.assertEquals(ErrorMessage.CONTINUOUS_SEPARATOR.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("입력 문자열의 공백이 존재할 때 예외가 발생한다.")
    void testValidateBlank() {
        Input input = prepareInput(" 1,2,:3 +\n");

        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, input::typeInput);

        Assertions.assertEquals(ErrorMessage.INPUT_NOT_BLANK.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("입력 문자열 중간에 사칙연산자가 존재할 때 예외가 발생한다.")
    void testIsOperatorLastIndex() {
        Input input = prepareInput("1,2+3 +\n");

        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, input::typeInput);

        Assertions.assertEquals(ErrorMessage.OPERATOR_MUST_LAST_INDEX.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("입력 문자열 마지막 문자가 유효한 연산자가 아닐 때 예외가 발생한다.")
    void testIsSymbol() {
        Input input = prepareInput("1,2:3 \n");

        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, input::typeInput);

        Assertions.assertEquals(ErrorMessage.INPUT_EMPTY_OPERATOR.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("입력 문자열에 공백이 있을 경우 예외가 발생한다.")
    void testContainBlank() {
        Input input = prepareInput("1 ,2:3 +\n");

        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, input::typeInput);

        Assertions.assertEquals(ErrorMessage.INPUT_NOT_BLANK.getMessage(), exception.getMessage());
    }

}