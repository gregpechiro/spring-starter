package com.cagnosolutions.app.main.user.resources

import com.cagnosolutions.app.main.user.User
import groovy.transform.CompileStatic
import org.springframework.hateoas.mvc.ResourceAssemblerSupport
import org.springframework.stereotype.Component


@CompileStatic
@Component
class UserResourceAssembler extends ResourceAssemblerSupport<User, UserResource>{

	def UserResourceAssembler() {
		super(UserResourceController.class, UserResource.class)
	}

	def UserResource toResource(User user) {
		createResourceWithId user.id, user
	}

	protected UserResource instantiateResource(User user) {
		new UserResource(user: user)
	}
}
