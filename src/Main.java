import calculator.Calculate;
import io.InputHandler;
import io.Output;
import operator.Operator;
import operator.OperatorHandler;
import operator.OperatorParser;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        String input = inputHandler.getInput();

        Operator operator = new OperatorHandler(input).getOperator();

        String replaceSeparatorToOperator = OperatorParser.replaceSeparatorToOperator(input,operator.getOperator());
        List<Double> numbers = OperatorParser.extractNumbers(input,operator.getOperator());

        double result = Calculate.getResult(numbers,operator);
        Output.getCalculateResult(result,replaceSeparatorToOperator);
    }

}