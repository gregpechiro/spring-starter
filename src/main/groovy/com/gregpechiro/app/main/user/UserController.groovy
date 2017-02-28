package com.gregpechiro.app.main.user

import com.gregpechiro.app.main.validators.UserSettingsValidator
import com.gregpechiro.app.main.validators.ValidationWrapper
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.servlet.mvc.support.RedirectAttributes

import javax.validation.Valid

@CompileStatic
@Controller
@RequestMapping(value = "/user")
class UserController {

    @Autowired
    UserService userService

	@Autowired
	UserSession userSession

	@Autowired
	ValidationWrapper validationWrapper

	@RequestMapping(method = RequestMethod.GET)
	String userHome(Model model) {
		def userId = userSession.id
		if (!model.containsAttribute("user")) {
			model.addAllAttributes([user:userService.findOne(userId)])
		}
		"user/home"
	}

	@RequestMapping(method = RequestMethod.POST)
	String userSave(@Valid UserSettingsValidator userSettingsValidator, BindingResult bindingResult, RedirectAttributes attr) {

		if (bindingResult.hasErrors()) {
			attr.addFlashAttribute "errors", validationWrapper.bindErrors(bindingResult)
			attr.addFlashAttribute "user", userSettingsValidator
			attr.addFlashAttribute "alertError", "Unable to update your information"
			return "redirect:/user"
		}

		def user = userService.generateFromValidator userSettingsValidator
		if(!userService.canUpdate(user.id, user.username)) {
			attr.addFlashAttribute "alertError", "Unable to update your information"
			return "redirect:/user"
		}

		User existingUser = userService.findOne(user.id)
		user.password = (user.password == "") ? null : user.password
		userService.mergeProperties(user, existingUser)

		if (existingUser.password[0] != '$') {
			existingUser.password = new BCryptPasswordEncoder().encode(existingUser.password)
		}

		//existingUser.active = 1
		userService.save existingUser
		attr.addFlashAttribute("alertSuccess", "Updated Successfully")

		"redirect:/user"
	}



}
