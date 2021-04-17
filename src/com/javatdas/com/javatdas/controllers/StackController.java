package com.javatdas.com.javatdas.controllers;

import com.javatdas.tdas.Stack;
import com.javatdas.tdas.StackIsEmpyError;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StackController implements Controller {

    @Override
    public void invokeMenuTda() {
        System.out.println("Usted seleciono la opcion [1] Stack.");
        showMenu();
        String option = readInput();

        while (option !=null && !(option.equals("4"))) {
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
        } else {
            System.out.println("Selecciono una opcion invalida!");
        }
    }

    @Override
    public void showMenu() {
        System.out.println(
                """
                        Seleccione una de las siguientes opciones:
                        [1] Crear Stack y operar.
                        [2] Ver complidad y documentacion de las primitivas.
                        [3] Abrir menu de ejercicios.
                        [4] Volver a menu principal.
                        """
        );
    }

    private void operationWithStack() {
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
                    } catch (StackIsEmpyError e) {

                    }
                }
                case "3" -> System.out.println("El tope de la pila es: " + stack.peek());
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
}
