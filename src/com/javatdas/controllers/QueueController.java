package com.javatdas.controllers;

import com.javatdas.errors.QueueIsEmpyError;
import com.javatdas.tdas.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QueueController implements Controller {
    @Override
    public void invokeMenuTda() {
        System.out.println("Usted seleciono la opcion [2] Queue.");
        showMenu();
        String option = readInput();

        while (option !=null && !(option.equals("5"))) {
            callAction(option);

            showMenu();
            option = readInput();
        }
        System.out.println("Esta saliendo del menu Queue, volver al menu principal.");
    }

    @Override
    public void callAction(String option) {
        switch (option) {
            case "1" -> operationWithQueue();
            case "2" -> System.out.println("TODO doc");
            case "3" -> System.out.println("TODO ejs");
            case "4" -> System.out.println("TODO tests");
            default -> System.out.println("Selecciono una opcion invalida!");
        }
    }

    @Override //si uso clase abstracta podria implementarlo ahi
    public void showMenu() {
        System.out.println(
                """
                        Seleccione una de las siguientes opciones:
                        [1] Crear cola y operar.
                        [2] Ver complidad y documentacion de las primitivas.
                        [3] Abrir menu de ejercicios.
                        [4] Correr pruebas con tiempos de la pila.
                        [5] Volver a menu principal."""
        );
    }

    private void operationWithQueue() {
        Queue queue = new Queue(100);
        showQueueOperationMenu();
        String option = readInput();

        while (option !=null && !(option.equals("5"))) {
            switch (option) {
                case "1" -> {
                    System.out.println("Ingrese numero para encolar: ");
                    option = readInput(); //Aca deberia validar que entra un numero.
                    queue.add(Integer.parseInt(option));
                }
                case "2" -> {
                    try {
                        System.out.println("Se desencolo un: " + queue.remove());
                    } catch (QueueIsEmpyError e) {System.out.println("Error salvado");}
                }
                case "3" -> {
                    try {
                        System.out.println("El tope de la cola es: " + queue.peek());
                    } catch (QueueIsEmpyError e) {System.out.println("Error salvado");} //Pensar si deberia hacer algo aca
                }
                case "4" -> System.out.println("La cola esta vacia: " + queue.isEmpty());
            }
            showQueueOperationMenu();
            option = readInput();
        }

    }

    public void showQueueOperationMenu() {//si uso clase abstracta podria implementarlo ahi
        System.out.println(
                """
                        Elija una opcion:
                        [1] add
                        [2] remove
                        [3] peek
                        [4] isEmpty
                        [5] Volver a menu de Queue
                        """
        );
    }

    @Override
    public String readInput() {//si uso clase abstracta podria implementarlo ahi
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
