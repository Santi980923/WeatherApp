package com.sespitia.weatherapp.controller.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sespitia.weatherapp.service.LimitService;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;


@Order(2)
public class RateLimitFilter implements Filter {

    private final LimitService rateLimitService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public RateLimitFilter(LimitService rateLimitService) {
        this.rateLimitService = rateLimitService;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        // Extract username from the authentication context
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        // Check rate limit before processing the request
        if (!rateLimitService.tryConsume(username)) {
            ResponseEntity<String> rateLimitResponse = ResponseEntity
                    .status(HttpStatus.TOO_MANY_REQUESTS)
                    .body("Se ha excedido el límite de solicitudes. Por favor, intentelo de nuevo mas tarde.");

            response.setStatus(rateLimitResponse.getStatusCode().value());
            response.getWriter().write(objectMapper.writeValueAsString(rateLimitResponse.getBody()));
            return;
        }

        // Continue with the filter chain
        filterChain.doFilter(request, response);
    }
}
