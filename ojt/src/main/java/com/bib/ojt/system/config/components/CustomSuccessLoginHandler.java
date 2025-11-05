package com.bib.ojt.system.config.components;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Set;

@Component
public class CustomSuccessLoginHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {

        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        System.out.println("roles" + roles);
    if(roles.contains("ROLE_ADMIN")){
        response.sendRedirect("/admin/dashboard");
        System.out.println("Admin Login");
    }else if(roles.contains("ROLE_USER")){
        response.sendRedirect("/user/dashboard");
        System.out.println("User Login");
    }else{
        response.sendRedirect("/login?logout");
        System.out.println("Access denied");
    }
    }
}
