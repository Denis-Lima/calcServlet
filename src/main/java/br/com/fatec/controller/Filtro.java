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
        ((HttpServletResponse) response).setHeader("Access-Control-Allow-Origin", "*");
        ((HttpServletResponse) response).setHeader("Access-Control-Allow-Methods","GET, OPTIONS, HEAD, PUT, POST");
        ((HttpServletResponse) response).setHeader("Access-Control-Allow-Headers", "*");
        ((HttpServletResponse) response).setHeader("Access-Control-Max-Age", "1728000");
        String contextPath = req.getContextPath();
        String uri = req.getServletPath();

        boolean isStaticResource = uri.contains("resources/");

        if (!uri.contains("favicon") && !uri.contains("/calc/")) {
            if (mappedUrl.contains(uri) || isStaticResource) {
                chain.doFilter(request, response);
            } else {
                HttpServletResponse res = (HttpServletResponse) response;
                res.sendRedirect(contextPath + "/not-found");
            }
        }
    }

    @Override
    public void destroy() {
    }
}
