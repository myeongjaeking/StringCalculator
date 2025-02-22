package io;

import java.util.Scanner;

import validation.InputValidation;

public class Input {

    private String input;
    private final InputValidation inputValidation = new InputValidation();
    private final Scanner scanner = new Scanner(System.in);

    public Input() {
    }

    public void typeInput() {
        this.input = scanner.nextLine();
        inputValidation.validateInput(input);
    }

    public String getInput() {
        return input;
    }

}