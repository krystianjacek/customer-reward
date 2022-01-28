package com.jacek.customerreward.webapp.backend;;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.jacek.customerreward.webapp.backend.spring.CustomerRewardSpringConfig;

@SpringBootApplication
@Import(CustomerRewardSpringConfig.class)
public class CustomerRewardApplication {

	public static void main(final String[] args) {
		SpringApplication.run(CustomerRewardApplication.class, args);
	}

}
