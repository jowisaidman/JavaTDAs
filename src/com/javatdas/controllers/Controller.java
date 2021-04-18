package com.javatdas.controllers;

public interface Controller {
    //Con esta clase solo llamo a controller de main menu y solo tengo
    //que agregar mas opciones para agregar luego nuevos TDAs.
    public void invokeMenuTda();
    public void callAction(String option);
    public void showMenu();
    public String readInput();
}
