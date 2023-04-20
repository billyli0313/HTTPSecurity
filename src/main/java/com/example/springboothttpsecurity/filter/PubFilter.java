package com.example.springboothttpsecurity.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class PubFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException{
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String ageString = servletRequest.getParameter("age");

        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        int age = Integer.parseInt(ageString);

        if(age<21){
            httpServletResponse.setStatus(HttpStatus.BAD_REQUEST.value());
            httpServletResponse.setContentType("application/json");

            ObjectMapper mapper = new ObjectMapper();
            PrintWriter out =  httpServletResponse.getWriter();
            out.print(mapper.writeValueAsString("You are too young!"));
            out.flush();
        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

}
