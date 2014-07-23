package com.cagnosolutions.starter.app.user
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

/**
 * Created by Scott Cagno.
 * Copyright Cagno Solutions. All rights reserved.
 */

@Controller
@RequestMapping("/secure/user")
class UserController {

    @Autowired
    UserRepository dao

    @RequestMapping(method=[RequestMethod.GET])
    String viewAll(Model model) {
        model.addAttribute "users", dao.findAll()
        "user"
    }

    @RequestMapping(method=[RequestMethod.POST])
    String addOrEdit(User user) {
        user = dao.save user
        "redirect:/user/" + user.id
    }

    @RequestMapping(value=["/{id}"], method=[RequestMethod.GET])
    String view(@PathVariable Long id, Model model) {
        model.addAllAttributes([user: dao.findOne(id), users: dao.findAll()])
        "user"
    }

    @RequestMapping(value=["/{id}"], method=[RequestMethod.POST])
    String delete(@PathVariable Long id) {
        dao.delete id
        "redirect:/user"
    }

}
