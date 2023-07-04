package com.example.cipherSpringAPP.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class AccessFilterUser implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Získanie prihlaseného používateľa alebo jeho role
        ArrayList<String> roles = getRoleFromSession(httpRequest);

        // Kontrola prístupových práv na základe role
        if (roles.contains("USER")) {
            // Ak je používateľ prihlaseny a je user, umožni prístup k servletom
            chain.doFilter(request, response);
        } else {
            // Ak nie je používateľ admin, presmeruj na chybovú stránku alebo inú žiadanú akciu
            httpResponse.sendRedirect("login.jsp");
        }
    }


    private ArrayList<String> getRoleFromSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        System.out.println("Session vo filtri" + session.getId());
        ArrayList<String> roles = (ArrayList<String>) session.getAttribute("role");
        return roles;
    }





}