package com.rqm.springclouddomain1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * @author renqiuming
 * @date 2020/2/3 下午12:03
 */
@Configuration
public class UrlFilterConfig {

    @Autowired
    private UrlFilter urlFilter;

    @Bean
    public FilterRegistrationBean registerUrlFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(urlFilter);
        registration.addUrlPatterns("/*");
        registration.setName("urlFilter");
        //值越小，Filter越靠前。
        registration.setOrder(1);
        return registration;
    }
}
