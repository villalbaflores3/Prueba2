package com.apply;

import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvConfig  implements WebMvcConfigurer{

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        
        String resourcePath = Paths.get("upload").toAbsolutePath().toUri().toString();
 
        WebMvcConfigurer.super.addResourceHandlers(registry);
        registry.addResourceHandler("/upload/**")
        .addResourceLocations(resourcePath); 
    }
    


}
