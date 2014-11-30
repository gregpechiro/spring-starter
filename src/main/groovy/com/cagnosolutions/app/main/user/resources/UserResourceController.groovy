package com.cagnosolutions.app.main.user.resources

import com.cagnosolutions.app.main.user.UserService
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo

@CompileStatic
@Controller
@RequestMapping(value = "/api/users")
class UserResourceController {

	@Autowired
	UserService userService

	@Autowired
	UserResourceAssembler userResourceAssembler

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody List<UserResource> getUsers() {
		def userResource = userResourceAssembler.toResources userService.findAll()
		userResource
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	@ResponseBody UserResource getUser(@PathVariable Long userId) {
		def userResource = userResourceAssembler.toResource userService.findOne(userId)
		userResource.add linkTo(UserResourceController.class).withRel("users")
		userResource
	}
}
