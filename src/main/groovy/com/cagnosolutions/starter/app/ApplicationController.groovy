package com.cagnosolutions.starter.app
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

import javax.servlet.http.HttpSession
import java.security.Principal
/**
 * Created by Scott Cagno.
 * Copyright Cagno Solutions. All rights reserved.
 */

@Controller
class ApplicationController {

    @RequestMapping(value=["/"], method=[RequestMethod.GET])
    String index() {
        "index"
    }

}

@Controller
class SecurityController {

    @RequestMapping(value=["/login"])
    String login() {
        "login"
    }

    @RequestMapping(value=["/secure/login"], method=[RequestMethod.GET])
    String secureLogin(@RequestParam String forward, HttpSession session, Principal principal) {
        session.setAttribute "authenticated", principal.name
        "redirect:/secure/" + forward
    }
}

@Controller
class ExceptionHandlerController {

    @ExceptionHandler(value=[Exception.class, RuntimeException.class])
    String errors(Exception e, Model model) {
        def stack = []
        for (frame in e.getStackTrace()) {
            stack << frame.toString()
        }
        model.addAllAttributes([message: e.getLocalizedMessage(), exception: stack.join('\n')])
        return "error";
    }
}
