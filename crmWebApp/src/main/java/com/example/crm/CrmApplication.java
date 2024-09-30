package com.example.crm;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@OpenAPIDefinition(
    info = @Info(
        title = "CRM API",
        version = "1.0",
        description = "API documentation for the CRM application"
    ),
    servers = @Server(url = "/", description = "http")
)
@SpringBootApplication(scanBasePackages = {"com.example.crm", "user.com", "lead.com","opportunity.com","learners.com","courses.com"})
@EnableJpaRepositories(basePackages = {"user.com", "lead.com","opportunity.com","learners.com","courses.com"})  // Enable JPA repositories
@EntityScan(basePackages = {"user.com", "lead.com","opportunity.com","learners.com","courses.com"})

public class CrmApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrmApplication.class, args);
    }
}
