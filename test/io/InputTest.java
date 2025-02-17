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
    private ByteArrayInputStream testIn;

    public InputTest() {
        this.systemIn = System.in;
    }

    private void setInput(String data) {
        this.testIn = new ByteArrayInputStream(data.getBytes());
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

        String expectInput = "1,2:3 +";
        String actualInput = input.getInput();

        Assertions.assertEquals(actualInput, expectInput);
    }

    @Test
    @DisplayName("입력 문자열이 비어있을 때 예외가 발생한다.")
    void testValidNullInput() {
        String testInput = "\n";
        setInput(testInput);

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, Input::new);

        Assertions.assertEquals(ErrorMessage.INPUT_NOT_NULL.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("입력 문자열에 연속된 구분자가 존재할 때 예외가 발생한다.")
    void testValidateConsecutiveSeparators() {
        String testInput = "1,2,:3 +\n";
        setInput(testInput);

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, Input::new);

        Assertions.assertEquals(ErrorMessage.CONTINUOUS_SEPARATOR.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("입력 문자열의 사칙연산 앞의 문자가 공백이 아닐 경우 예외가 발생한다.")
    void testValidateOperatorPrecededBySpace() {
        String testInput = "1,2,:3 +\n";
        setInput(testInput);

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, Input::new);

        Assertions.assertEquals(ErrorMessage.CONTINUOUS_SEPARATOR.getMessage(), exception.getMessage());
    }

}