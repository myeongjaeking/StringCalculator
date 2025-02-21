package operator;

import java.util.Arrays;
import java.util.function.DoubleBinaryOperator;

import static exception.ErrorMessage.CANNOT_DIVIDE_BY_ZERO;
import static exception.ErrorMessage.INPUT_EMPTY_OPERATOR;

public enum Operation {

    PLUS("+", Double::sum),
    MINUS("-", (x, y) -> x - y),
    MULTIPLY("*", (x, y) -> x * y),
    DIVIDE("/", Operation::divide);

    private final DoubleBinaryOperator op;
    private final String symbol;

    Operation(String symbol, DoubleBinaryOperator op) {
        this.symbol = symbol;
        this.op = op;
    }

    public String getSymbol() {
        return symbol;
    }

    private static double divide(double x, double y) {
        if (y == 0) {
            throw new ArithmeticException(CANNOT_DIVIDE_BY_ZERO.getMessage());
        }
        return x / y;
    }

    public double calculate(double accumulator, double operand) {
        return op.applyAsDouble(accumulator, operand);
    }

    public static Operation fromSymbol(char symbol) {
        return Arrays.stream(Operation.values())
                .filter(op -> op.symbol.equals(String.valueOf(symbol)))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INPUT_EMPTY_OPERATOR.getMessage()));
    }

}