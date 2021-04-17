package com.javatdas.main;
//import com.javatdas.stack.Stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        String option = null;
        welcome();
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        try {
            option = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (option !=null && !(option.equals("6"))) {
            // BufferReader para leer la entrada

            showMainMenu();

            try {
                option = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            //Aca llamo al tda correspondiente

        }
    }

    public static void welcome() {
        System.out.println("Bienvenido a JavaTDAs, con este software podra pobrar distitas estructuras " +
                "de datos hechas en Java");
        showMainMenu();
    }

    public static void showMainMenu() {
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
}
