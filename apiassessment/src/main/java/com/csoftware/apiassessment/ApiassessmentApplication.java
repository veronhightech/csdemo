package com.csoftware.apiassessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("com.csoftware") 
@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)


//@SpringBootApplication
public class ApiassessmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiassessmentApplication.class, args);
	}

}
