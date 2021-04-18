package com.javatdas.tdas;

import com.javatdas.errors.StackIsEmpyError;

import java.util.Arrays;

public class Stack {
    int[] array; //declaro e instancio;  initialization recien cuando hago a[0]=10;
    int topIndex = -1;

    public Stack(int size) {
        array = new int[size];
    }

    public void push(int num) {
        if (topIndex==99) {
            System.out.println("Error: La pila esta llena");
        } //esto puedo cambiarlo usando un ArrayList (ver archivo javaTutorial con pros y cons)
        array[topIndex+1] = num;
        topIndex+=1;
    }

    public int pop() throws StackIsEmpyError {
        if (isEmpty()) {
            throw new StackIsEmpyError("Error: La pila esta vacia");
        }
        int topNum = array[topIndex];
        topIndex -=1;
        return topNum;
    }

    public int peek() throws StackIsEmpyError {
        if (isEmpty()) {
            throw new StackIsEmpyError("Error: La pila esta vacia");
        }
        return array[topIndex];
    }

    public boolean isEmpty() {
        return topIndex<0;
    }

    public void show() {
        System.out.println("La pila es: " + Arrays.toString(array));
    }
}
