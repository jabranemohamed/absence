package com.mhj.absence.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Value("${controle.package.path}")
    private String package_path;

    @Value("${api.version.number}")
    private String api_version;

    @Value("${api.title.label}")
    private String api_title;

    @Value("${api.description.label}")
    private String api_description;

    @Value("${api.termeOfService.label}")
    private String api_termineOfService;

    @Value("${api.contactName.label}")
    private String api_contactName;

    @Value("${api.license.label}")
    private String api_license;

    @Value("${api.licenseUrl.label}")
    private String api_licenseURL;


    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.mhj.absence.ui.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaInfo())
                .securitySchemes(Arrays.asList(apiKey()));
    }

    private ApiInfo metaInfo() {

        ApiInfo apiInfo = new ApiInfo(
                api_title,
                api_description,
                api_version,
                api_termineOfService,
                api_contactName,
                api_license,
                api_licenseURL
        );

        return apiInfo;
    }

    private ApiKey apiKey() {
        return new ApiKey("apiKey", "Authorization", "header");
    }
}
