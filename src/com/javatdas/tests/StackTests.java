package com.javatdas.tests;

import com.javatdas.errors.StackIsEmpyError;
import com.javatdas.tdas.Stack;

import java.util.EmptyStackException;

public class StackTests {
    public void runTests() {
        System.out.println("""
            #########################################
            ######### Comienzan Test de Pila ########
            #########################################
            """
        );
        functionalTests();
        //Corriendo tests de funcionamiento
        //Creo pila, chequeo su tipo (que no sea null)
        //Chequeo que pila recien creada este vacia
        //Apilo y chequeo tope
        //Desapilo veo lo que me devolvio
        //Checkeo que este vacia luego de desapilar
        //hacer algunos casos con mas elementos de chequear tope

        //Correr tests de volumen
        //simil a tiempo
        measureTimeTests();
        System.out.println("""
            #########################################
            ######### Finalizan Test de Pila ########
            #########################################
            """
        );
    }

    public void functionalTests() {
        System.out.println("Stage 1 - Test de funcionamietno");
        System.out.println("Se crea una pila de tam 50");
        Stack stack = new Stack(50);
        assert (stack.isEmpty());
        System.out.println("Test 1 - Una pila recien creada esta vacia ... OK");
        stack.push(5);
        assert (!stack.isEmpty());
        System.out.println("Test 2 - Se inserta un 5 y la pila ya no esta vacia ... OK");
        try {
            int top = stack.peek();
            assert (top == 5);
            System.out.println("Test 3 - El tope de la pila es 5 ... OK");
        } catch (StackIsEmpyError e) {
            System.out.println("Error: Test 3 - La pila esta vacia y no deberia");
        }
        System.out.println("Se deberian hacer resto de tests comentados...");
        System.out.println("############### Finalizan test de funcionamieto ###############");
    }

    public void measureTimeTests() {
        System.out.println("Stage 2 - Test de tiempo");
        System.out.println("Test 1 - Tiempo para apilar 100 elementos: " + getTimeToPushNElements(100) + " nanosegundos");
        System.out.println("Test 2 - Tiempo para apilar 1000 elementos: " + getTimeToPushNElements(1000) + " nanosegundos");
        System.out.println("Test 3 - Tiempo para apilar 10000 elementos: " + getTimeToPushNElements(10000) + " nanosegundos");
        System.out.println("Test 4 - Tiempo para apilar 100000 elementos: " + getTimeToPushNElements(100000) + " nanosegundos");
        System.out.println("Test 5 - Tiempo para apilar 1000000 elementos: " + getTimeToPushNElements(1000000) + " nanosegundos");
        System.out.println("Test 6 - Tiempo para apilar 10000000 elementos: " + getTimeToPushNElements(10000000) + " nanosegundos");
        System.out.println("Test 7 - Tiempo para apilar 100000000 elementos: " + getTimeToPushNElements(100000000) + " nanosegundos");
        System.out.println("Falta chequeo por rango lineal...");
        System.out.println("############### Finalizan test de tiempo ###############");
    }

    public long getTimeToPushNElements(int n) {
        long start = System.nanoTime();
        Stack stack = new Stack(n);
        for (int i=0; i<n;i++) {
            stack.push(i);
        }
        long finish = System.nanoTime();
        long timeElapsed = finish - start;
        return timeElapsed;
    }
}
