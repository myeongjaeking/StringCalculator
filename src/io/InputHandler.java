package io;

import java.util.Scanner;

import validation.InputValidation;

public class InputHandler {

    private String input;
    InputValidation inputValidation;

    public InputHandler() {
        this.input = (new Scanner(System.in)).nextLine();
        this.inputValidation = new InputValidation(input);
    }

    public String getInput() {
        return input;
    }

}