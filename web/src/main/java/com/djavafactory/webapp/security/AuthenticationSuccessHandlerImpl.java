package com.djavafactory.webapp.security;

import com.djavafactory.model.Role;
import com.djavafactory.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

/**
 * @author aka
 * @date: 06 June 2015
 */
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        User user = (User) authentication.getPrincipal();


        String redirectUrl = "home";



        response.sendRedirect(redirectUrl);

    }
}
