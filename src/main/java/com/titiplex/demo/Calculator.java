package com.titiplex.demo;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b == 0) throw new ArithmeticException("Division by zero");
        return a / b;
    }

    public boolean isEven(int n) {
        return n % 2 == 0;
    }
}
