package com.gregpechiro.app

import com.gregpechiro.app.main.user.UserService
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@CompileStatic
@Controller
class SiteController {

	@Autowired
	UserService userService

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
}
