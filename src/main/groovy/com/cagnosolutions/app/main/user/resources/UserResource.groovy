package com.cagnosolutions.app.main.user.resources

import com.cagnosolutions.app.main.user.User
import groovy.transform.CompileStatic
import org.springframework.hateoas.ResourceSupport

@CompileStatic
class UserResource extends ResourceSupport {

	User user

}
