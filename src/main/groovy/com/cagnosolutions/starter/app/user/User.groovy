package com.cagnosolutions.starter.app.user

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

/**
 * Created by Scott Cagno.
 * Copyright Cagno Solutions. All rights reserved.
 */

@Entity
@Table(name="user")
class User {

    @Id
    String username
    String password
    String role
    String name
    String email
    Boolean active
    Date creationDate
    Date lastSeenDate
    String uuid

    User() {
        def timestamp = new Date()
        creationDate = timestamp
        lastSeenDate = timestamp
        uuid = UUID.randomUUID().toString()
    }

    void setPassword(String password) {
        this.password = new BCryptPasswordEncoder().encode(password)
    }
}
