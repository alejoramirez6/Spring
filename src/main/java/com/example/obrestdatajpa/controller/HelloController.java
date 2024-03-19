package com.example.obrestdatajpa.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${app.message}")
    String message;

    @GetMapping("/hola")
    public String holaMundo() {
        System.out.println(message);
        return "Hola mundo que tal vamos el día de hoy de marzo ";
    }

    @GetMapping("/")
    public String bootstrap() {
    return """
            <!doctype html>
            <html lang="en">
              <head>
                <meta charset="utf-8">
                <meta name="viewport" content="width=device-width, initial-scale=1">
                <title>REST CON SPRING VIDEO 5</title>
              </head>
              <body>
                <h1>Hola mundo desde Spring Boot!</h1>
                
                    <a class="btn btn-primary" href="https://www.google.com">Google</a>
                
              </body>
            </html>
            """;
    }

}
