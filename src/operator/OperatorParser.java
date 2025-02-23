package operator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static exception.ErrorMessage.MUST_CHANGE_NUMBER;
import static separator.Separator.COLON_SEPARATOR;
import static separator.Separator.REST_SEPARATOR;
import static validation.InputValidation.LAST_SYMBOL_INDEX;

public class OperatorParser {

    private final String input;
    private final String symbol;

    public OperatorParser(String input, String symbol) {
        this.input = input;
        this.symbol = symbol;
    }

    private static Double parseDouble(String operand) {
        try {
            return Double.parseDouble(operand);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MUST_CHANGE_NUMBER.getMessage());
        }
    }

    public String replaceSeparatorToOperator() {
        String replacedSeparatorToOperator = input.replace(COLON_SEPARATOR.getSeparator(), symbol)
                .replace(REST_SEPARATOR.getSeparator(), symbol);

        return replacedSeparatorToOperator.substring(0, replacedSeparatorToOperator.length() - LAST_SYMBOL_INDEX);
    }

    public List<Double> extractNumbers() {
        String regularOperator = "\\%s".formatted(symbol);

        return Arrays.stream(replaceSeparatorToOperator().split(regularOperator))
                .map(String::trim)
                .map(OperatorParser::parseDouble)
                .collect(Collectors.toList());
    }

}