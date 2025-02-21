package calculator;

import operator.Operation;

import java.util.List;

import static exception.ErrorMessage.MUST_CHANGE_NUMBER;

public class Calculator {

    private Calculator() {
    }

    public static double calculate(List<Double> operands, Operation operator) {
        return operands.stream().reduce(operator::calculate).orElseThrow(() ->
                new IllegalArgumentException(MUST_CHANGE_NUMBER.getMessage()));
    }

}