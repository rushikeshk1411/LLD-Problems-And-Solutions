package com.vegayan.globallogin.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.saml2.provider.service.authentication.Saml2AuthenticatedPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @GetMapping("/me")
    public Map<String, Object> me(Authentication authentication) {

        Saml2AuthenticatedPrincipal principal =
                (Saml2AuthenticatedPrincipal) authentication.getPrincipal();

        Map<String, Object> result = new HashMap<>();
        result.put("username", principal.getName());
        result.put("email", principal.getFirstAttribute("email"));
        result.put("attributes", principal.getAttributes());

        return result;
    }

    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}
