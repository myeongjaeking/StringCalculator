package operator;

import validation.OperatorValidation;

import static exception.ErrorMessage.INPUT_EMPTY_OPERATOR;

public class OperatorHandler {

    private final String input;
    private char operator;

    public OperatorHandler(String input) {
        this.input = input;
        this.operator = getOperatorChar();
        OperatorValidation.validateOperator(input, operator);
    }

    private char getOperatorChar() {
        return operator = input.charAt(input.length() - 1);
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