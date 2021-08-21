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
import java.util.List;

/**
 * Author: Denis Lima
 */

@WebServlet(urlPatterns = "/logs")
public class LogController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            ServletContext sc = req.getServletContext();

            List<Log> logs = LogDAO.getInstance().findAll();

            for(Log log: logs) {
                System.out.println(log.getId());
            }

            sc.setAttribute("logs", logs);
            sc.getRequestDispatcher("/jsp/logs.jsp").forward(req, resp);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }
}
