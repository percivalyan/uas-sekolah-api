package com.uas.sekolah;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;

import jakarta.servlet.MultipartConfigElement;

@SpringBootApplication
public class SekolahApplication {

    public static void main(String[] args) {
        SpringApplication.run(SekolahApplication.class, args);
    }

    @Bean
public MultipartConfigElement multipartConfigElement() {
    MultipartConfigFactory factory = new MultipartConfigFactory();
    
    // Set maximum file upload size to 100MB
    factory.setMaxFileSize(DataSize.ofMegabytes(100));
    
    // Set maximum request size to 100MB
    factory.setMaxRequestSize(DataSize.ofMegabytes(100));
    
    return factory.createMultipartConfig();
}


    
}
