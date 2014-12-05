package com.cagnosolutions.app.main.user

import groovy.transform.CompileStatic
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@CompileStatic
@Entity
@Table(name = "user")
class User {

    @Id
    @GeneratedValue
    Long id
    String fname, lname, username, password, role = "ROLE_USER"
    Short active = 1
}
