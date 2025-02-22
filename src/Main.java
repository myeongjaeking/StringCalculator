import calculator.Calculator;
import io.Input;
import io.Output;
import operator.Operation;
import operator.OperatorParser;

import java.util.List;

import static validation.InputValidation.SYMBOL;

public class Main {

    public static void main(String[] args) {
        Input input = new Input();
        input.typeInput();
        String userInput = input.getInput();

        Operation operator = Operation.fromSymbol(SYMBOL);

        String replacedSeparatorToOperator = OperatorParser.replaceSeparatorToOperator(userInput, operator.getSymbol());
        List<Double> operands = OperatorParser.extractNumbers(userInput, operator.getSymbol());

        double result = Calculator.calculate(operands, operator);

        Output.getCalculateResult(result, replacedSeparatorToOperator);
    }

}