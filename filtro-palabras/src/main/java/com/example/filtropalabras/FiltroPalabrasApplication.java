package com.example.filtropalabras;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class FiltroPalabrasApplication {

    public static void main(String[] args) {
        SpringApplication.run(FiltroPalabrasApplication.class, args);
    }
}