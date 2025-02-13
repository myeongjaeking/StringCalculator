package validation;

import static exception.ErrorMessage.*;

public class InputValidation {

    private final String input;

    public InputValidation(String input) {
        this.input = input;
        validateInput();
    }

    private void validateNullInput() {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(INPUT_NOT_NULL.getMessage());
        }
    }

    private void validateConsecutiveSeparators() {
        int count = 0;

        for (int i = 0; i < input.length() - 1; ++i) {
            char currentChar = input.charAt(i);
            if (Character.isDigit(currentChar)) {
                count = 0;
            } else {
                ++count;
                if (count == 2) {
                    throw new IllegalArgumentException(CONTINUOUS_SEPARATOR.getMessage());
                }
            }
        }
    }

    private void validateOperatorPrecededBySpace() {
        boolean isOperatorPrecededBySpace = input.substring(input.length() - 2, input.length() - 1).equals(" ");

        if (!isOperatorPrecededBySpace) {
            throw new IllegalArgumentException(OPERATOR_MUST_HAVE_PRECEDING_SPACE.getMessage());
        }
    }

    public void validateInput() {
        validateNullInput();
        validateConsecutiveSeparators();
        validateOperatorPrecededBySpace();
    }

}