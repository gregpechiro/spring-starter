package com.cagnosolutions.app.cont

import com.cagnosolutions.app.main.user.UserService
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

import javax.servlet.http.HttpSession
import java.security.Principal

@CompileStatic
@Controller
class AuthController {

	@Autowired
	UserService userService

	@RequestMapping(value = "/login")
	String login() {
		"login"
	}

	@RequestMapping(value = "/secure/login", method = RequestMethod.GET)
	String secureLogin(@RequestParam String forward, HttpSession session, Principal principal) {
		if (principal.name != "admin") {
			def user = userService.findOne principal.name
			user.lastSeen = System.currentTimeMillis()
			userService.save user
		}
		session.setAttribute "authenticated", principal.name
		"redirect:/secure/$forward"
	}
}
