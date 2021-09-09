package br.com.fatec.model;

/**
 * Author: Denis Lima
 */

public class LogServices {
    public static void salvarElementar (double op1, double op2, String operacao, double resultado) throws Exception {
        String simbolo;

        switch (operacao) {
            case "soma":
                simbolo = "+";
                break;
            case "subtracao":
                simbolo = "-";
                break;
            case "multiplicacao":
                simbolo = "*";
                break;
            case "divisao":
                simbolo = "/";
                break;
            default:
                throw new Exception("Operação inválida! ");
        }

        String args = op1 + " " + simbolo + " " + op2 + " = " + resultado;

        Log registro = new Log();
        registro.setOperacao(operacao);
        registro.setArgs(args);
        Classificacao tipo = ClassificacaoDAO.getInstance().find(1);
        registro.setTipoOperacao(tipo);

        LogDAO.getInstance().persist(registro);
    }

    public static void salvarTranscendental (double op1, String operacao, double resultado) {
        String args = operacao + "(" + op1 + ") = " + resultado;

        Log registro = new Log();
        registro.setArgs(args);
        registro.setOperacao(operacao);
        Classificacao tipo = ClassificacaoDAO.getInstance().find(2);
        registro.setTipoOperacao(tipo);

        LogDAO.getInstance().persist(registro);
    }
}
