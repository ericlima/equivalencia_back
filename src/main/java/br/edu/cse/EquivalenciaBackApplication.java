package br.edu.cse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
@SpringBootApplication
public class EquivalenciaBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(EquivalenciaBackApplication.class, args);
	}
	
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("locale/message");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}
	
	
}
