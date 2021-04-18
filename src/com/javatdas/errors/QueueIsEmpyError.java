package com.javatdas.errors;

public class QueueIsEmpyError extends Throwable {
    public QueueIsEmpyError(String s) {
        System.out.println(s);
    }
}
