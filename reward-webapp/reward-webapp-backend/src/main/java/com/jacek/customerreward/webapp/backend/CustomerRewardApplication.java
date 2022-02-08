package com.jacek.customerreward.webapp.backend;;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.jacek.customerreward.webapp.backend.spring.CustomerRewardSpringConfig;

@SpringBootApplication
@Import(CustomerRewardSpringConfig.class)
public class CustomerRewardApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerRewardApplication.class);
	
	public static void main(final String[] args) {
		SpringApplication.run(CustomerRewardApplication.class, args);
	}
}
