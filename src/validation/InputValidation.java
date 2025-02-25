package validation;

import static exception.ErrorMessage.*;

public class InputValidation {

    public static char SYMBOL;
    public static final int LAST_SYMBOL_INDEX = 1;
    private final int BEFORE_LAST_SYMBOL_INDEX = 2;

    public InputValidation() {
    }

    public void validateInput(String input) {
        validateNullInput(input);
        validateEmptyInput(input);
        SYMBOL = getOperatorChar(input);
        isSymbolLastIndex(input);
        isInputContainOperator(input);
        isSymbol();
        validateBlank(input);
        validateOperatorPrecededBySpace(input);
        validateConsecutiveSeparators(input);
    }

    private char getOperatorChar(String input) {
        return input.charAt(input.length() - LAST_SYMBOL_INDEX);
    }

    private void validateNullInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException(INPUT_NOT_NULL.getMessage());
        }
    }

    private void validateEmptyInput(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(INPUT_NOT_EMPTY.getMessage());
        }
    }

    private void validateBlank(String input) {
        String validateInput = input.substring(0, input.length() - BEFORE_LAST_SYMBOL_INDEX);
        if (validateInput.contains(" ")) {
            throw new IllegalArgumentException(INPUT_NOT_BLANK.getMessage());
        }
    }

    private void validateConsecutiveSeparators(String input) {
        int count = 0;

        for (int i = 0; i < input.length() - LAST_SYMBOL_INDEX; ++i) {
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

    private void validateOperatorPrecededBySpace(String input) {
        boolean isOperatorPrecededBySpace = input.charAt(input.length() - BEFORE_LAST_SYMBOL_INDEX) == ' ';

        if (!isOperatorPrecededBySpace) {
            throw new IllegalArgumentException(OPERATOR_MUST_HAVE_PRECEDING_SPACE.getMessage());
        }
    }

    private void isInputContainOperator(String input) {
        String inputContainOperator = input.substring(0, input.length() - LAST_SYMBOL_INDEX);

        if (inputContainOperator.contains(String.valueOf(SYMBOL))) {
            throw new IllegalArgumentException(SEPARATOR_NOT_FOUND.getMessage());
        }
    }

    private void isSymbol() {
        boolean isValidOperator = SYMBOL == '+' || SYMBOL == '-' || SYMBOL == '*' || SYMBOL == '/';

        if (!isValidOperator) {
            throw new IllegalArgumentException(INPUT_EMPTY_OPERATOR.getMessage());
        }
    }

    private void isSymbolLastIndex(String input) {
        if (input.indexOf(SYMBOL) != input.length() - LAST_SYMBOL_INDEX) {
            throw new IllegalArgumentException(OPERATOR_MUST_LAST_INDEX.getMessage());
        }
    }

}