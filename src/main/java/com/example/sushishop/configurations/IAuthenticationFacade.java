package com.example.sushishop.configurations;
import org.springframework.security.core.Authentication;
public interface IAuthenticationFacade {
    Authentication getAuthentication();
}
