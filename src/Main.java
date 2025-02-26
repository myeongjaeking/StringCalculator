import calculator.Calculator;
import io.Input;
import io.Output;
import operator.Operation;
import operator.OperatorParser;
import validation.InputValidation;

import java.util.List;

import static validation.InputValidation.SYMBOL;

public class Main {

    public static void main(String[] args) {
        InputValidation inputValidation = new InputValidation();

        Input input = new Input(inputValidation);
        input.typeInput();
        String userInput = input.getInput();

        Operation operator = Operation.fromSymbol(SYMBOL);

        OperatorParser operatorParser = new OperatorParser(userInput, operator.getSymbol());
        String replacedSeparatorToOperator = operatorParser.replaceSeparatorToOperator();
        List<Double> operands = operatorParser.extractNumbers();

        double result = Calculator.calculate(operands, operator);

        Output.getCalculateResult(result, replacedSeparatorToOperator);
    }

}