package com.sandrone.todoapp.todoapp.configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class ConfigurationCors implements Filter {

    private final Logger log = LoggerFactory.getLogger(ConfigurationCors.class);

    public ConfigurationCors() {
        log.info("SimpleCORSFilter init");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException { }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request= (HttpServletRequest) servletRequest;

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST,DELETE,PUT,OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Max-Age", "180");
        chain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() { }

}
