package io;

import java.util.Scanner;

import validation.InputValidation;

public class Input {

    private String input;
    private final InputValidation inputValidation;
    private final Scanner scanner = new Scanner(System.in);

    public Input(InputValidation inputValidation) {
        this.inputValidation = inputValidation;
    }

    public void typeInput() {
        this.input = scanner.nextLine();
        inputValidation.validateInput(input);
    }

    public String getInput() {
        return input;
    }

}