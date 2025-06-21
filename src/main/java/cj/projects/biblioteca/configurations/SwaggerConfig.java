package cj.projects.biblioteca.configurations;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;


@OpenAPIDefinition(
        info = @Info(
                title = "API Bibliotecas",
                description = "REST API para crear y administrar bibliotecas",
                termsOfService = "www.bibliots.com/termins_y_servicios",
                version = "1.0.0",
                contact = @Contact(
                        name = "Jefferson Chaustre",
                        url = "www.chaustrejeffer.com",
                        email = "chaustrejefferson@gmail.com"
                )
        )
)

public class SwaggerConfig {
}
