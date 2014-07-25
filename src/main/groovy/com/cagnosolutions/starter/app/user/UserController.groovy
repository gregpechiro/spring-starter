package com.cagnosolutions.starter.app.user
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.servlet.mvc.support.RedirectAttributes
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
        "user/user"
    }

    @RequestMapping(method=[RequestMethod.POST])
    String addOrEdit(User user, RedirectAttributes attr) {
        if(!user.username.contains(" ")) {
            def userz = dao.findOne user.username
            if((userz == null)||(userz != null && userz.uuid == user.uuid)) {
                dao.save user
                attr.addAttribute "alertSuccess", "Successfully saved user ${user.name}"
                return "redirect:/secure/user/${user.username}"
            }
        }
        attr.addAttribute "alertError", "Unable to save user ${user.name}"
        return "redirect:/secure/user"
    }

    @RequestMapping(value=["/{username}"], method=[RequestMethod.GET])
    String view(@PathVariable String username, Model model) {
        model.addAllAttributes([user: dao.findOne(username) , users: dao.findAll()])
        "user/user"
    }

    @RequestMapping(value=["/{username}"], method=[RequestMethod.POST])
    String delete(@PathVariable String username, RedirectAttributes attr) {
        dao.delete username
        if(dao.exists(username))
            attr.addAttribute "alertError", "Could not remove user."
        else
            attr.addAttribute "alertSuccess", "User has been removed."
        "redirect:/secure/user"
    }

}
