package br.com.fatec.services;

import br.com.fatec.model.Classificacao;
import br.com.fatec.model.ClassificacaoDAO;
import br.com.fatec.model.Log;
import br.com.fatec.model.LogDAO;

/**
 * Author: Denis Lima
 */

public class LogServices {
    public static void salvarElementar (double op1, double op2, String operacao) {
        Log registro = new Log();
        registro.setArgumento1(op1);
        registro.setArgumento2(op2);
        registro.setOperacao(operacao);
        Classificacao tipo = ClassificacaoDAO.getInstance().find(1);
        registro.setTipoOperacao(tipo);

        LogDAO.getInstance().persist(registro);
    }

    public static void salvarTranscendental (double op1, String operacao) {
        Log registro = new Log();
        registro.setArgumento1(op1);
        registro.setOperacao(operacao);
        Classificacao tipo = ClassificacaoDAO.getInstance().find(2);
        registro.setTipoOperacao(tipo);

        LogDAO.getInstance().persist(registro);
    }
}
