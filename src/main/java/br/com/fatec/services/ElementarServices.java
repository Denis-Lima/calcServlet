package br.com.fatec.services;

/**
 * Author: Denis Lima
 */

public class ElementarServices {
    public static double somar(double op1, double op2) {
        LogServices.salvarElementar(op1, op2, "Adição");
        return op1 + op2;
    }

    public static double subtrair(double op1, double op2) {
        LogServices.salvarElementar(op1, op2, "Subtração");
        return op1 - op2;
    }
}
