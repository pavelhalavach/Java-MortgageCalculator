package com.pavel;

import java.util.Scanner;

public class SetCreditParams {
    private int min;
    private int max;
    private String prompt;
    private Scanner scanner = new Scanner(System.in);

    public SetCreditParams(String prompt, int min, int max){
        setMin(min);
        setMax(max);
        setPrompt(prompt);
    }

    public double returnParam() {
        double value;
        while (true) {
            System.out.print(this.prompt);
            value = scanner.nextDouble();
            if (value >= this.min && value <= this.max)
                break;
            System.out.println("Enter a value between " + (int) min + " and " + (int) max);
        }
        return value;
    }

    private void setMin(int min) {
        this.min = min;
    }

    private void setMax(int max) {
        this.max = max;
    }

    private void setPrompt(String prompt) {
        this.prompt = prompt;
    }
}
