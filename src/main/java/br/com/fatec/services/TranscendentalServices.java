package br.com.fatec.services;

/**
 * Author: Denis Lima
 */

public class TranscendentalServices {
    public static double tangenteHiberbolica (double op1) {
        LogServices.salvarTranscendental(op1, "Tangente hiberbólica");
        return Math.tanh(op1);
    }
}
