package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class config implements WebMvcConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
        .allowedOrigins("*") // permet toutes les origines
        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // permet les méthodes HTTP spécifiées
        .allowedHeaders("*"); // permet tous les en-têtes
  }
}
