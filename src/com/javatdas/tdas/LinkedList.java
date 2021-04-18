package com.javatdas.tdas;

import com.javatdas.errors.LinnkedListIsEmpyError;

public class LinkedList {
    private class Node {
        Node next;
        int data;

        Node (int n) {
            data = n;
        }
    }

    Node first;
    public void insert(int i) {
        if (first==null) {
            first = new Node(i);
        } else {
            Node new_first = new Node(i);
            first.next = new_first;
            first = new_first;
        }
    }

    public int deleteFirst(int i) throws LinnkedListIsEmpyError {
        if (first==null) {
            throw new LinnkedListIsEmpyError("Error: La lista esta vacia");
        }
        int data = first.data;
        first = first.next;
        return data;
    }
}
