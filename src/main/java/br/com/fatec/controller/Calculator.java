package br.com.fatec.controller;

import br.com.fatec.model.Log;
import br.com.fatec.model.LogDAO;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet({"*.action", "/teste", "/index.html"})
public class Calculator extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String path = req.getServletPath();
            ServletContext sc = req.getServletContext();
            System.out.println(path);
            switch (path) {
                case "/teste":
                    sc.getRequestDispatcher("/jsp/calculator.jsp").forward(req, resp);
                    break;
                case "/calcular.action":
                    req.setCharacterEncoding("UTF-8");
                    double op1 = Double.parseDouble(req.getParameter("op1"));
                    double op2 = Double.parseDouble(req.getParameter("op2"));
                    String operacao = req.getParameter("operacao");
                    System.out.println(op1 + " " + op2 + " " + operacao);
                    resp.setContentType("text/html");
                    resp.setCharacterEncoding("UTF-8");

                    // Inserting new Log
                    Log novoLog = new Log();
                    novoLog.setArgumento1(op1);
                    novoLog.setArgumento2(op2);
                    novoLog.setOperacao(operacao);
                    LogDAO.getInstance().persist(novoLog);

                    req.setAttribute("resultado", op1 + op2);
                    sc.getRequestDispatcher("/jsp/calculator.jsp").forward(req, resp);
                    break;
                case "/index.html":
                    sc.getRequestDispatcher("/jsp/calculator.jsp").forward(req, resp);
                default:
                    sc.getRequestDispatcher("/jsp/not_found.jsp").forward(req, resp);
                    break;
            }
            PrintWriter pw = resp.getWriter();
            pw.write("Testado!");
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }
}
