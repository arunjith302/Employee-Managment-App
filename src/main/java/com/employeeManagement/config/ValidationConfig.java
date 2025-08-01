package com.employeeManagement.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class ValidationConfig {
	
	   @Bean
	    public MessageSource messageSource() {
	        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
	        source.setBasename("messages");
	        source.setDefaultEncoding("UTF-8");
	        return source;
	    }

	    @Bean
	    public LocalValidatorFactoryBean getValidator() {
	        LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
	        factory.setValidationMessageSource(messageSource());
	        return factory;
	    }

}
