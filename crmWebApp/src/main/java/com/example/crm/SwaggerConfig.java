package com.example.crm;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration



@OpenAPIDefinition(info = @Info(title = "User Management", version = "2.0", description = "API documentation for CRM application"))
public class SwaggerConfig {

    @Bean
    GroupedOpenApi userApi() {
        return GroupedOpenApi.builder()
                .group("user")
                .packagesToScan("user.com.controller") 
                .build();
    }

    @Bean
    GroupedOpenApi leadApi() {
        return GroupedOpenApi.builder()
                .group("lead")
                .packagesToScan("lead.com.controller") 
                .build();
    }

    @Bean
    GroupedOpenApi opportunityApi() {
        return GroupedOpenApi.builder()
                .group("opportunity")
                .packagesToScan("opportunity.com.controller")  
                .build();
    }
    @Bean
    GroupedOpenApi learnerApi() {
        return GroupedOpenApi.builder()
                .group("learners")
                .packagesToScan("learners.com.controller")  
                .build();
    }
    @Bean
    GroupedOpenApi coursesApi() {
        return GroupedOpenApi.builder()
                .group("courses")
                .packagesToScan("courses.com.controller")  
                .build();
    }
  


}










