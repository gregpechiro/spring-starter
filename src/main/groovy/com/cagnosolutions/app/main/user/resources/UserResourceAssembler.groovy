package com.cagnosolutions.app.main.user.resources

import com.cagnosolutions.app.main.user.User
import org.springframework.hateoas.mvc.ResourceAssemblerSupport
import org.springframework.stereotype.Component

@Component
class UserResourceAssembler extends ResourceAssemblerSupport<User, UserResource>{

	UserResourceAssembler() {
		super(UserResourceController.class, UserResource.class)
	}

	def UserResource toResource(User user) {
		createResourceWithId(user.id, user)
	}

	def UserResource instantiateResource(User user) {
		new UserResource(user: user)
	}
}