package com.application.servicebookingsystem.configs;

import org.springframework.stereotype.Component;

import jakarta.servlet.FilterConfig;

import jakarta.servlet.FilterChain;
import jakarta.servlet.Filter;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SimpleCORSFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization logic if needed
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;

        // Allow all origins or specify your frontend domain like "http://localhost:4200"
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));

        // Allow methods such as POST, GET, PUT, DELETE
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS");

        // Allow any headers that the client sends
        response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, X-Requested-With, Accept, Origin");

        // Expose headers like Authorization
        response.setHeader("Access-Control-Expose-Headers", "Authorization");

        // Set how long the results of a preflight request can be cached in seconds
        response.setHeader("Access-Control-Max-Age", "3600");

        // If it's an OPTIONS request (preflight), respond with status 200 OK and skip the chain
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            chain.doFilter(req, res); // Continue with the rest of the filter chain for other requests
        }
    }

    @Override
    public void destroy() {
        // Cleanup logic if needed
    }
}
