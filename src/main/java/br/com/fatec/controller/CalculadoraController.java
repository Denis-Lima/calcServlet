package br.com.fatec.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/calculadora")
public class CalculadoraController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String path = req.getServletPath();
            ServletContext sc = req.getServletContext();
            System.out.println("controller chamado--- " + path);

            sc.getRequestDispatcher("/jsp/calculator.jsp").forward(req, resp);

        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }
}
