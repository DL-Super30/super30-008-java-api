package com.skillcapital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(scanBasePackages= "com.skillcapital",exclude = {SecurityAutoConfiguration.class})
public class SkillcapitalApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(SkillcapitalApplication.class, args);
		System.out.println(" Web App is Running ");
	}

}
