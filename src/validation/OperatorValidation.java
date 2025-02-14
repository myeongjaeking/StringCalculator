package validation;

import static exception.ErrorMessage.INPUT_EMPTY_OPERATOR;
import static exception.ErrorMessage.SEPARATOR_NOT_FOUND;

public class OperatorValidation {

    private static void isInputContainOperator(String input, char operator) {
        String inputContainOperator = input.substring(0, input.length() - 1);

        if (inputContainOperator.contains(String.valueOf(operator))) {
            throw new IllegalArgumentException(SEPARATOR_NOT_FOUND.getMessage());
        }
    }

    private static void isOperator(char operator) {
        boolean isValidOperator = operator == '+' || operator == '-' || operator == '*' || operator == '/';

        if (!isValidOperator) {
            throw new IllegalArgumentException(INPUT_EMPTY_OPERATOR.getMessage());
        }
    }

    public static void validateOperator(String input, char operator) {
        isInputContainOperator(input, operator);
        isOperator(operator);
    }

}
