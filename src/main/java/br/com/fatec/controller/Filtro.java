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
public class Filtro  implements Filter {

    private List<String> mappedUrl = Arrays.asList("/logs","/calc");

    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest req = (HttpServletRequest) request;
        final String uri = req.getRequestURI();
        boolean isStaticResource = uri.contains("resources/css") || uri.contains("resources/js");

        System.out.println("filtro chamado -----> " + uri);
        //System.out.println("static? -----> " + isStaticResource);

        if (!uri.contains("favicon")) {
            if (mappedUrl.contains(uri) || isStaticResource) {
                chain.doFilter(request, response);
            } else {
                HttpServletResponse res = (HttpServletResponse) response;
                res.sendRedirect(req.getContextPath() + "/not-found");
            }
        }
    }

    @Override
    public void destroy() {
    }
}
