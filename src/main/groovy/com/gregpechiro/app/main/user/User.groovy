package com.gregpechiro.app.main.user
import groovy.transform.CompileStatic

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@CompileStatic
@Entity
class User {

    @Id
    @GeneratedValue
    Long id
    String firstName, lastName, username, password, role = "ROLE_USER"
    Short active = 1
	Date lastSeen, created
}
