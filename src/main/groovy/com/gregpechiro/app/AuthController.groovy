package com.gregpechiro.app

import com.gregpechiro.app.main.user.UserService
import com.gregpechiro.app.main.user.UserSession
import com.gregpechiro.app.main.validators.UserRegistrationValidator
import com.gregpechiro.app.main.validators.ValidationWrapper
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.mvc.support.RedirectAttributes

import javax.validation.Valid
import java.security.Principal

@CompileStatic
@Controller
class AuthController {

	@Autowired
	UserService userService

	@Autowired
	UserSession userSession

	@Autowired
	ValidationWrapper validationWrapper

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	String registerUser(@Valid UserRegistrationValidator userRegistrationValidator, BindingResult bindingResult, RedirectAttributes attr) {

		if (bindingResult.hasErrors()) {
			attr.addFlashAttribute "errors", validationWrapper.bindErrors(bindingResult)
			attr.addFlashAttribute "user", userRegistrationValidator
			attr.addFlashAttribute "alertError", "Unable to update your information"
			return "redirect:/login"
		}

		def user = userService.generateFromValidator userRegistrationValidator

		if(!userService.canUpdate(user.id, user.username)) {
			attr.addFlashAttribute "alertError", "Sorry that email is already registered"
			attr.addFlashAttribute "user", user
			return "redirect:/login"
		}
		if(user.id == null || user.password[0] != '$') {
			user.password = new BCryptPasswordEncoder().encode(user.password)
		}
		user.created = new Date()
		userService.save user
		attr.addFlashAttribute "alertSuccess", "Thank you for registering! Please login"
		return "redirect:/login"
	}

	@RequestMapping(value = "/login/success", method = RequestMethod.GET)
	String customLoginSuccessHandler(Principal principal, @RequestParam String role, @RequestParam String redirect) {
		def user = userService.findOne principal.name

		if (user != null) {
			user.lastSeen = new Date()
			userService.save user
			userSession.id = user.id
			userSession.email = user.username
		}
		userSession.role = role

		if (redirect == "") {
			if (role == "user") {
				return "redirect:/user"
			}
			if (role == "admin") {
				return "redirect:/admin"
			}
		}

		"redirect:${redirect}"

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	String login(Model model) {
		model.addAttribute "login", true
		"login"
	}

}