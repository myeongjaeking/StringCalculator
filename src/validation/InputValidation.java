package validation;

import static exception.ErrorMessage.*;

public class InputValidation {

    private InputValidation() {
    }

    public static void validateInput(String input) {
        validateNullInput(input);
        char symbol = getOperatorChar(input);
        isInputContainOperator(input, symbol);
        isSymbol(symbol);
        validateBlank(input);
        validateConsecutiveSeparators(input);
        validateOperatorPrecededBySpace(input);
    }

    private static char getOperatorChar(String input) {
        return input.charAt(input.length() - 1);
    }

    private static void validateNullInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(INPUT_NOT_NULL.getMessage());
        }
    }

    private static void validateBlank(String input) {
        String validateInput = input.substring(0, input.length() - 2);
        if (validateInput.contains(" ")) {
            throw new IllegalArgumentException(INPUT_NOT_BLANK.getMessage());
        }
    }

    private static void validateConsecutiveSeparators(String input) {
        int count = 0;

        for (int i = 0; i < input.length() - 1; ++i) {
            char currentChar = input.charAt(i);

            if (Character.isDigit(currentChar)) {
                count = 0;
                continue;
            }

            ++count;
            if (count == 2) {
                throw new IllegalArgumentException(CONTINUOUS_SEPARATOR.getMessage());
            }
        }
    }

    private static void validateOperatorPrecededBySpace(String input) {
        boolean isOperatorPrecededBySpace = input.charAt(input.length() - 2) == ' ';

        if (!isOperatorPrecededBySpace) {
            throw new IllegalArgumentException(OPERATOR_MUST_HAVE_PRECEDING_SPACE.getMessage());
        }
    }

    private static void isInputContainOperator(String input, char symbol) {
        String inputContainOperator = input.substring(0, input.length() - 1);

        if (inputContainOperator.contains(String.valueOf(symbol))) {
            throw new IllegalArgumentException(SEPARATOR_NOT_FOUND.getMessage());
        }
    }

    private static void isSymbol(char symbol) {
        boolean isValidOperator = symbol == '+' || symbol == '-' || symbol == '*' || symbol == '/';

        if (!isValidOperator) {
            throw new IllegalArgumentException(INPUT_EMPTY_OPERATOR.getMessage());
        }
    }

}