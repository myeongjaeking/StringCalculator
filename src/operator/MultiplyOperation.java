package operator;

public class MultiplyOperation implements Operator {

    @Override
    public Double calculate(double a, double b) {
        return a * b;
    }

    @Override
    public String getOperator() {
        return "*";
    }

}