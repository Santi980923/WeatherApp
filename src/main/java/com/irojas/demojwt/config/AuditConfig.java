package com.irojas.demojwt.config;

import com.irojas.demojwt.controller.filter.AuditFilter;
import com.irojas.demojwt.service.AuditService;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuditConfig {

    @Bean
    public FilterRegistrationBean<AuditFilter> auditFilter(AuditService auditService){
        FilterRegistrationBean<AuditFilter> bean = new FilterRegistrationBean<>();

        bean.setFilter(new AuditFilter(auditService));
        bean.addUrlPatterns("/weather/*");

        return bean;
    }
}
