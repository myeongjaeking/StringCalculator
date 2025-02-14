package operator;

import java.util.List;

public interface Operator {

    String replaceSeparatorToOperator(String input);

    List<Double> extractNumbers(String input);

    Double calculate(double a, double b);

}
