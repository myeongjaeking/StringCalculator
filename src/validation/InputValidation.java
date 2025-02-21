package validation;

import static exception.ErrorMessage.*;

public class InputValidation {

    private final int LAST_SYMBOL_INDEX = 1;
    private final int BEFORE_LAST_SYMBOL_INDEX = 2;

    public InputValidation() {
    }

    public void validateInput(String input) {
        validateNullInput(input);
        validateEmptyInput(input);
        char symbol = getOperatorChar(input);
        isSymbolLastIndex(input, symbol);
        isInputContainOperator(input, symbol);
        isSymbol(symbol);
        validateBlank(input);
        validateConsecutiveSeparators(input);
        validateOperatorPrecededBySpace(input);
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

    private void isInputContainOperator(String input, char symbol) {
        String inputContainOperator = input.substring(0, input.length() - LAST_SYMBOL_INDEX);

        if (inputContainOperator.contains(String.valueOf(symbol))) {
            throw new IllegalArgumentException(SEPARATOR_NOT_FOUND.getMessage());
        }
    }

    private void isSymbol(char symbol) {
        boolean isValidOperator = symbol == '+' || symbol == '-' || symbol == '*' || symbol == '/';

        if (!isValidOperator) {
            throw new IllegalArgumentException(INPUT_EMPTY_OPERATOR.getMessage());
        }
    }

    private void isSymbolLastIndex(String input, char symbol) {
        if (input.indexOf(symbol) != input.length() - LAST_SYMBOL_INDEX) {
            throw new IllegalArgumentException(OPERATOR_MUST_LAST_INDEX.getMessage());
        }
    }

}