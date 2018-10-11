package com.rohan.festapp.utils.config.filter;

import com.rohan.festapp.users.model.User;
import com.rohan.festapp.users.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TokenFilter extends GenericFilterBean {

    @Autowired
    private UserRepo userRepo;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;
        String authHeader = request.getHeader("authorization");
        System.out.println("HERE "+authHeader);
        if(authHeader != null && !authHeader.isEmpty()){
            User current= this.userRepo.findByToken(authHeader);
            request.setAttribute("user", current);
            response.setStatus(200);
        }else{
            response.setStatus(403);
        }
        filterChain.doFilter(request, response);

    }
}
