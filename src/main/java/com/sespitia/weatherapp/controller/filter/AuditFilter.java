package com.sespitia.weatherapp.controller.filter;

import com.sespitia.weatherapp.service.AuditService;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;

public class AuditFilter implements Filter {

    private final AuditService auditService;

    public AuditFilter(AuditService auditService) {
        this.auditService = auditService;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        filterChain.doFilter(request, responseWrapper);

        byte[] responseArray = responseWrapper.getContentAsByteArray();
        String responseBody = new String(responseArray, responseWrapper.getCharacterEncoding());

        auditService.saveOperationRegister(username, request.getRequestURI(), responseBody);

        responseWrapper.copyBodyToResponse();
    }
}
