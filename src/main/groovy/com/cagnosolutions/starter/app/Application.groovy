package com.cagnosolutions.starter.app
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

/**
 * Created by Scott Cagno.
 * Copyright Cagno Solutions. All rights reserved.
 */

@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableJpaRepositories("com.cagnosolutions.starter.app.repository")
class Application extends WebSecurityConfigurerAdapter {

    static void main(String[] args) {
        SpringApplication.run Application, args
    }
}
