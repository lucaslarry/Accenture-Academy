package org.example.exercicio15;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Exercicio15Application {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Exercicio15Application.class)
                .headless(false)
                .run(args);
    }
}