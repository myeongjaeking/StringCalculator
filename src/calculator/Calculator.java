package calculator;

import operator.Operation;

import java.util.List;

public class Calculator {

    private Calculator() {
    }

    public static double calculate(List<Double> numbers, Operation operator) {
        double result = numbers.get(0);

        for (int i = 1; i < numbers.size(); i++) {
            result = operator.calculate(result, numbers.get(i));
        }

        return result;
    }

}