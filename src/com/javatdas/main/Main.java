package com.javatdas.main;
//import com.javatdas.tdas.Stack;
import com.javatdas.controllers.Controller;
import com.javatdas.controllers.QueueController;
import com.javatdas.controllers.StackController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        welcome();

        String option = readInput();

        HashMap<String, Controller> controllers = getControllers();

        while (option !=null && !(option.equals("6"))) {
            Controller controller = controllers.get(option);
            if (controller != null) {
                controller.invokeMenuTda();
            } else {
                System.out.println("Selecciono una opcion invalida!");
            }

            showMainMenu();
            option = readInput();
        }
        System.out.println("Muchas gracias por usar este Software");
    }

    private static void welcome() {
        System.out.println("Bienvenido a JavaTDAs, con este software podra pobrar distitas estructuras " +
                "de datos hechas en Java");
        showMainMenu();
    }

    private static void showMainMenu() {
        System.out.println(
                """
                        Por favor seleccione una opcion:
                        [1] Stack
                        [2] Queue
                        [3] Linked List
                        [4] Binary Tree
                        [5] Graph
                        [6] Quit\s
                        Su opcion:\s"""
        );
    }

    private static HashMap<String, Controller> getControllers() {//Ejemplo de como evitar ifs.
        HashMap<String, Controller> controllers = new HashMap<>();
        StackController stackController = new StackController();
        controllers.put("1",stackController);
        QueueController queueController = new QueueController();
        controllers.put("2",queueController);
        return controllers;
    }

    public static String readInput() {
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
