package com.gregpechiro.app.main.user

import com.gregpechiro.app.main.validators.UserRegistrationValidator
import com.gregpechiro.app.main.validators.UserSettingsValidator
import com.gregpechiro.app.main.validators.ValidationWrapper
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.servlet.mvc.support.RedirectAttributes

import javax.validation.Valid

@CompileStatic
@Controller
@RequestMapping(value = "/admin/user")
class UserAdminController {

	@Autowired
	UserService userService

	@Autowired
	ValidationWrapper validationWrapper

	@RequestMapping(method = RequestMethod.GET)
	String viewAll(Model model) {
		model.addAttribute "users", userService.findAll()
		"admin/user"
	}

	@RequestMapping(method = RequestMethod.POST)
	String add(@Valid UserRegistrationValidator userRegistrationValidator, BindingResult bindingResult, RedirectAttributes attr) {
		if (bindingResult.hasErrors()) {
			attr.addFlashAttribute "errors", validationWrapper.bindErrors(bindingResult)
			attr.addFlashAttribute "user", userRegistrationValidator
			attr.addFlashAttribute "alertError", "Unable to save user"
			return "redirect:/admin/user"
		}

		def user = userService.generateFromValidator userRegistrationValidator
		if (!userService.canUpdate(user.id, user.username)) {
			attr.addFlashAttribute "alertError", "Unable to save user. Email is already registered"
			return "redirect:/admin/user"
		}

		if (user.id == null || user.password[0] != '$') {
			user.password = new BCryptPasswordEncoder().encode(user.password)
		}

		user.created = new Date()

		userService.save user
		attr.addFlashAttribute "alertSuccess", "Successfully saved user"
		return "redirect:/admin/user/${user.id}"
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	String view(@PathVariable Long id, Model model) {
		if (!model.containsAttribute("user")) {
			model.addAllAttributes([user:userService.findOne(id)])
		}
		model.addAttribute("users", userService.findAll())
		"admin/user"
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	String edit(@Valid UserSettingsValidator userSettingsValidator, BindingResult bindingResult, RedirectAttributes attr) {
		if (bindingResult.hasErrors()) {
			attr.addFlashAttribute "errors", validationWrapper.bindErrors(bindingResult)
			attr.addFlashAttribute "user", userSettingsValidator
			attr.addFlashAttribute "alertError", "Unable to save user"
			return "redirect:/admin/user/${userSettingsValidator.id}"
		}

		def user = userService.generateFromValidator userSettingsValidator
		if (!userService.canUpdate(user.id, user.username)) {
			attr.addFlashAttribute "alertError", "Unable to save user. Email is already registered"
			return "redirect:/admin/user/${user.id}"
		}

		User existingUser = userService.findOne(user.id)
		user.password = (user.password == "") ? null : user.password
		userService.mergeProperties(user, existingUser)

		if (existingUser.password[0] != '$') {
			existingUser.password = new BCryptPasswordEncoder().encode(existingUser.password)
		}

		userService.save existingUser
		attr.addFlashAttribute "alertSuccess", "Successfully saved user"
		return "redirect:/admin/user/${user.id}"
	}

	@RequestMapping(value = "/del/{id}", method = RequestMethod.POST)
	String delete(@PathVariable Long id, RedirectAttributes attr) {
		userService.delete id
		attr.addFlashAttribute("alertSuccess", "Successfully deleted user")
		"redirect:/admin/user"
	}
}
