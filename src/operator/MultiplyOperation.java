package operator;

import java.util.ArrayList;
import java.util.List;

import static exception.ErrorMessage.MUST_CHANGE_NUMBER;
import static separator.Separator.COLON_SEPARATOR;
import static separator.Separator.REST_SEPARATOR;

public class MultiplyOperation implements Operator {

    private final String multiply = "*";

    @Override
    public String replaceSeparatorToOperator(String input) {
        String replacedSeparatorToOperator = input.replace(COLON_SEPARATOR.getSeparator(), multiply)
                .replace(REST_SEPARATOR.getSeparator(), multiply);
        return replacedSeparatorToOperator.substring(0, replacedSeparatorToOperator.length() - 1);
    }

    @Override
    public List<Double> extractStringToDouble(String input) {
        String[] numberString = replaceSeparatorToOperator(input).split("\\*");
        List<Double> numbers = new ArrayList<>();

        for (String number : numberString) {
            try {
                numbers.add(Double.parseDouble(number.trim()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(MUST_CHANGE_NUMBER.getMessage());
            }
        }

        return numbers;
    }

    @Override
    public Double calculate(double a, double b) {
        return a * b;
    }

}