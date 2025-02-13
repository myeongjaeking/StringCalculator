package calculator;

import operator.Operator;

import java.util.List;

public class Calculate {

    public static double getResult(List<Double> numbers, Operator operator) {
        double result = numbers.get(0);

        for (int i = 1; i < numbers.size(); i++) {
            result = operator.calculate(result, numbers.get(i));
        }

        return result;
    }

}