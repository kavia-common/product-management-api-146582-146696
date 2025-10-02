package com.example.productsbackendapi.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OpenAPI configuration with modern, clean metadata reflecting the Ocean Professional theme.
 */
@Configuration
public class OpenApiConfig {

    // PUBLIC_INTERFACE
    @Bean
    public OpenAPI productApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Products API — Ocean Professional")
                        .description("Minimal, modern REST API for Products CRUD. Blue accents. Clean surfaces.")
                        .version("0.1.0")
                        .contact(new Contact().name("Products API Team").email("api@example.com"))
                        .license(new License().name("Apache 2.0").url("https://www.apache.org/licenses/LICENSE-2.0")))
                .externalDocs(new ExternalDocumentation()
                        .description("API Docs")
                        .url("/swagger-ui.html"));
    }
}
