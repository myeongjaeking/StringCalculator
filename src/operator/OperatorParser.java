package operator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static exception.ErrorMessage.MUST_CHANGE_NUMBER;
import static separator.Separator.COLON_SEPARATOR;
import static separator.Separator.REST_SEPARATOR;

public class OperatorParser {

    public static String replaceSeparatorToOperator(String input, String operator) {
        String replacedSeparatorToOperator = input.replace(COLON_SEPARATOR.getSeparator(), operator)
                .replace(REST_SEPARATOR.getSeparator(), operator);

        return replacedSeparatorToOperator.substring(0, replacedSeparatorToOperator.length() - 1);
    }

    public static List<Double> extractNumbers(String input, String operator) {
        String regularOperator = "\\%s".formatted(operator);

        return Arrays.stream(replaceSeparatorToOperator(input, operator).split(regularOperator))
                .map(String::trim)
                .map(number -> {
                    try {
                        return Double.parseDouble(number);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException(MUST_CHANGE_NUMBER.getMessage());
                    }
                })
                .collect(Collectors.toList());
    }

}