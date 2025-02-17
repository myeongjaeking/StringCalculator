package io;

public class Output {

    private Output() {
    }

    public static void getCalculateResult(Double result, String replacedInput) {
        System.out.println(replacedInput + "= " + String.format("%.1f", result));
    }

}