package operator;

public class MinusOperation implements Operator {

    @Override
    public Double calculate(double a, double b) {
        return a - b;
    }

    @Override
    public String getOperator() {
        return "-";
    }

}