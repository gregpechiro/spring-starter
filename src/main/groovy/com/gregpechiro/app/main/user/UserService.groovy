package com.gregpechiro.app.main.user

import com.gregpechiro.app.main.validators.UserRegistrationValidator
import com.gregpechiro.app.main.validators.UserSettingsValidator
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@CompileStatic
@Service(value = "userService")
class UserService {

    @Autowired
    UserRepository repo

    List<User> findAll() {
        repo.findAll()
    }

    Page<User> findAll(int page, int size, String... fields) {
        repo.findAll(new PageRequest(page, size, Sort.Direction.ASC, fields))
    }

    boolean canUpdate(Long id, String username) {
        (repo.canUpdate((id == null) ? 0L : id, username) == 0)
    }

    User findOne(Long id) {
        repo.findOne id
    }

    User findOne(String username) {
        repo.findOne username
    }

    User save(User user) {
        repo.save user
    }

    def delete(Long id) {
        repo.delete id
    }

	User generateFromValidator(UserSettingsValidator userSettingsValidator) {
		def user = new User()
		mergeProperties userSettingsValidator, user
		user
	}

	User generateFromValidator(UserRegistrationValidator userRegistrationValidator) {
		def user = new User()
		mergeProperties userRegistrationValidator, user
		user
	}

	def mergeProperties(source, target) {
		source.properties.each { key, value ->
			if (target.hasProperty(key as String) && !(key in ['class', 'metaClass']) && value != null)
				target[key as String] = value
		}
	}

}

