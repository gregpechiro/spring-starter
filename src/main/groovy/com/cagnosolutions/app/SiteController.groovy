package com.cagnosolutions.app

import com.cagnosolutions.app.main.user.User
import com.cagnosolutions.app.main.user.UserService
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.servlet.mvc.support.RedirectAttributes

@CompileStatic
@Controller
class SiteController {

	@Autowired
	UserService userService

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	String registerUser(User user, RedirectAttributes attr) {
		if(userService.canUpdate(user.id, user.username)) {
			if(user.id == null || user.password[0] != '$')
				user.password = new BCryptPasswordEncoder().encode(user.password)
			userService.save user
			attr.addFlashAttribute "alertSuccess", "Thank you for registering!"
			return "redirect:/login"
		}
		attr.addFlashAttribute "alertError", "Sorry, there was an error registering"
		"redirect:/register"
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	String index() {
		"redirect:/home"
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	String home() {
		"home"
	}

	@RequestMapping(value = "/terms", method = RequestMethod.GET)
	String terms() {
		"terms"
	}

	@RequestMapping(value = "/privacy", method = RequestMethod.GET)
	String privacy() {
		"privacy"
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	String register() {
		"register"
	}

	@RequestMapping(value = "/login")
	String login() {
		"login"
	}
}
