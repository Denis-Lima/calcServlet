package br.com.fatec.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Author: Denis Lima
 */

@WebFilter(urlPatterns = "/*")
public class Filtro implements Filter {

    private final List<String> mappedUrl = Arrays.asList("/logs","/calculadora","/not-found");

    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String uri = req.getRequestURI();

        boolean isStaticResource = uri.contains("resources/");

        System.out.println("filtro chamado -----> " + uri);

        if (!uri.contains("favicon") && !uri.contains("/calc/")) {
            if (mappedUrl.contains(uri) || isStaticResource) {
                chain.doFilter(request, response);
            } else {
                HttpServletResponse res = (HttpServletResponse) response;
                res.sendRedirect("/not-found");
            }
        }
    }

    @Override
    public void destroy() {
    }
}
