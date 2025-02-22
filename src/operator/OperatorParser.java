package operator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static exception.ErrorMessage.MUST_CHANGE_NUMBER;
import static separator.Separator.COLON_SEPARATOR;
import static separator.Separator.REST_SEPARATOR;

public class OperatorParser {

    private OperatorParser() {
    }

    public static Double parseDouble(String number){
        try {
            return Double.parseDouble(number);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(MUST_CHANGE_NUMBER.getMessage());
        }
    }

    public static String replaceSeparatorToOperator(String input, String symbol) {
        String replacedSeparatorToOperator = input.replace(COLON_SEPARATOR.getSeparator(), symbol)
                .replace(REST_SEPARATOR.getSeparator(), symbol);

        return replacedSeparatorToOperator.substring(0, replacedSeparatorToOperator.length() - 1);
    }

    public static List<Double> extractNumbers(String input, String symbol) {
        String regularOperator = "\\%s".formatted(symbol);

        return Arrays.stream(replaceSeparatorToOperator(input, symbol).split(regularOperator))
                .map(String::trim)
                .map(OperatorParser::parseDouble)
                .collect(Collectors.toList());
    }

}