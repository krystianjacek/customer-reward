package com.jacek.customerreward.webapp.backend.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({
		"com.jacek.customerreward.webapp.backend.api",
		"com.jacek.customerreward.webapp.backend.controller",
		"com.jacek.customerreward.webapp.backend.dao",
		"com.jacek.customerreward.webapp.backend.service.impl"
})
public class CustomerRewardSpringConfig {
}
