package com.cagnosolutions.app.main.user.resources

import com.cagnosolutions.app.main.user.User
import org.springframework.hateoas.mvc.ResourceAssemblerSupport
import org.springframework.stereotype.Component
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo

@Component
class UserResourceAssembler extends ResourceAssemblerSupport<User, UserResource> {

	UserResourceAssembler() {
		super(UserResourceController.class, UserResource.class)
	}

	UserResource toResource(User user) {
		def resource = createResourceWithId(user.id, user)
		resource.add linkTo(UserResourceController.class).withRel("users")
		resource
	}

	List<UserResource> toResources(Iterable<User> users) {
		def resources = new ArrayList<UserResource>()
		users.each { resources.add createResourceWithId(it.id, it) }
		resources
	}

	UserResource instantiateResource(User user) {
		new UserResource(user: user)
	}
}
