package com.javatdas.errors;

public class StackIsEmpyError extends Throwable {
    public StackIsEmpyError(String s) {
        System.out.println(s);
    }
}
