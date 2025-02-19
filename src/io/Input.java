package io;

import java.util.Scanner;

import validation.InputValidation;

public class Input {

    private String input;
    private final Scanner scanner = new Scanner(System.in);

    public Input() {
    }

    public void setInput() {
        this.input = scanner.nextLine();
        InputValidation.validateInput(input);
    }

    public String getInput() {
        return input;
    }

}