import io.InputHandler;
import operator.Operator;
import operator.OperatorHandler;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        String input = inputHandler.getInput();

        Operator operator = new OperatorHandler(input).getOperator();
        String replaceSeparatorToOperator = operator.replaceSeparatorToOperator(input);
        List<Double> numbers = operator.extractStringToDouble(input);

    }

}