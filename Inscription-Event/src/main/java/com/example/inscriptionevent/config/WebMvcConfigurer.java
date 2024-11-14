package com.example.inscriptionevent.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

public abstract class WebMvcConfigurer {

@Bean
public WebMvcConfigurer corsConfigurer() {
return new WebMvcConfigurer() {
@Override
public void addCorsMappings(CorsRegistry registry) {
registry.addMapping("/**")
.allowedOrigins("http://localhost:4200")
.allowedMethods("GET", "POST", "PUT", "DELETE")
.allowedHeaders("*");
}
};
}

 public abstract void addCorsMappings(CorsRegistry registry);
}