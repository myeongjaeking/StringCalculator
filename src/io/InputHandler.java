package io;

import java.util.Scanner;

import validation.InputValidation;

public class InputHandler {

    private final String input;

    public InputHandler() {
        this.input = (new Scanner(System.in)).nextLine();
        InputValidation.validateInput(input);
    }

    public String getInput() {
        return input;
    }

}