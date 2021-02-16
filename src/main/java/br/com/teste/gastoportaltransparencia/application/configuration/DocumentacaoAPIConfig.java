package br.com.teste.gastoportaltransparencia.application.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DocumentacaoAPIConfig {

    @Bean
    public OpenAPI customOpenAPI(@Value("${app.description}") String appDescricao,
                                 @Value("${app.version}") String appVersao) {
        return new OpenAPI()
                .info(new Info().title("Gastos Portal da Transparência")
                        .version(appVersao)
                        .description(appDescricao)
                        .contact(new Contact().name("Wellington Alves").email("wac.0013@gmail.com"))
                        .termsOfService("http://swagger.io/terms/")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")
                .pathsToMatch("/public/**")
                .build();
    }
    @Bean
    public GroupedOpenApi adminApi() {
        return GroupedOpenApi.builder()
                .group("admin")
                .pathsToMatch("/admin/**")
                .build();
    }
}
