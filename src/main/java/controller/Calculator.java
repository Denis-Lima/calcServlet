package controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet({"*.action", "/teste"})
public class Calculator extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String path = req.getServletPath();
            ServletContext sc = req.getServletContext();
            System.out.println(path);
            System.out.println(path.length());

            switch (path) {
                case "/teste":
                    System.out.println("get in /teste");
                    sc.getRequestDispatcher("/jsp/calculator.jsp").forward(req, resp);
                    break;
                case "/teste/escrevernome.action":
                    req.setCharacterEncoding("UTF-8");
                    String nome = req.getParameter("nome_completo");
                    nome = nome.toUpperCase();
                    resp.setContentType("text/html");
                    resp.setCharacterEncoding("UTF-8");
                    req.setAttribute("nomeCompleto", nome);
                    sc.getRequestDispatcher("/jsp/resposta.jsp").forward(req, resp);
                    break;
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
