package com.example.springboothttpsecurity.config;

import com.example.springboothttpsecurity.filter.PubFilter;
import com.example.springboothttpsecurity.repository.StudentRepository;
import com.example.springboothttpsecurity.repository.TeacherRepository;
import com.example.springboothttpsecurity.service.SignupService;
import com.example.springboothttpsecurity.service.StudentService;
import com.example.springboothttpsecurity.service.TeacherService;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.List;

@org.springframework.context.annotation.Configuration
/*Inversion of Control*/
public class Configuration {
    @Bean
    public StudentService buildStudentService(){
        return new StudentService();
    }
    @Bean
    public TeacherService buildTeacherService(){
        return new TeacherService();
    }
    @Bean
    public SignupService buildSignupService(){
        return new SignupService();
    }
    @Bean
    public StudentRepository buildStudentRepository(){
        return new StudentRepository();
    }
    @Bean
    public TeacherRepository buildTeacherRepository(){
        return new TeacherRepository();
    }
    @Bean
    public FilterRegistrationBean<Filter> filterRegistrationBean(){
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        List<String> patterns = new ArrayList<>();
        patterns.add("/club");
        filterRegistrationBean.setUrlPatterns(patterns);
        filterRegistrationBean.setFilter(new PubFilter());
        return filterRegistrationBean;

    }
}
