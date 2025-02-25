package io;

import exception.ErrorMessage;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputTest {

    private final InputStream systemIn;

    public InputTest() {
        this.systemIn = System.in;
    }

    private void setInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
    }

    @Test
    @DisplayName("입력 문자열 반환을 정상적으로 수행하는지 확인한다.")
    void testGetInput() {
        String testInput = "1,2:3 +\n";
        setInput(testInput);
        Input input = new Input();
        input.typeInput();

        String actualInput = input.getInput();

        Assertions.assertEquals("1,2:3 +", actualInput);
    }

    @Test
    @DisplayName("입력 문자열이 개행문자만 존재할 때 예외가 발생한다.")
    void testValidNullInput() {
        String testInput = "\n";
        setInput(testInput);
        Input input = new Input();

        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, input::typeInput);

        Assertions.assertEquals(ErrorMessage.INPUT_NOT_EMPTY.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("입력 문자열에 연속된 구분자가 존재할 때 예외가 발생한다.")
    void testValidateConsecutiveSeparators() {
        String testInput = "1,2,:3 +\n";
        setInput(testInput);
        Input input = new Input();

        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, input::typeInput);

        Assertions.assertEquals(ErrorMessage.CONTINUOUS_SEPARATOR.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("입력 문자열의 사칙연산 앞의 문자가 공백이 아닐 경우 예외가 발생한다.")
    void testValidateOperatorPrecededBySpace() {
        String testInput = "1,2,3+\n";
        setInput(testInput);
        Input input = new Input();

        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, input::typeInput);

        Assertions.assertEquals(ErrorMessage.CONTINUOUS_SEPARATOR.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("입력 문자열의 공백이 존재할 때 예외가 발생한다.")
    void testValidateBlank() {
        String testInput = " 1,2,:3 +\n";
        setInput(testInput);
        Input input = new Input();

        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, input::typeInput);

        Assertions.assertEquals(ErrorMessage.INPUT_NOT_BLANK.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("입력 문자열 중간에 사칙연산자가 존재할 때 예외가 발생한다.")
    void testIsOperatorLastIndex() {
        String testInput = "1,2+3 +\n";
        setInput(testInput);
        Input input = new Input();

        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, input::typeInput);

        Assertions.assertEquals(ErrorMessage.OPERATOR_MUST_LAST_INDEX.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("입력 문자열 마지막 문자가 유효한 연산자가 아닐 때 예외가 발생한다.")
    void testIsSymbol() {
        String testInput = "1,2:3 \n";
        setInput(testInput);
        Input input = new Input();

        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, input::typeInput);

        Assertions.assertEquals(ErrorMessage.INPUT_EMPTY_OPERATOR.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("입력 문자열에 공백이 있을 경우 예외가 발생한다.")
    void testContainBlank() {
        String testInput = "1 ,2:3 +\n";
        setInput(testInput);
        Input input = new Input();

        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, input::typeInput);

        Assertions.assertEquals(ErrorMessage.INPUT_NOT_BLANK.getMessage(), exception.getMessage());
    }

}