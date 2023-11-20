package com.sespitia.weatherapp.config;

import com.sespitia.weatherapp.controller.filter.AuditFilter;
import com.sespitia.weatherapp.service.AuditService;
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
