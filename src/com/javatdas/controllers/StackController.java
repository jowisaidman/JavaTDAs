package com.javatdas.controllers;

import com.javatdas.tdas.Stack;
import com.javatdas.errors.StackIsEmpyError;
import com.javatdas.tests.StackTests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StackController implements Controller {

    @Override
    public void invokeMenuTda() {
        System.out.println("Usted seleciono la opcion [1] Stack.");
        showMenu();
        String option = readInput();

        while (option !=null && !(option.equals("5"))) {
            callAction(option);

            showMenu();
            option = readInput();
        }
        System.out.println("Esta saliendo del menu Stack, volver al menu principal.");
    }

    @Override
    public void callAction(String option) {
        if (option.equals("1")) {
            operationWithStack();
        }
        else if (option.equals("2")) {
            showPrimitiveDocumetation();
        } else if (option.equals("3")) {
            showExcercises();
        } else if (option.equals("4")) {
            callTestRunner();
        } else {
            System.out.println("Selecciono una opcion invalida!");
        }
    }

    @Override
    public void showMenu() {
        System.out.println(
                """
                        Seleccione una de las siguientes opciones:
                        [1] Crear pila y operar.
                        [2] Ver complidad y documentacion de las primitivas.
                        [3] Abrir menu de ejercicios.
                        [4] Correr pruebas con tiempos de la pila.
                        [5] Volver a menu principal.
                        """
        );
    }

    private void operationWithStack() {
        //Posible refactor capa intermedia para esto.
        Stack stack = new Stack(100);
        showStackOperationMenu();
        String option = readInput();

        while (option !=null && !(option.equals("6"))) {
            switch (option) {
                case "1" -> {
                    System.out.println("Ingrese numero para apilar: ");
                    option = readInput(); //Aca deberia validar que entra un numero.
                    stack.push(Integer.parseInt(option));
                }
                case "2" -> {
                    try {
                        System.out.println("Se desapilo un: " + stack.pop());
                    } catch (StackIsEmpyError e) {} //Pensar si deberia hacer algo aca
                }
                case "3" -> {
                    try {
                        System.out.println("El tope de la pila es: " + stack.peek());;
                    } catch (StackIsEmpyError e) {} //Pensar si deberia hacer algo aca
                }
                case "4" -> System.out.println("La pila esta vacia: " + stack.isEmpty());
                case "5" -> stack.show();
            }
            showStackOperationMenu();
            option = readInput();
        }

    }

    public void showStackOperationMenu() {
        System.out.println(
                """
                        Elija una opcion:
                        [1] put
                        [2] pop
                        [3] peek
                        [4] isEmpty
                        [5] SeeStack
                        [6] Volver a menu de Stack
                        """
        );
    }

    @Override
    public String readInput() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        String option = null;
        try {
            option = reader.readLine();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return option;
    }

    public void showPrimitiveDocumetation() {
        System.out.println(
                """
                       [1] put: 
                       Metodo: Toma como parametro un nuevo elemento y lo agrega al tope de la pila, no devuelve nada.
                       Complejidad: O(1)
                       
                       [2] pop:
                       Metodo: Remueve el tope de la pila y lo devuelve.
                       Complejidad: O(1)
                       
                       [3] peek:
                       Metodo: Devuelve el tope de la pila, no modifica la misma.
                       Complejidad: O(1)
                       
                       [4] isEmpty
                       Metodo: Devuelve un booleano indicando si la pila esta o no vacia, no modifica la misma.
                       Complejidad: O(1)
                       
                       [5] SeeStack
                       Metodo: Imprime toda la pila en pantalla, no es una primitiva del tda pila original.
                       Complejidad: O(n)
                """
        );
    }

    public void showExcercises() {
        System.out.println("Seccion de ejercicios en construccion");
    }

    public void callTestRunner() {
        StackTests tests = new StackTests(); //La idea es que aca uno pueda ver los tiempos del stack
        tests.runTests();
    }
}
