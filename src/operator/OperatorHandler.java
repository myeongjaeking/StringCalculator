package operator;

public class OperatorHandler {

    private final String input;
    private char operator;

    public OperatorHandler(String input) {
        this.input = input;
        this.operator = getOperatorChar();
    }

    private char getOperatorChar() {
        return operator = input.charAt(input.length() - 1);
    }

    public Operation getOperator() {
        return Operation.fromSymbol(operator);
    }

}