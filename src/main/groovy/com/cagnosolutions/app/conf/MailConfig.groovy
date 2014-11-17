package com.cagnosolutions.app.conf

import groovy.transform.CompileStatic
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.JavaMailSenderImpl

@CompileStatic
@Configuration
public class MailConfig {

	@Bean(name = "mailSender")
	public JavaMailSender javaMailSender() {
		def javaMailSender = new JavaMailSenderImpl()
		javaMailSender.host = "smtp.mandrillapp.com"
		javaMailSender.port = 587
		javaMailSender.username = "scottiecagno@gmail.com"
		javaMailSender.password = "AyRsB5cI5H4bcrbheDKfzQ"
		javaMailSender.properties.putAll([
		        'mail.transport.protocol': "smtp",
				'mail.smtp.auth' : "true",
				'mail.smtp.starttls.enable': "true",
				'mail.debug': "false"
		])
		return javaMailSender
	}
}
