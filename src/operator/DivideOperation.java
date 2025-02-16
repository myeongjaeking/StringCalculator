package operator;

import static exception.ErrorMessage.*;

public class DivideOperation implements Operator {

    @Override
    public Double calculate(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException(CANNOT_DIVIDE_BY_ZERO.getMessage());
        }
        return a / b;
    }

    @Override
    public String getOperator() {
        return "/";
    }

}