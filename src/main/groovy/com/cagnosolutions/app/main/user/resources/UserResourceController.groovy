package com.cagnosolutions.app.main.user.resources

import com.cagnosolutions.app.main.user.UserService
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

@CompileStatic
@Controller
@RequestMapping(value = "/resource/users")
class UserResourceController {

	@Autowired
	UserService userService

	@Autowired
	UserResourceAssembler userResourceAssembler

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody List<UserResource> getUsers() {
		userResourceAssembler.toResources userService.findAll()
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	@ResponseBody UserResource getUser(@PathVariable Long userId) {
		userResourceAssembler.toResource userService.findOne(userId)
	}
}
