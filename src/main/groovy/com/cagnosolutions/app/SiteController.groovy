package com.cagnosolutions.app
import groovy.transform.CompileStatic
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@CompileStatic
@Controller
class SiteController {

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
