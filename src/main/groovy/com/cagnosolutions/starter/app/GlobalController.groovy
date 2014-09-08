package com.cagnosolutions.starter.app

import groovy.transform.CompileStatic
import com.cagnosolutions.starter.app.user.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.core.env.Environment
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.JavaMailSenderImpl
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import javax.servlet.http.HttpSession
import java.security.Principal

/**
 * Created by Scott Cagno.
 * Copyright Cagno Solutions. All rights reserved.
 */

@CompileStatic
@Controller(value = "indexController")
class IndexController {
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    String index() {
        "index"
    }
}

@CompileStatic
@Controller(value = "authController")
class Authentication {

    @Autowired
    UserService userService

    @RequestMapping(value = "/login")
    String login() {
        "login"
    }

    @RequestMapping(value = "/secure/login", method = RequestMethod.GET)
    String secureLogin(@RequestParam String forward, HttpSession session, Principal principal) {
        if(principal.name != "admin") {
            def user = userService.findOne principal.name
            user.lastSeen = System.currentTimeMillis()
            userService.save user
        }
        session.setAttribute "authenticated", principal.name
        "redirect:/secure/$forward"
    }
}

@CompileStatic
@Controller(value = "errorController")
class ErrorHandler {

    @ExceptionHandler(value = [Exception.class, RuntimeException.class])
    String errors(Exception e, Model model) {
        def stack = []
        for (frame in e.getStackTrace()) {
            stack << frame.toString()
        }
        model.addAllAttributes([message: e.getLocalizedMessage(), exception: stack.join('\n')])
        "error"
    }
}

@Configuration
@PropertySource("classpath:application.yml")
public class MailConfig {

	@Autowired
	private Environment env;

	@Bean(name = "mailSender")
	public JavaMailSender javaMailSender() {
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
		javaMailSender.setHost(env.getProperty("mail.host"));
		javaMailSender.setPort(Integer.parseInt(env.getProperty("mail.port")));
		javaMailSender.setUsername(env.getProperty("mail.user"));
		javaMailSender.setPassword(env.getProperty("mail.pass"));
		javaMailSender.setJavaMailProperties(getMailProperties());
		return javaMailSender;
	}

	private Properties getMailProperties() {
		Properties properties = new Properties();
		properties.setProperty("mail.transport.protocol", "smtp");
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.starttls.enable", "true");
		properties.setProperty("mail.debug", "true");
		return properties;
	}
}