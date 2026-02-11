package com.vegayan.globallogin.component;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;


@Component
public class SamlAcsDebugFilter extends OncePerRequestFilter {

    private static final Logger log =
            LoggerFactory.getLogger(SamlAcsDebugFilter.class);

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        if (request.getRequestURI().contains("/login/saml2/sso")) {
            System.out.println("AWS SSO HIT ACS ENDPOINT");
            System.out.println("URI: " + request.getRequestURI());
            System.out.println("Method: " + request.getMethod());
        }

        filterChain.doFilter(request, response);
    }
}
