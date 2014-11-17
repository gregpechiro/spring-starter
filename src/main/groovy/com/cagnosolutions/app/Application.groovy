package com.cagnosolutions.app

import groovy.transform.CompileStatic
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@CompileStatic
@ComponentScan
@Configuration
@EnableJpaRepositories
@EnableAutoConfiguration
class Application {
    static void main(String... args) {
        SpringApplication.run Application, args
    }
}



