package operator;

import static exception.ErrorMessage.INPUT_EMPTY_OPERATOR;
import static exception.ErrorMessage.SEPARATOR_NOT_FOUND;

public class OperatorHandler {

    private final String input;
    private char operator;

    public OperatorHandler(String input) {
        this.input = input;
        getOperatorChar();
        validateOperator();
    }

    private void isOperator() {
        boolean isValidOperator = operator == '+' || operator == '-' || operator == '*' || operator == '/';

        if (!isValidOperator) {
            throw new IllegalArgumentException(INPUT_EMPTY_OPERATOR.getMessage());
        }
    }

    private void isInputContainOperator() {
        String inputContainOperator = input.substring(0, input.length() - 1);

        if (inputContainOperator.contains(String.valueOf(operator))) {
            throw new IllegalArgumentException(SEPARATOR_NOT_FOUND.getMessage());
        }
    }

    private void validateOperator() {
        isInputContainOperator();
        isOperator();
    }

    private void getOperatorChar() {
        operator = input.charAt(input.length() - 1);
    }

    public Operator getOperator() {
        return switch (operator) {
            case '+' -> new PlusOperation();
            case '-' -> new MinusOperation();
            case '*' -> new MultiplyOperation();
            case '/' -> new DivideOperation();
            default -> throw new IllegalArgumentException(INPUT_EMPTY_OPERATOR.getMessage());
        };
    }

}