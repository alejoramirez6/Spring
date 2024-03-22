package com.example.obrestdatajpa.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/*
Se define un método customOpenApi dentro de una clase de configuración de Spring (OpenApiConfig)
usando la anotación @Bean. Este método crea y devuelve un objeto OpenAPI, que es utilizado por
Swagger para configurar la documentación de la API REST de libros.

El objeto OpenAPI se configura con la información básica de la API, como el título, la descripción,
la versión, el contacto, los términos de servicio y la licencia. Esta información se usa para
generar la documentación de la API en Swagger UI.
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("API REST de libros")
                        .description("API REST de libros")
                        .version("1.0")
                        .contact(new io.swagger.v3.oas.models.info.Contact().email("<EMAIL>"))
                        .termsOfService("http://swagger.io/terms/")
                        .license(new License().name("Apache 2.0").url("http://sprongdoc.org")));
    }
}
