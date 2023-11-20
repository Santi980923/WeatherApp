package com.sespitia.weatherapp.config;

import com.sespitia.weatherapp.controller.filter.RateLimitFilter;
import com.sespitia.weatherapp.service.LimitService;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RateLimitConfig {

    @Bean
    public FilterRegistrationBean<RateLimitFilter> rateLimitFilter(LimitService limitService){
        FilterRegistrationBean<RateLimitFilter> bean = new FilterRegistrationBean<>();

        bean.setFilter(new RateLimitFilter(limitService));
        bean.addUrlPatterns("/weather/*");

        return bean;
    }
}
