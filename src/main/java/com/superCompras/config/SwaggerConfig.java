package com.superCompras.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

//Url para ver los Endpoints
//http://localhost:8080/swagger-ui/index.html#/

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("App-SuperCompras",
                "Tp Curso Java Spring - Codo a Codo - Gob. Ciudad de Buenos Aires - Año 2022",
                "1.0",
                "http://www.apache.org/licenses/LICENSE-2.0.html",
                new Contact("Alejandro Nicolini", "https://linktr.ee/alejandronicolini", "nicolinialejandro@gmail.com"),
                "MIT",
                "https://linktr.ee/alejandronicolini",
                Collections.emptyList());
    }


}
