package br.com.padaria.gestaopadaria;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GestaoPadariaApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestaoPadariaApplication.class, args);
    }

    @Bean
    public OpenAPI openApiConfig() {
        return new OpenAPI().info(apiInfo());
    }

    private Info apiInfo() {
        return new Info()
                .title("Gestão de uma padaria")
                .description("Sistema que gere o cadastro de funcionários")
                .version("1.0.0");
    }

}
