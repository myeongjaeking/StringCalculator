import calculator.Calculator;
import io.Input;
import io.Output;
import operator.Operation;
import operator.OperatorHandler;
import operator.OperatorParser;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Input inputHandler = new Input();
        String input = inputHandler.getInput();

        Operation operator = new OperatorHandler(input).getOperator();

        String replaceSeparatorToOperator = OperatorParser.replaceSeparatorToOperator(input, operator.getSymbol());
        List<Double> numbers = OperatorParser.extractNumbers(input, operator.getSymbol());

        double result = Calculator.calculate(numbers, operator);
        Output.getCalculateResult(result, replaceSeparatorToOperator);
    }

}