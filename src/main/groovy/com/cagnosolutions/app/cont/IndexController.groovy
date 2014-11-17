package com.cagnosolutions.app.cont

import groovy.transform.CompileStatic
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@CompileStatic
@Controller
class IndexController {
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    String index() {
        "boilerplate"
    }
}


