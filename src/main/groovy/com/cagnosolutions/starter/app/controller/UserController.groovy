package com.cagnosolutions.starter.app.controller
import com.cagnosolutions.starter.app.domain.User
import com.cagnosolutions.starter.app.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
/**
 * Created by Scott Cagno.
 * Copyright Cagno Solutions. All rights reserved.
 */

@Controller
@RequestMapping("/user")
class UserController {

    @Autowired
    UserRepository dao

    @RequestMapping(method=[RequestMethod.GET])
    String home(Model model) {
        model.addAttribute("users", dao.findAll())
        "user"
    }

    @RequestMapping(method=[RequestMethod.POST])
    String addOrEdit(@RequestBody User user) {
        // implement add or edit
    }

    @RequestMapping(value=["/{id}"], method=[RequestMethod.GET])
    String view(@PathVariable Long id, Model model) {
        model.addAttribute("user", dao.findOne(id))
        model.addAttribute("users", dao.findAll())
        "user"
    }

    @RequestMapping(value=["/{id}"], method=[RequestMethod.POST])
    String delete(@PathVariable Long id) {
        // implement delete
    }

}
