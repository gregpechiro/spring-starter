package com.cagnosolutions.starter.app.user

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * Created by Scott Cagno.
 * Copyright Cagno Solutions. All rights reserved.
 */

@Entity
class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long id
    String name
    String email
    String username
    String password
    Long active = 1
    String role = "ROLE_USER"
}
