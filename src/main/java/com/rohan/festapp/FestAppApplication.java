package com.rohan.festapp;

import com.rohan.festapp.utils.config.filter.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class FestAppApplication {

    @Bean
    public FilterRegistrationBean tokenFilter(){
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new TokenFilter());
        //registrationBean.addUrlPatterns("*/create/");
        return registrationBean;
    }
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:8080").allowedHeaders("GET", "POST", "PUT");
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(FestAppApplication.class, args);
    }
}
