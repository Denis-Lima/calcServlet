package br.com.fatec.controller;

import br.com.fatec.model.Log;
import br.com.fatec.model.LogDAO;
import br.com.fatec.model.LogServices;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Author: Denis Lima
 */

@WebServlet(urlPatterns = "/logs")
public class LogController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        List<Log> logs = null;

        try {
            logs = LogDAO.getInstance().findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            ServletContext sc = req.getServletContext();
            sc.setAttribute("logs", logs);
            sc.getRequestDispatcher("/jsp/logs.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            resp.setCharacterEncoding("UTF-8");

            String tipo = req.getParameter("tipo");
            double op1 = Double.parseDouble(req.getParameter("op1"));
            double resultado = Double.parseDouble(req.getParameter("resultado"));
            String operacao = req.getParameter("operacao");

            PrintWriter out = resp.getWriter();

            switch (tipo) {
                case "transcendental":
                    LogServices.salvarTranscendental(op1, operacao, resultado);
                    break;

                case "elementar":
                    double op2 = Double.parseDouble(req.getParameter("op2"));
                    LogServices.salvarElementar(op1, op2, operacao, resultado);
                    break;

                default:
                    out.write("Tipo de operação inválido!");
                    return;
            }

            out.write("Log salvo com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            String message = e.getMessage();
            if (message.contains("For input string")) {
                message = "Só é permitido números nos operadores e resultado!";
            }
            resp.getWriter().write(message);
        }
    }
}
