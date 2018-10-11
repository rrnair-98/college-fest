package com.rohan.festapp;

import com.rohan.festapp.utils.config.filter.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FestAppApplication {

    @Bean
    public FilterRegistrationBean tokenFilter(){
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new TokenFilter());
        //registrationBean.addUrlPatterns("*/create/");
        return registrationBean;
    }

    public static void main(String[] args) {
        SpringApplication.run(FestAppApplication.class, args);
    }
}
