package validation;

import static exception.ErrorMessage.*;

public class InputValidation {

    private static void validateNullInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(INPUT_NOT_NULL.getMessage());
        }
    }

    private static void validateConsecutiveSeparators(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (Character.isDigit(currentChar)) {
                count = 0;
                continue;
            }
            count++;
            if (count == 2) {
                throw new IllegalArgumentException(CONTINUOUS_SEPARATOR.getMessage());
            }
        }
    }

    private static void validateOperatorPrecededBySpace(String input) {
        boolean isOperatorPrecededBySpace = input.substring(input.length() - 2, input.length() - 1).equals(" ");

        if (!isOperatorPrecededBySpace) {
            throw new IllegalArgumentException(OPERATOR_MUST_HAVE_PRECEDING_SPACE.getMessage());
        }
    }

    public static void validateInput(String input) {
        validateNullInput(input);
        validateConsecutiveSeparators(input);
        validateOperatorPrecededBySpace(input);
    }

}