package com.javatdas.tdas;

import com.javatdas.errors.QueueIsEmpyError;

public class Queue {
    int[] queue;
    int topIndex=0;
    int lastIndex=0;
    int capacity;
    int count=0;

    public Queue(int size) {
        queue = new int[size];
        capacity = size;
    }

    public void add(int n) {
        if (count == capacity) {
            System.out.println("Error: La cola esta llena");
        }
        queue[topIndex] = n;
        topIndex = (topIndex+1)%capacity;
        count+=1;
        System.out.println("Top index: " + topIndex);
        System.out.println("Last index: " + lastIndex);
        System.out.println("Count: " + count);
    }

    public int remove() throws QueueIsEmpyError {
        if (isEmpty()) {
            throw new QueueIsEmpyError("Error: La cola esta vacia");
        }
        int element = queue[lastIndex];
        lastIndex = (lastIndex+1)%capacity;
        count-=1;
        System.out.println("Top index: " + topIndex);
        System.out.println("Last index: " + lastIndex);
        System.out.println("Count: " + count);
        return element;
    }

    public boolean isEmpty() {
        return (count==0);
    }

    public int peek() throws QueueIsEmpyError {
        if (isEmpty()) {
            throw new QueueIsEmpyError("Error: La cola esta vacia");
        }
        return queue[lastIndex];
    }
}
