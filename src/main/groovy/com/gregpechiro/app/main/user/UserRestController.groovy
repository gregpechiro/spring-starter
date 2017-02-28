package com.gregpechiro.app.main.user

import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.*

@CompileStatic
@RestController
@RequestMapping("/rest/user")
@CrossOrigin(methods = [RequestMethod.OPTIONS, RequestMethod.POST, RequestMethod.GET])
class UserRestController {

	@Autowired
	UserService userService

	@RequestMapping(method = RequestMethod.GET)
	List<User> getAllUsers() {
		userService.findAll()
	}

	@RequestMapping(method = RequestMethod.POST)
	User addUser(@RequestBody User user) {
		if (!userService.canUpdate(user.id, user.username)) {
			return null
		}

		if (user.id == null || user.password[0] != '$') {
			user.password = new BCryptPasswordEncoder().encode(user.password)
		}

		user.created = new Date()

		userService.save user
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	User getUser(@PathVariable Long id) {
		userService.findOne id
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	User updateUser(@RequestBody User user) {
		if (!userService.canUpdate(user.id, user.username)) {
			return null
		}

		User existingUser = userService.findOne(user.id)
		user.password = (user.password == "") ? null : user.password
		userService.mergeProperties(user, existingUser)

		if (existingUser.password[0] != '$') {
			existingUser.password = new BCryptPasswordEncoder().encode(existingUser.password)
		}

		userService.save existingUser

		existingUser
	}


	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	def deleteUser(@PathVariable Long id) {
		userService.delete id
	}
}
