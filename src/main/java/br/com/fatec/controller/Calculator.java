package br.com.fatec.controller;

import br.com.fatec.model.Classificacao;
import br.com.fatec.model.ClassificacaoDAO;
import br.com.fatec.model.Log;
import br.com.fatec.services.ElementarServices;
import br.com.fatec.services.LogServices;
import br.com.fatec.services.TranscendentalServices;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/calc/*")
public class Calculator extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String path = req.getServletPath();
            ServletContext sc = req.getServletContext();
            System.out.println("controller chamado--- " + path);

            sc.getRequestDispatcher("/jsp/calculator.jsp").forward(req, resp);

//

//
//                    // Inserting new Log
//                    Log novoLog = new Log();
//                    novoLog.setArgumento1(op1);
//                    novoLog.setArgumento2(op2);
//                    novoLog.setOperacao(operacao);
//                    LogDAO.getInstance().persist(novoLog);
//
//                    req.setAttribute("resultado", op1 + op2);
//                    sc.getRequestDispatcher("/jsp/calculator.jsp").forward(req, resp);

        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            ServletContext sc = req.getServletContext();
            req.setCharacterEncoding("UTF-8");

            String operacao = req.getParameter("operacao");
            double op1 = Double.parseDouble(req.getParameter("op1"));
            double op2;
            double resultado;

            switch (operacao) {
                case "soma":
                    op2 = Double.parseDouble(req.getParameter("op2"));
                    resultado = ElementarServices.somar(op1, op2);
                    break;

                case "subtracao":
                    op2 = Double.parseDouble(req.getParameter("op2"));
                    resultado = ElementarServices.subtrair(op1, op2);
                    break;

                case "tangente":
                    resultado = TranscendentalServices.tangenteHiberbolica(op1);
                    LogServices.salvarTranscendental(op1, "Tangente hiberbólica");
                    break;

                default:
                    resultado = 0.0;
                    break;
            }

            resp.setCharacterEncoding("UTF-8");
            PrintWriter out = resp.getWriter();
            out.write(String.valueOf(resultado));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
