package com.gregpechiro.app

import groovy.transform.CompileStatic
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@CompileStatic
@Controller
@RequestMapping(value = "/admin")
class AdminController {

	@RequestMapping(method = RequestMethod.GET)
	String admin() {
		"admin/admin"
	}
}
