package com.rqm.springclouddomain1.config;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
/**
 * @author renqiuming
 * @date 2020/2/3 下午12:03
 */
@Component
public class UrlFilter  implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
