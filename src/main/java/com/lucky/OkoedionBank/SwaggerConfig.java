package com.lucky.OkoedionBank;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        var apiInfo = new ApiInfoBuilder()
                .title("Bank REST API Prototype")
                .version("By Lucky Okoedion")
                .license(null)
                .licenseUrl(null)
                .termsOfServiceUrl("https://github.com/LuckyOkoedion/okoedion-bank")
                .description("A Demo Bank REST API Built with Java Springboot, JPA, and Postgresql")
                .build();

        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo)
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.lucky.OkoedionBank"))
                .paths(PathSelectors.regex("/.*"))
                .build();
    }
}
