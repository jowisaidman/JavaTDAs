package com.javatdas.stack;

import java.util.Arrays;

public class Stack {
    int[] array = {};
    int topIndex = 0;

    public void push(int num) {
        array[topIndex+1] = num;
    }

    public int pop() {
        topIndex -=1;
        return array[topIndex];
    }

    public int seeTop() {
        return array[topIndex];
    }

    public boolean isEmpty() {
        return array.length>=1;
    }

    public void show() {
        System.out.println(Arrays.toString(array));
    }
}
