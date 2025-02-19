import calculator.Calculator;
import io.Input;
import io.Output;
import operator.Operation;
import operator.OperatorHandler;
import operator.OperatorParser;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Input input = new Input();
        input.setInput();
        String userInput = input.getInput();

        Operation operator = new OperatorHandler(userInput).getOperator();

        String replaceSeparatorToOperator = OperatorParser.replaceSeparatorToOperator(userInput, operator.getSymbol());
        List<Double> numbers = OperatorParser.extractNumbers(userInput, operator.getSymbol());

        double result = Calculator.calculate(numbers, operator);
        Output.getCalculateResult(result, replaceSeparatorToOperator);
    }

}