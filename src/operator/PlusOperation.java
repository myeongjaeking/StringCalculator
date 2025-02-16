package operator;

public class PlusOperation implements Operator {

    @Override
    public Double calculate(double a, double b) {
        return a + b;
    }

    @Override
    public String getOperatorSymbol() {
        return "+";
    }

}